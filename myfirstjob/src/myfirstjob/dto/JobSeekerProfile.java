package myfirstjob.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class JobSeekerProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer profileId;
	
	@Column(nullable = false)
	private String highestQualification;
	
	@Column(nullable = false)
	private Float ugPercentage;
	
	@Column(nullable = false)
	private Float plusTwoPercentage;
	
	@Column(nullable = false)
	private Float tenthPercentage;
	
	@Column(nullable = false)
	private String skills;
	
	@Column(nullable = false)
	private String languagesKnown;
	
	@Column(nullable = false)
	private Integer experience;
	
	@OneToOne
	private JobseekerUser jobseekerUser;
	
	
	

	public JobSeekerProfile() {
		super();
	}




	public JobSeekerProfile(Integer profileId, String highestQualification, Float ugPercentage, Float plusTwoPercentage,
			Float tenthPercentage, String skills, String languagesKnown, Integer experience,
			JobseekerUser jobseekerUser) {
		super();
		this.profileId = profileId;
		this.highestQualification = highestQualification;
		this.ugPercentage = ugPercentage;
		this.plusTwoPercentage = plusTwoPercentage;
		this.tenthPercentage = tenthPercentage;
		this.skills = skills;
		this.languagesKnown = languagesKnown;
		this.experience = experience;
		this.jobseekerUser = jobseekerUser;
	}




	public Integer getProfileId() {
		return profileId;
	}




	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}




	public String getHighestQualification() {
		return highestQualification;
	}




	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}




	public Float getUgPercentage() {
		return ugPercentage;
	}




	public void setUgPercentage(Float ugPercentage) {
		this.ugPercentage = ugPercentage;
	}




	public Float getPlusTwoPercentage() {
		return plusTwoPercentage;
	}




	public void setPlusTwoPercentage(Float plusTwoPercentage) {
		this.plusTwoPercentage = plusTwoPercentage;
	}




	public Float getTenthPercentage() {
		return tenthPercentage;
	}




	public void setTenthPercentage(Float tenthPercentage) {
		this.tenthPercentage = tenthPercentage;
	}




	public String getSkills() {
		return skills;
	}




	public void setSkills(String skills) {
		this.skills = skills;
	}




	public String getLanguagesKnown() {
		return languagesKnown;
	}




	public void setLanguagesKnown(String languagesKnown) {
		this.languagesKnown = languagesKnown;
	}




	public Integer getExperience() {
		return experience;
	}




	public void setExperience(Integer experience) {
		this.experience = experience;
	}




	public JobseekerUser getJobseekerUser() {
		return jobseekerUser;
	}




	public void setJobseekerUser(JobseekerUser jobseekerUser) {
		this.jobseekerUser = jobseekerUser;
	}
	
	
	
	
	

}
