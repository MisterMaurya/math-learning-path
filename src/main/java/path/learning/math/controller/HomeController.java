package path.learning.math.controller;

import java.security.Principal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import path.learning.math.dao.impl.FeedbackDAOImpl;
import path.learning.math.dao.impl.QuizDAOImpl;
import path.learning.math.dao.impl.TutorialFileDAOImpl;
import path.learning.math.dao.impl.UserDAOImpl;
import path.learning.math.dao.impl.UserRolesDAOImpl;
import path.learning.math.dao.impl.UsersDAOImpl;
import path.learning.math.dao.impl.VideoTutorialFileDAOImpl;
import path.learning.math.model.Feedback;
import path.learning.math.model.QuizMe;
import path.learning.math.model.TutorialFile;
import path.learning.math.model.User;
import path.learning.math.model.UserRoles;
import path.learning.math.model.Users;
import path.learning.math.service.DateAndTime;
import path.learning.math.service.GetWho;
import path.learning.math.service.ToConnect;

@Controller
public class HomeController {
	@Autowired
	UserDAOImpl obj;
	@Autowired
	UserRolesDAOImpl uroles;
	@Autowired
	UsersDAOImpl us;
	@Autowired
	ToConnect connection;
	@Autowired
	TutorialFileDAOImpl add;
	@Autowired
	VideoTutorialFileDAOImpl add2;
	@Autowired
	FeedbackDAOImpl feed;
	@Autowired
	QuizDAOImpl oq;
	@Autowired
	GetWho who;

	@RequestMapping("/")
	public String getLandingPage() {
		return "index";
	}

	@RequestMapping("/contact")
	public String getContactPage() {
		return "contactus";
	}

	@RequestMapping("/aboutUs")
	public String getAboutUSPage() {
		return "aboutus";
	}

	@RequestMapping("/login")
	ModelAndView getLoginPage() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	/********** User New Registration Business Logic **********/

	@RequestMapping(value = ("/register"), method = RequestMethod.GET)
	public ModelAndView getRegisterPage() {
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("users", new User());
		return mv;
	}

	@RequestMapping(value = ("insert"), method = RequestMethod.POST)
	public ModelAndView insertCustomer(@Valid @ModelAttribute("users") User user, BindingResult res) {
		if (res.hasErrors()) {
			ModelAndView mv = new ModelAndView("register");
			System.out.println("error");
			return mv;
		} else {
			boolean check;
			String email = user.getEmail();
			System.out.println("*" + user.getGender() + "*");
			System.out.println(user.getGender());
			DateAndTime date = new DateAndTime();
			user.setDate(date.date());
			user.setTime(date.time());
			check = obj.addUser(user);
			if (check) {
				Users users = new Users();
				users.setEnabled(1);
				users.setEmail(user.getEmail());
				users.setPassword(user.getPassword());
				us.addToUsers(users);
				UserRoles userRoles = new UserRoles();
				userRoles.setEmail(user.getEmail());
				userRoles.setRole("ROLE_USER");
				uroles.setRole(userRoles);
				ModelAndView mv = new ModelAndView("login");
				mv.addObject("name", user.getName());
				mv.addObject("success", "You have successfully registered!");
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("register");
				mv.addObject("error", " already exsist");
				mv.addObject("email", email);
				mv.addObject("user", new User());
				return mv;
			}
		}
	}

	/********** End New Registration Logic **********/

	/********** User Profile/EditProfile Business Logic **********/

	@RequestMapping("/user")
	public ModelAndView userLandingPage(Principal principal) {
		System.out.println("i am here....----------------->>");
		ModelAndView mv = new ModelAndView("profile");
		User user = who.getWho(principal);
		System.out.println(user);
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping(value = ("/user/editprofile"), method = RequestMethod.GET)
	public ModelAndView getEditProfile(Principal principal) {
		ModelAndView mv = new ModelAndView("editprofile");
		User user = new User();
		String email = principal.getName();
		ResultSet rs = null;
		try {
			Statement st = connection.getStatement();
			rs = st.executeQuery("select * from user where email ='" + email + "'");
			if (rs.next()) {
				user.setContact(rs.getString("contact"));
				user.setDob(rs.getString("dob"));
				user.setGender(rs.getString("gender"));
				user.setName(rs.getString("name"));
				user.setEmail(email);
				user.setPassword(rs.getString("password"));
				user.setUserid(rs.getInt("userid"));
				user.setTime(rs.getString("time"));
				user.setDate(rs.getString("date"));
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public ModelAndView profileEdit(User user) {
		ModelAndView mv = new ModelAndView("profile");
		obj.updateUser(user);
		String password = user.getPassword();
		String email = user.getEmail();
		us.updatePassword(password, email);
		mv.addObject("update", "Your profile was successfully updated");
		return mv;

	}

	/********** End Profile/Update Logic **********/

	/********** Logout Session Logic **********/

	@RequestMapping("/user/logout")
	public ModelAndView logout(HttpServletRequest req) {
		try {
			req.logout();
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	@RequestMapping("/admin/logout")
	public ModelAndView adminLogout(HttpServletRequest req) {
		try {
			req.logout();
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	/********** End Logout Logic **********/

	/********** User File Tutorial Business Logic **********/

	@RequestMapping(value = "/user/userpdf", method = RequestMethod.GET)
	public ModelAndView pdfFile(TutorialFile file, Principal principal) {
		User user = who.getWho(principal);
		ModelAndView mv = new ModelAndView("userpdf");
		mv.addObject("list", add.getAllFile());
		mv.addObject("user", user);
		return mv;
	}

	/********** End File Tutorial Logic **********/

	/********** User Stream Tutorial Business Logic **********/

	@RequestMapping(value = ("/user/watchvideo"), method = RequestMethod.GET)
	public ModelAndView getVideoDetails(Principal principal) {
		User user = who.getWho(principal);
		ModelAndView mv = new ModelAndView("uservideo");
		mv.addObject("list", add2.getAllFile());
		mv.addObject("user", user);
		return mv;
	}

	/********** End Stream Tutorial Logic **********/

	/********** Play Quiz Business Logic **********/

	@RequestMapping("/user/playquiz")
	public ModelAndView getQuiz(Principal principal, QuizMe quiz) {
		User user = who.getWho(principal);
		ModelAndView mv = new ModelAndView("playquiz");
		mv.addObject("user", user);

		List<QuizMe> list2 = oq.getAllQuiz();
		List<QuizMe> list = new ArrayList<QuizMe>();
		Random random = new Random();

		for (int i = 1; i <= 5 && !list2.isEmpty(); i++) {
			int index = random.nextInt(list2.size());
			list.add(list2.get(index));
			System.out.println(list2.get(index));
			list2.remove(index);
		}
		mv.addObject("list", list);
		return mv;
	}

	/********** End Quiz Logic **********/

	@RequestMapping("/user/quiz/score")
	public ModelAndView getScore(HttpServletRequest req, Principal principal) {
		User user = who.getWho(principal);
		int score = 0;
		for (int i = 1; i < 6; i++) {
			ResultSet rs = null;
			try {
				Statement st = connection.     	getStatement();
				rs = st.executeQuery("select * from quizme where quizid ='" + req.getParameter("id" + i) + "'");
				if (rs.next()) {
					if (rs.getString("res").equals(req.getParameter("r" + i))) {
						score = score + 1;
					} else {
						continue;
					}
				}
			} catch (Exception e) {
				System.out.println("Exception " + e);
			}
		}

		ModelAndView mv = new ModelAndView("score");
		mv.addObject("score", score);
		mv.addObject("user", user);
		return mv;

	}

	/********** Feedback Business Logic **********/

	@RequestMapping(value = ("/user/feedback"), method = RequestMethod.GET)
	public ModelAndView getFeedbackForm(Principal principal) {
		User user = who.getWho(principal);
		ModelAndView mv = new ModelAndView("feedback");
		mv.addObject("flist", feed.getAllFeedbacks());
		mv.addObject("feedback", new Feedback());
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping(value = ("user/sendfeedback"), method = RequestMethod.POST)
	public ModelAndView sendFeedback(@Valid @ModelAttribute("feedback") Feedback feedback, BindingResult res,
			Principal principal) {

		if (res.hasErrors()) {
			ModelAndView mv = new ModelAndView("feedback");
			mv.addObject("flist", feed.getAllFeedbacks());
			return mv;
		} else {
			User user = who.getWho(principal);

			DateAndTime date = new DateAndTime();
			feedback.setDate(date.date());
			feedback.setTime(date.time());
			feed.sendFeedback(feedback);
			ModelAndView mv = new ModelAndView("profile");
			mv.addObject("success", "Thank You! Your Submission has been Received.");
			mv.addObject("user", user);
			return mv;
		}
	}

	/********** End Feedback Logic **********/

	@RequestMapping("/auth")
	public ModelAndView userLandingPageWithGoogle(Principal principal) {
		ModelAndView mv = new ModelAndView("profile");
		// User user = who.getWho(principal);
		// System.out.println(user);
		// mv.addObject("user", user);
		return mv;
	}

}
