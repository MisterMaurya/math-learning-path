package path.learning.math.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import path.learning.math.dao.VideoTutorialFileDAO;
import path.learning.math.model.VideoTutorialFile;
import path.learning.math.service.ToConnectHibernate;

@Transactional
@Repository
public class VideoTutorialFileDAOImpl implements VideoTutorialFileDAO{
	@Autowired
	ToConnectHibernate connect;
	List<VideoTutorialFile> list;

	public boolean save(VideoTutorialFile document) {
		try {
			Session session =connect.getSession();
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

	public boolean deleteById(int id) {
		try {

			Session session =connect.getSession();
			Transaction t = session.beginTransaction();
			VideoTutorialFile file = (VideoTutorialFile) session.createQuery("FROM VideoTutorialFile where VIDEO_ID="+id).list().get(0);
			session.delete(file);
			t.commit();
			session.close();
			return true;

		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<VideoTutorialFile> getAllFile() {
		Session session =connect.getSession();
		Transaction t = session.beginTransaction();
		list = (List<VideoTutorialFile>) session.createQuery("FROM VideoTutorialFile").list();
		t.commit();
		session.close();
		return list;
		
	}

}
