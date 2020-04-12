package myfirstjob.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myfirstjob.dto.JobseekerUser;
import myfirstjob.service.HrService;


@WebServlet("/appliedprofiles")
public class AppliedProfiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int jobid=Integer.valueOf(request.getParameter("jobid"));
		HrService service=new HrService();
		List<JobseekerUser> jsList= service.appliedProfiles(jobid);
		if(jsList!=null) {
			request.setAttribute("jsList", jsList);
			request.getRequestDispatcher("appliedjsuser.jsp").forward(request, response);
		}
		else {
			request.setAttribute("sqlError", "some internal error");
			request.getRequestDispatcher("jobsposted").forward(request, response);
		}
		
	}

}
