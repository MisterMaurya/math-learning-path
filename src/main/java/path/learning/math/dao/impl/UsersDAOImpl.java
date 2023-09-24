package path.learning.math.dao.impl;

import java.sql.Statement;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import path.learning.math.dao.UsersDAO;
import path.learning.math.model.Users;
import path.learning.math.service.ToConnect;
import path.learning.math.service.ToConnectHibernate;

@Transactional
@Repository
public class UsersDAOImpl implements UsersDAO {

	@Autowired
	ToConnectHibernate connect;
	@Autowired
	ToConnect connection;

	public boolean addToUsers(Users user) {

		try {
			Session session = connect.getSession();
			Transaction t = session.beginTransaction();
			session.save(user);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

	public boolean updatePassword(String password,String email) {

		try {
			Statement st = connection.getStatement();
			st.executeUpdate("UPDATE Users SET password='"+password+"' WHERE email ='" + email + "'");
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}

	}
}
