package src.main.courseapp.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import src.main.courseapp.validations.Phone;

@Entity
@Table
@Builder

public class User extends BaseEntity{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uId;

	@Email(message = "{error.username.invalid}")
	@NotBlank(message = "{error.username.notblank}")
	private String userName;
	
	@NotBlank(message = "{error.firstname.notblank}")
	private String firstName;
	
	@NotBlank(message = "{error.lastname.notblank}")
	private String lastName;
	
	private String middleName;
	
	@NotBlank(message = "{error.pasword.notblank}")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,10})", message = "Password should have atleast 1 digit, 1 lowercase, 1 uppercase and with a min length of 6 and max length of 10")
	private String password;

	@JsonIgnore
	@ManyToMany(mappedBy = "registeredUsers", cascade = CascadeType.ALL)
	private List<Course> courses = new ArrayList<>();
	
	
    public User() {
		super();
	}

	public User(int uId, String userName, String firstName, String lastName, String middleName, String password,
			LocalDate dOB, String phonenumber) {
		super();
		this.uId = uId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.password = password;
		DOB = dOB;
		this.phonenumber = phonenumber;
	}

	private LocalDate DOB;
   
    @Phone
    private String phonenumber;

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", password=" + password + ", DOB=" + DOB + ", phonenumber="
				+ phonenumber + "]";
	
	}}
	
