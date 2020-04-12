package myfirstjob.dto;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobId;
	
	@Column(nullable = false)
	private String designation;
	
	@Column(nullable = false)
	private String experience;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String skills;
	
	@Column(nullable = false)
	private String employmentType;
	
	@Column(nullable = false)
	private String salary;
	
	@Column(nullable = false )
	private boolean isActive;
	
	@Column(nullable = false )
	private String location;
	
	@ManyToOne
	private HrUser hrUser;
	
	

	public Job() {
		super();
	}



	


	public Job(int jobId, String designation, String experience, String description, String skills,
			String employmentType, String salary, boolean isActive, String location, HrUser hrUser) {
		super();
		this.jobId = jobId;
		this.designation = designation;
		this.experience = experience;
		this.description = description;
		this.skills = skills;
		this.employmentType = employmentType;
		this.salary = salary;
		this.isActive = isActive;
		this.location = location;
		this.hrUser = hrUser;
	}






	public int getJobId() {
		return jobId;
	}



	public void setJobId(int jobId) {
		this.jobId = jobId;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public String getExperience() {
		return experience;
	}



	public void setExperience(String experience) {
		this.experience = experience;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getSkills() {
		return skills;
	}



	public void setSkills(String skills) {
		this.skills = skills;
	}



	public String getEmploymentType() {
		return employmentType;
	}



	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}



	public String getSalary() {
		return salary;
	}



	public void setSalary(String salary) {
		this.salary = salary;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public HrUser getHrUser() {
		return hrUser;
	}



	public String getLocation() {
		return location;
	}






	public void setLocation(String location) {
		this.location = location;
	}






	public void setHrUser(HrUser hrUser) {
		this.hrUser = hrUser;
	}
	
	
	

	


	
	
}
