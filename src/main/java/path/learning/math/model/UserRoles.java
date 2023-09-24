package path.learning.math.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_roles", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UserRoles implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int userRolesid;
	@NotNull
	private String email;

	public int getUserRolesid() {
		return userRolesid;
	}

	public void setUserRolesid(int userRolesid) {
		this.userRolesid = userRolesid;
	}

	@NotNull
	private String role;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}