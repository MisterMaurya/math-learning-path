package path.learning.math.dao.impl;

import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import path.learning.math.dao.FeedbackDAO;
import path.learning.math.model.Feedback;
import path.learning.math.service.ToConnect;
import path.learning.math.service.ToConnectHibernate;

@Transactional
@Repository
public class FeedbackDAOImpl implements FeedbackDAO {

	@Autowired
    ToConnectHibernate connect;
	@Autowired
    ToConnect connection;
	
	public boolean sendFeedback(Feedback feedback) {
		try {
			Session session = connect.getSession();
			Transaction t = session.beginTransaction();
			session.save(feedback);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

	public List<Feedback> getAllFeedbacks() {
		try {
			Session session = connect.getSession();
			Transaction t = session.beginTransaction();
			List<Feedback> list = (List<Feedback>) session.createQuery("FROM Feedback").list();
			t.commit();
			session.close();
			return list;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return null;
		}
	}

	public boolean delete(int feedId) {
		
		try{
			Statement st = connection.getStatement();
			st.executeUpdate("delete from feedback where id ='" + feedId + "'");
		    return true;
	} catch (Exception e) {
		System.out.println("Exception(ADD): " + e);
		return false;
	}
	}

	

}
