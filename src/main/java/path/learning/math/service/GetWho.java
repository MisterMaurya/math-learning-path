package path.learning.math.service;

import java.security.Principal;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import path.learning.math.model.User;
@Service
public class GetWho {

	@Autowired
	ToConnect connection;
	public User getWho(Principal principal){
	ResultSet rs = null;
	User user = new User();
	String email = principal.getName();
	try {

		Statement st = connection.getStatement();
		rs = st.executeQuery("select * from user where email ='" + email + "'");
		if (rs.next()) {
			user.setName(rs.getString("name"));

		}
	} catch (Exception e) {
		System.out.println("Exception " + e);
	}
	return user;
}}
