package myfirstjob.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myfirstjob.dto.Job;
import myfirstjob.service.JobseekerService;


@WebServlet("/displayjobs")
public class DisplayJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobseekerService service=new JobseekerService();
		List<Job> jobsList=service.getJobList();
		if(jobsList!=null) {
			request.setAttribute("jobsList", jobsList);
			request.getRequestDispatcher("jobseekerwelcome.jsp").forward(request, response);
		}
		else {
			request.setAttribute("sqlError", "some internal error");
			request.getRequestDispatcher("jobseekerwelcome.jsp").forward(request, response);
		}
	}

}
