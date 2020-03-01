package myfirstjob.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HrUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,unique = true)
	private String Organisation;
	
	@Column(nullable = false,unique = true)
	private String userName;
	
	@Column(nullable = false,unique = true)
	private String email;
	
	@Column(nullable = false,unique = true)
	private String mobileNumber;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String confirmPassword;
	
	@OneToMany(mappedBy ="hrUser")
	private List<Job> jobsList;
	
	
	public HrUser() {
		super();
	}


	


	public HrUser(int id, String organisation, String userName, String email, String mobileNumber, String password,
			String confirmPassword, List<Job> jobsList) {
		super();
		this.id = id;
		Organisation = organisation;
		this.userName = userName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.jobsList = jobsList;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getOrganisation() {
		return Organisation;
	}


	public void setOrganisation(String organisation) {
		Organisation = organisation;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public List<Job> getJobsList() {
		return jobsList;
	}

	public void setJobsList(List<Job> jobsList) {
		this.jobsList = jobsList;
	}


	@Override
	public String toString() {
		return "HrUser [id=" + id + ", Organisation=" + Organisation + ", userName=" + userName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ "]";
	}
	
	
	
	

}
