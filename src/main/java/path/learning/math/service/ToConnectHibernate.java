package path.learning.math.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToConnectHibernate {
	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.openSession();
	}
}
