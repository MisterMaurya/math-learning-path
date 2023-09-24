package path.learning.math.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import path.learning.math.dao.impl.FeedbackDAOImpl;
import path.learning.math.dao.impl.QuizDAOImpl;
import path.learning.math.dao.impl.TutorialFileDAOImpl;
import path.learning.math.dao.impl.UserDAOImpl;
import path.learning.math.dao.impl.VideoTutorialFileDAOImpl;
import path.learning.math.model.Feedback;
import path.learning.math.model.QuizMe;
import path.learning.math.model.TutorialFile;
import path.learning.math.model.VideoTutorialFile;
import path.learning.math.service.ToConnectHibernate;

@Controller
public class AdminController {

	@Autowired
	UserDAOImpl obj;
	@Autowired
	QuizDAOImpl oq;
	@Autowired
	TutorialFileDAOImpl add;
	@Autowired
	ToConnectHibernate connect;
	@Autowired
	ServletContext context;
	@Autowired
	VideoTutorialFileDAOImpl add2;
	@Autowired
	FeedbackDAOImpl feed;


	@RequestMapping(value = { "/admin", "/admin/adminpage" })
	public String adminPage() {
		return "adminpage";
	}

	@RequestMapping(value = { "/logfail" })
	public ModelAndView logFail() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("msg", "Login failed wrong user credentials!");
		return mv;
	}

	@RequestMapping(value = ("/admin/filetutorial"), method = RequestMethod.GET)
	public ModelAndView getRegisterPage(@ModelAttribute("document") TutorialFile file) {
		ModelAndView mv = new ModelAndView("filetutorial");

		mv.addObject("list", add.getAllFile());
		return mv;

	}

	@RequestMapping(value = ("/admin/videotutorial"), method = RequestMethod.GET)
	public ModelAndView getVideoDetails(@ModelAttribute("document") VideoTutorialFile file) {
		ModelAndView mv = new ModelAndView("videotutorial");

		mv.addObject("list", add2.getAllFile());
		return mv;

	}

	@RequestMapping(value = "admin/savefile", method = RequestMethod.POST)
	public ModelAndView fileUpload(@Valid @ModelAttribute("document") TutorialFile file, BindingResult result,
			ModelMap model, HttpServletRequest request) throws IOException {
		ModelAndView mv = new ModelAndView("filetutorial");
		boolean res = false;
		String filePath = null;
		if (result.hasErrors()) {
			mv.addObject("tutorialfile", new TutorialFile());
			mv.addObject("msg", "Error Ocuur");
			return mv;
		} else {
			try {filePath = getHomePath()
					+ file.getFileTitle() + ".pdf";
				file.setFileLocation(filePath);
				res = add.saveFile(file);
				mv.addObject("list", add.getAllFile());

			} catch (Exception e) {
				System.out.println("Exception(ADD): " + e);
			}
			if (res) {
				System.out.println(filePath);
				MultipartFile m = file.getFile();
				System.out.println(m);
				File dir = new File(filePath);
				if (!m.isEmpty()) {
					try {
						byte[] bytes = file.getFile().getBytes();
						BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(dir));
						stream.write(bytes);
						stream.close();
						System.out.println("File uploaded");
						mv.addObject("tutorialfile", new TutorialFile());
						mv.addObject("msg", "Upload File Sucessfully");
						mv.addObject("list", add.getAllFile());
						return mv;
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			} else {
				mv.addObject("duplicate", "Duplicate File Entry");
				return mv;
			}
		}
		mv.addObject("tutorialfile", new TutorialFile());
		mv.addObject("msg", "File Does'nt upload");
		mv.addObject("list", add.getAllFile());
		return mv;
	}

	@RequestMapping("/admin/manageuser")
	public ModelAndView getListOfUsersPage() {
		ModelAndView mv = new ModelAndView("manageuser");
		mv.addObject("list", obj.getAllUsers());
		return mv;
	}

	@RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("manageuser");
		String email = req.getParameter("email");
		obj.delete(email);
		mv.addObject("delete", "User delete Successfully");
		mv.addObject("list", obj.getAllUsers());
		return mv;
	}

	@RequestMapping(value = "/admin/filedelete", method = RequestMethod.GET)
	public ModelAndView deleteFile(@ModelAttribute("document") TutorialFile file, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("filetutorial");
		int fileid = Integer.parseInt(req.getParameter("fileId"));
		String fileTitle = req.getParameter("fileTitle");
		boolean res = add.deleteFile(fileid);
		if (res) {
			File delete = new File(getHomePath() + fileTitle + ".pdf");
			delete.delete();
			System.out.println(delete);
			mv.addObject("filedelete", "File delete Successfully");
			mv.addObject("list", add.getAllFile());
			return mv;
		} else {
			System.out.println(fileid);
			mv.addObject("filedelete", "File not deleted");
			mv.addObject("list", add.getAllFile());

			return mv;
		}

	}

	@RequestMapping(value = "/admin/videodelete")
	public ModelAndView deleteVideo(@ModelAttribute("document") VideoTutorialFile file, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("videotutorial");
		String request = req.getParameter("videoId");
		String videoTitle = req.getParameter("videoTitle");
		File videoDelete = new File(getHomePath() + videoTitle + ".mp4");
		int videoId = Integer.parseInt(request);
		System.out.println(videoId);
		add2.deleteById(videoId);
		videoDelete.delete();
		mv.addObject("delete", "Video delete Successfully");
		mv.addObject("list", add2.getAllFile());
		return mv;

	}

	@RequestMapping(value = "admin/savevideo", method = RequestMethod.POST)
	public ModelAndView videoUpload(@Valid @ModelAttribute("document") VideoTutorialFile file, BindingResult result,
			ModelMap model, HttpServletRequest request) throws IOException {
		ModelAndView mv = new ModelAndView("videotutorial");
		boolean res = false;
		if (result.hasErrors()) {
			mv.addObject("file", new VideoTutorialFile());
			mv.addObject("msg", "Error Ocuur");
			return mv;
		} else {
			try {
				file.setFileLocation(getHomePath()+ file.getVideoTitle() + ".mp4");
				res = add2.save(file);
				mv.addObject("list", add2.getAllFile());

			} catch (Exception e) {
				System.out.println("Exception(ADD): " + e);
			}
			if (res) {
				String filePath = getHomePath()+ file.getVideoTitle() + ".mp4";

				System.out.println(filePath);
				MultipartFile m = file.getFile();
				System.out.println(m);
				File dir = new File(filePath);
				if (!m.isEmpty()) {
					try {
						byte[] bytes = file.getFile().getBytes();
						BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(dir));
						stream.write(bytes);
						stream.close();
						System.out.println("File uploaded");
						mv.addObject("tutorialfile", new VideoTutorialFile());
						mv.addObject("msg", "Upload Video Sucessfully");
						mv.addObject("list", add2.getAllFile());
						return mv;
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			} else {
				mv.addObject("duplicate", "Duplicate File Entry");
				return mv;
			}
		}
		mv.addObject("video", new VideoTutorialFile());
		mv.addObject("msg", "Video Does'nt upload");
		mv.addObject("list", add2.getAllFile());
		return mv;
	}

	

	@RequestMapping(value = ("/admin/feedback"))
	public ModelAndView getFeedbacks(Feedback feedback) {
		ModelAndView mv = new ModelAndView("managefeedback");
		mv.addObject("flist", feed.getAllFeedbacks());
		return mv;

	}

	@RequestMapping(value = "/admin/feedback/delete", method = RequestMethod.GET)
	public ModelAndView deleteFeedback(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("managefeedback");
		int id = Integer.parseInt(req.getParameter("id"));
		feed.delete(id);
		mv.addObject("fdelete", "Feedback delete Successfully");
		mv.addObject("flist", feed.getAllFeedbacks());
		return mv;
	}

	/* Quiz Logic */
	
	@RequestMapping(value = ("/admin/quiz"), method = RequestMethod.GET)
	public ModelAndView getQuiz() {
		ModelAndView mv = new ModelAndView("quiz");
		mv.addObject("quiz",new QuizMe());
		mv.addObject("qlist", oq.getAllQuiz());
		return mv;
	}
	
	@RequestMapping(value = {"admin/savequiz","/admin/quiz/savequiz"}, method = RequestMethod.POST)
	public ModelAndView saveQuiz(@ModelAttribute("quiz") QuizMe quiz, BindingResult res) {
		ModelAndView mv = new ModelAndView("quiz");
		oq.addQuiz(quiz);
		mv.addObject("addQuiz", "Quiz Submitted");
		mv.addObject("qlist", oq.getAllQuiz());
		return mv;
	}

	@RequestMapping(value = "/admin/quiz/delete", method = RequestMethod.GET)
	public ModelAndView deleteQuiz(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("quiz");
		int quizid = Integer.parseInt(req.getParameter("quizid"));
		oq.delete(quizid);
		mv.addObject("qdelete", "Quiz delete Successfully");
		mv.addObject("quiz", new QuizMe());
		mv.addObject("qlist", oq.getAllQuiz());
		return mv;
	}
	
	/* End Quiz Logic*/
	private String getHomePath(){
		return System.getProperty("user.home") + File.separator;
	}

}
