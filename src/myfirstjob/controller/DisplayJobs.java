package myfirstjob.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myfirstjob.dto.Job;
import myfirstjob.dto.JobseekerUser;
import myfirstjob.service.JobseekerService;


@WebServlet("/displayjobs")
public class DisplayJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		JobseekerService service=new JobseekerService();
		HttpSession session=request.getSession();
		Integer isNotapplied=Integer.valueOf(request.getParameter("notapplied"));
		JobseekerUser jobseekerUser=  (JobseekerUser) session.getAttribute("jsUser");
		if(isNotapplied==1) {
		List<Job> jobsList=service.getJobList(jobseekerUser.getId());
		if(jobsList!=null) {
			request.setAttribute("jobsList", jobsList);
			request.setAttribute("notapplied", 1);
			request.getRequestDispatcher("jobseekerwelcome.jsp").forward(request, response);
		}
		else {
			request.setAttribute("sqlError", "some internal error");
			request.getRequestDispatcher("jobseekerwelcome.jsp").forward(request, response);
		}
	}
		if(isNotapplied==0) {
			List<Job> jobsList=service.getAppliedJobList(jobseekerUser.getId());
			if(jobsList!=null) {
				request.setAttribute("jobsList", jobsList);
				request.setAttribute("notapplied", 0);
				request.getRequestDispatcher("jobseekerwelcome.jsp").forward(request, response);
			}
			else {
				request.setAttribute("sqlError", "some internal error");
				request.getRequestDispatcher("jobseekerwelcome.jsp").forward(request, response);
			}
		}
	}
}
