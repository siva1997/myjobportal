package myfirstjob.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myfirstjob.dto.HrUser;
import myfirstjob.dto.Job;
import myfirstjob.service.HrService;


@WebServlet("/addjob")
public class AddJob extends HttpServlet {
	
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Job job=new Job();
		HttpSession session=request.getSession();
		HrUser hrUser=(HrUser) session.getAttribute("hrUser");
		job.setDesignation(request.getParameter("designation"));
		job.setExperience(request.getParameter("experience"));
		job.setDescription(request.getParameter("description"));
		job.setSkills(request.getParameter("skills"));
		job.setEmploymentType(request.getParameter("employmenttype"));
		job.setSalary(request.getParameter("salary"));
		job.setActive(true);
		job.setLocation(request.getParameter("location"));
		job.setHrUser(hrUser);
		
		HrService service=new HrService();
		boolean isAdded=service.addJob(job);
		if(isAdded) {
			request.getRequestDispatcher("jobsposted").forward(request, response);
		}
		else {
			request.setAttribute("sqlError", "some internal error occured");
			request.getRequestDispatcher("addjob.jsp").forward(request, response);
		}
	}

}
