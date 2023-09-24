package path.learning.math.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import path.learning.math.dao.TutorialFileDAO;
import path.learning.math.model.TutorialFile;
import path.learning.math.service.ToConnect;
import path.learning.math.service.ToConnectHibernate;

@Transactional
@Repository
public class TutorialFileDAOImpl implements TutorialFileDAO {

	@Autowired
	ToConnectHibernate connect;
	ToConnect connection;
	List<TutorialFile> list;

	public boolean saveFile(TutorialFile document) {
		try {
			Session session = connect.getSession();
			Transaction t = session.beginTransaction();
			session.save(document);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	public List<TutorialFile> getAllFile() {

		Session session = connect.getSession();
		Transaction t = session.beginTransaction();
		list = (List<TutorialFile>) session.createQuery("FROM TutorialFile").list();
		t.commit();
		session.close();
		return list;

	}

	public boolean deleteFile(int fileId) {
		try {

			Session session = connect.getSession();
			Transaction t = session.beginTransaction();
			TutorialFile file = (TutorialFile) session.createQuery("FROM TutorialFile where FILE_ID=" + fileId).list()
					.get(0);
			session.delete(file);
			t.commit();
			session.close();
			return true;

		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

}
