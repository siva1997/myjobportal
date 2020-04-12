package myfirstjob.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myfirstjob.dto.JobSeekerProfile;
import myfirstjob.service.HrService;


@WebServlet("/viewprofile")
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int jsid=Integer.valueOf(request.getParameter("jsid"));
		HrService service=new HrService();
		JobSeekerProfile profile=service.getProfile(jsid);
		request.setAttribute("profile", profile);
		request.getRequestDispatcher("viewprofile.jsp").forward(request, response);
	}

}
