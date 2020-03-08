package myfirstjob.controller;

import java.io.IOException;


import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myfirstjob.dto.HrUser;
import myfirstjob.service.HrService;
import myfirstjob.util.MailUtility;
import myfirstjob.util.Validation;


@WebServlet("/hrregistration")
public class HrRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HrUser hrUser=new HrUser();
		hrUser.setOrganisation(request.getParameter("organisation"));
		hrUser.setUserName(request.getParameter("username"));
		hrUser.setEmail(request.getParameter("email"));
		hrUser.setMobileNumber(request.getParameter("mobile"));
		hrUser.setPassword(request.getParameter("password"));
		hrUser.setConfirmPassword(request.getParameter("confirmpassword"));
		
		Validation validate = new Validation();
		Map<String,String> errorMessages=validate.hrValidation(hrUser);
		if(errorMessages.size()>0) {
			request.setAttribute("errorMessages", errorMessages);
			request.getRequestDispatcher("hrregistration.jsp").forward(request, response);
		}
		else {
			HrService hs=new HrService();
			boolean isInserrted=hs.saveHr(hrUser);
			if(isInserrted) {
				MailUtility mailUtility=new MailUtility();
				mailUtility.sendMail(request.getParameter("username"),request.getParameter("email"));
				request.getRequestDispatcher("hrlogin.jsp").forward(request, response);
			}
			else {
				request.setAttribute("sqlError", "some internal error occured try after some time");
				request.getRequestDispatcher("hrregistration.jsp").forward(request, response);
			}
		}
	}

}
