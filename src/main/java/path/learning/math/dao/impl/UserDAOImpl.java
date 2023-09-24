package path.learning.math.dao.impl;

import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import path.learning.math.dao.UserDAO;
import path.learning.math.model.User;
import path.learning.math.service.ToConnect;
import path.learning.math.service.ToConnectHibernate;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
    ToConnectHibernate connect;
	@Autowired
    ToConnect connection;
	List<User> list;

	public boolean addUser(User user) {

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

	public boolean updateUser(User user) {

		try {
			Session session = connect.getSession();
			Transaction t = session.beginTransaction();
			session.update(user);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

	public boolean delete(String email) {
		try {

			Statement st = connection.getStatement();
			st.executeUpdate("delete from user where email ='" + email + "'");
			st.executeUpdate("delete from user_roles where email ='" + email + "'");
			st.executeUpdate("delete from users where email ='" + email + "'");
			
			return true;

		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		try {
			Session session = connect.getSession();
			Transaction t = session.beginTransaction();
			list = (List<User>) session.createQuery("FROM User").list();
			t.commit();
			session.close();
			return list;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return null;
		}
	}

}
