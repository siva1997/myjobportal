package myfirstjob.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myfirstjob.dto.JobSeekerProfile;
import myfirstjob.dto.JobseekerUser;


@WebServlet("/displayprofile")
public class DisplayProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		JobSeekerProfile profile=(JobSeekerProfile) session.getAttribute("profile");
		JobseekerUser user=(JobseekerUser) session.getAttribute("jsUser");
		String resumePath=(String) session.getAttribute("resumePath");
		resumePath=resumePath+"/"+user.getId()+".pdf";
		request.setAttribute("profile", profile);
		request.setAttribute("resumePath", resumePath);
		request.getRequestDispatcher("jsprofile.jsp").forward(request, response);
	}

}
