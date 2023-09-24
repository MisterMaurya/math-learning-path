package path.learning.math.dao;

import java.util.List;

import path.learning.math.model.User;

public interface UserDAO {

	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean delete(String email);
	public List<User> getAllUsers();
}
