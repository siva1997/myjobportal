package myfirstjob.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myfirstjob.dto.HrUser;
import myfirstjob.service.HrService;
import myfirstjob.util.Validation;


@WebServlet("/hrlogin")
public class HrLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Validation validation=new Validation();
		Map<String,String> errorMessages=validation.validateLogin(email,password);
		if(errorMessages.size()>0) {
			request.setAttribute("errorMessages", errorMessages);
			request.getRequestDispatcher("hrlogin.jsp").forward(request, response);
		}else {
			HrService hrService=new HrService();
			HrUser hrUser=hrService.getHr(email,password);
			if(hrUser!=null) {
				HttpSession session=request.getSession();
				session.setAttribute("hrUser", hrUser);
				response.getWriter().print("hr login sucessful");
//				response.sendRedirect("");
			}
			else {
				request.setAttribute("loginError", "enter valid credentials");
				request.getRequestDispatcher("hrlogin.jsp").forward(request, response);
			}
		}
		
		
		
	}

}
