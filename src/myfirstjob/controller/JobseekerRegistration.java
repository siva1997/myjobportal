package myfirstjob.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myfirstjob.dto.JobseekerUser;
import myfirstjob.service.JobseekerService;
import myfirstjob.util.MailUtility;
import myfirstjob.util.Validation;


@WebServlet("/jobseekerregistration")
public class JobseekerRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobseekerUser jsUser=new JobseekerUser();
		jsUser.setFullName(request.getParameter("fullname"));
		jsUser.setUserName(request.getParameter("username"));
		jsUser.setEmail(request.getParameter("email"));
		jsUser.setMobileNumber(request.getParameter("mobile"));
		jsUser.setPassword(request.getParameter("password"));
		jsUser.setConfirmPassword(request.getParameter("confirmpassword"));
		Validation validate=new Validation();
		Map<String,String> errorMessages=validate.jobseekerValidation(jsUser);
		if(errorMessages.size()>0) {
			request.setAttribute("errorMessages", errorMessages);
			request.getRequestDispatcher("jobseekerregistration.jsp").forward(request, response);
		}
		else {
			JobseekerService jsService=new JobseekerService();
			boolean isInserrted=jsService.saveJobseeker(jsUser);
			if(isInserrted) {
				MailUtility mailUtility=new MailUtility();
				mailUtility.sendMail(request.getParameter("username"),request.getParameter("email"));
				request.getRequestDispatcher("jobseekerlogin.jsp").forward(request, response);
			}
			else {
				request.setAttribute("sqlError", "some internal error occured try after some time");
				request.getRequestDispatcher("jobseekerregistration.jsp").forward(request, response);
			}
		}
	}

}
