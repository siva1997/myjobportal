package myfirstjob.util;

import java.util.HashMap;
import java.util.Map;

import myfirstjob.dto.HrUser;
import myfirstjob.dto.JobSeekerProfile;
import myfirstjob.dto.JobseekerUser;

public class Validation {
	public Map<String,String> hrValidation(HrUser hrUser) {
		Map<String, String> errorMessages = new HashMap<String, String>();

		if (hrUser.getOrganisation().isEmpty()) {
			errorMessages.put("organisationError", "enter organisation name");

		}
		if (hrUser.getUserName().isEmpty()) {
			errorMessages.put("usernameError", "enter userName");
		}
		if (hrUser.getEmail().isEmpty()) {
			errorMessages.put("mailError", "enter Email");
		}

		if (hrUser.getMobileNumber().isEmpty()) {
			errorMessages.put("mobileError", "enter Mobile Number");
		}
		else if(!Validation.validateMobileNumber(hrUser.getMobileNumber())) {
			errorMessages.put("mobileError", "enter valid mobile number");
		}
		
		if((hrUser.getPassword().isEmpty()) || (hrUser.getConfirmPassword().isEmpty())) {
			errorMessages.put("passwordError","enter password");
		}
		else if(!hrUser.getPassword().equals(hrUser.getConfirmPassword())) {
			errorMessages.put("passwordError", "enter correct password");
		}
		
		return errorMessages;
	}

	public Map<String,String> jobseekerValidation(JobseekerUser jsUser) {
		Map<String, String> errorMessages = new HashMap<String, String>();
		if(jsUser.getFullName().isEmpty()) {
			errorMessages.put("fullnameError", "enter fullname");
		}
		if (jsUser.getUserName().isEmpty()) {
			errorMessages.put("usernameError", "enter userName");
		}
		if (jsUser.getEmail().isEmpty()) {
			errorMessages.put("mailError", "enter Email");
		}

		if (jsUser.getMobileNumber().isEmpty()) {
			errorMessages.put("mobileError", "enter Mobile Number");
		}
		else if(!Validation.validateMobileNumber(jsUser.getMobileNumber())) {
			errorMessages.put("mobileError", "enter valid mobile number");
		}
		
		if((jsUser.getPassword().isEmpty()) || (jsUser.getConfirmPassword().isEmpty())) {
			errorMessages.put("passwordError","enter password");
		}
		else if(!jsUser.getPassword().equals(jsUser.getConfirmPassword())) {
			errorMessages.put("passwordError", "enter correct password");
		}
		return errorMessages;

	}
	
	
	public static boolean validateMobileNumber(String mobileNumber) {
		boolean isValid=true;
		if(mobileNumber.length()!=10) {
			isValid=false;
		}
		for(int number=0;number<mobileNumber.length();number++) {
			Character  c=mobileNumber.charAt(number);
			if(!Character.isDigit(c)) {
				isValid=false;
			}
		}
		return isValid;
	}
	
	public  Map<String,String> validateLogin(String email,String password){
		Map<String,String> errorMessages=new HashMap<String, String>();
		if(email.isEmpty()) {
			errorMessages.put("emailError","enter email");
		}
		if(password.isEmpty()) {
			errorMessages.put("passwordError", "enter password");
		}
		return errorMessages;
	}
	public Map<String,String> jsProfileValidate(JobSeekerProfile profile){
		Map<String,String> errorMessages=new HashMap<String, String>();
		if(profile.getHighestQualification().isEmpty()) {
			errorMessages.put("qualificationError", "enter highest qualification");
			
		}
		
		if(profile.getUgPercentage().isNaN()) {
			errorMessages.put("ugpercentageError", "enter ugpercentage");
		}
		else if(profile.getUgPercentage()>100) {
			errorMessages.put("ugpercentageError", "enter correct percentage");
		}
		
		if(profile.getPlusTwoPercentage().isNaN()) {
			errorMessages.put("plustwopercentageError", "enter percentage ");
		}
		else if(profile.getPlusTwoPercentage()>100) {
			errorMessages.put("plustwopercentageError", "enter correct percentage");
		}
		
		
		if(profile.getTenthPercentage().isNaN()) {
			errorMessages.put("tenthpercentageError", "enter percentage");
		}
		else if(profile.getUgPercentage()>100) {
			errorMessages.put("tenthpercentageError", "enter correct percentage");
		}
		
		if(profile.getSkills().isEmpty()) {
			errorMessages.put("skillsError", "enter Skills");
		}
		
		if(profile.getLanguagesKnown().isEmpty()){
			errorMessages.put("languagesError", "enter Known Languages");
		}
		
		if(profile.getExperience().toString().isEmpty()) {
			errorMessages.put("experienceError", "enter experience");
		}
		
		return errorMessages;
		
	}

}
