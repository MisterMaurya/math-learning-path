package path.learning.math.dao.impl;

import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import path.learning.math.dao.QuizDAO;
import path.learning.math.model.QuizMe;
import path.learning.math.service.ToConnect;
import path.learning.math.service.ToConnectHibernate;

@Transactional
@Repository
public class QuizDAOImpl implements QuizDAO {
	@Autowired
	ToConnectHibernate connect;
	@Autowired
    ToConnect connection;
	List<QuizMe> list;

	public boolean addQuiz(QuizMe quiz) {

		try {
			Session session = connect.getSession();
			Transaction t = session.beginTransaction();
			session.save(quiz);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}

	}

	public boolean delete(int quizid) {
		try {

			Statement st = connection.getStatement();
			st.executeUpdate("delete from quizme where quizid ="+quizid+"");
			return true;

		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<QuizMe> getAllQuiz() {
		try {
			Session session = connect.getSession();
			Transaction t = session.beginTransaction();
			list = (List<QuizMe>) session.createQuery("FROM QuizMe").list();
			t.commit();
			session.close();
			return list;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return null;
		}
	}

	public boolean updateQuestion(int quizid) {
		
		return false;
	}

}
