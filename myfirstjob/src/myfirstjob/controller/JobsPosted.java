package myfirstjob.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myfirstjob.dto.HrUser;
import myfirstjob.dto.Job;
import myfirstjob.service.HrService;


@WebServlet("/jobsposted")
public class JobsPosted extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		HrUser hrUser=(HrUser) session.getAttribute("hrUser");
		System.out.print(hrUser.getId());
		HrService service=new HrService();
		List<Job> jobList=service.getJobs(hrUser.getId());
		if(jobList.size()>0) {
		request.setAttribute("jobList", jobList);
		request.getRequestDispatcher("hrwelcome.jsp").forward(request, response);
		}
		else {
			request.setAttribute("sqlError", "some internal error");
			request.getRequestDispatcher("hrwelcome.jsp").forward(request, response);
		}
		
	}

}
