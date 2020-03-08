package myfirstjob.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myfirstjob.dto.ApplyDetails;
import myfirstjob.dto.JobseekerUser;
import myfirstjob.service.JobseekerService;


@WebServlet("/applyjob")
public class ApplyJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		JobseekerUser user=(JobseekerUser) session.getAttribute("jsUser");
		
		ApplyDetails applyDetails=new ApplyDetails();
		applyDetails.setJobId(Integer.valueOf(request.getParameter("jobid")));
		applyDetails.setJobSeekerId(user.getId());
		
		JobseekerService service=new JobseekerService();
		service.applyJob(applyDetails);
		
	}

}
