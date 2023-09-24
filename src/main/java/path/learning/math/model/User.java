package path.learning.math.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int userid;
	@Email
	@Column(nullable = false)
	@NotEmpty(message="*This field should not be left blank")
    private String email;
	@NotNull
	@Size(min = 6, max = 12, message = "*Your password must contain between 6 and 12 letters")
	private String password;
	@NotNull
	@NotEmpty(message="*Name is Required")
	private String name;
	@NotEmpty(message="*Select Gender")
	private String gender;
	@NotNull
	@NotEmpty(message="*Date of Birth is Required")
	private String dob;
	@NotNull
	@Size(min = 10, max = 10, message = "*Not a valid contact number, Must be of 10 digit")
	private String contact;
	
	private String date;
	private String time;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
