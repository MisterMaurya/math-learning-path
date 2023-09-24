package path.learning.math.dao;

import path.learning.math.model.UserRoles;

public interface UserRolesDAO {

	public boolean setRole(UserRoles userRoles);
	public boolean updateUserRoles(UserRoles userRoles);
}
