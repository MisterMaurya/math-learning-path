package path.learning.math.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import path.learning.math.dao.UserRolesDAO;
import path.learning.math.model.UserRoles;
import path.learning.math.service.ToConnect;
import path.learning.math.service.ToConnectHibernate;

@Transactional
@Repository
public class UserRolesDAOImpl implements UserRolesDAO {

	@Autowired
	ToConnectHibernate connect;
	@Autowired
    ToConnect connection;

	public boolean setRole(UserRoles userRoles) {

		try {
			Session session = connect.getSession();
			Transaction t = session.beginTransaction();
			session.save(userRoles);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}

	}

	public boolean updateUserRoles(UserRoles userRoles) {
		try {
			Session session = connect.getSession();
			Transaction t = session.beginTransaction();
			session.update(userRoles);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

}
