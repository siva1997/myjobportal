package myfirstjob.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myfirstjob.dto.JobSeekerProfile;
import myfirstjob.dto.JobseekerUser;
import myfirstjob.service.JobseekerService;
import myfirstjob.util.Validation;


@WebServlet("/jobseekerlogin")
public class JobseekerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Validation validation=new Validation();
		Map<String,String> errorMessages=validation.validateLogin(email,password);
		if(errorMessages.size()>0) {
			request.setAttribute("errorMessages", errorMessages);
			request.getRequestDispatcher("jobseekerlogin.jsp").forward(request, response);
		}else {
			JobseekerService jsService=new JobseekerService();
			JobseekerUser jsUser=jsService.getJobseeker(email, password);
			if(jsUser!=null) {
				HttpSession session=request.getSession();
				session.setAttribute("jsUser", jsUser);
				JobseekerService service=new JobseekerService();
				JobSeekerProfile profile=service.findProfile(jsUser.getId());
				if(profile!=null) {
				session.setAttribute("profile",profile);
				session.setAttribute("resumePath", "E:/jobportal/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/myfirstjob/resumes");
      			response.sendRedirect("displayjobs?notapplied=1");
				}
				else {
					response.sendRedirect("addprofile.jsp");
				}
			}
			else {
				request.setAttribute("loginError", "enter valid credentials");
				request.getRequestDispatcher("jobseekerlogin.jsp").forward(request, response);
			}
		}
		
	}

}
