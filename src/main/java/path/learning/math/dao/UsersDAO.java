package path.learning.math.dao;

import path.learning.math.model.Users;

public interface UsersDAO {

	public boolean addToUsers(Users user);
	public boolean updatePassword(String password,String email);
}
