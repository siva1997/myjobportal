package myfirstjob.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import myfirstjob.dto.JobSeekerProfile;
import myfirstjob.dto.JobseekerUser;
import myfirstjob.service.JobseekerService;
import myfirstjob.util.Validation;

@WebServlet("/updateprofile")
@MultipartConfig
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JobseekerService service = new JobseekerService();
		JobSeekerProfile jobSeekerProfile = (JobSeekerProfile) request.getSession().getAttribute("profile");
		System.out.println(jobSeekerProfile.getHighestQualification());
		JobseekerUser jsUser=(JobseekerUser) request.getSession().getAttribute("jsUser");
		
		System.out.println(request.getParameter("qualification"));
		System.out.println(request.getParameter("ugpercentage"));
		
		jobSeekerProfile.setHighestQualification(request.getParameter("qualification"));
		jobSeekerProfile.setUgPercentage(Float.valueOf(request.getParameter("ugpercentage")));
		jobSeekerProfile.setPlusTwoPercentage(Float.valueOf(request.getParameter("plustwopercentage")));
		jobSeekerProfile.setTenthPercentage(Float.valueOf(request.getParameter("tenthpercentage")));
		jobSeekerProfile.setSkills(request.getParameter("skills"));
		jobSeekerProfile.setLanguagesKnown(request.getParameter("languages"));
		jobSeekerProfile.setExperience(Integer.valueOf(request.getParameter("experience")));

		Validation validate = new Validation();
		Map<String, String> errorMessages = validate.jsProfileValidate(jobSeekerProfile);
		if (errorMessages.size() > 0) {
			request.setAttribute("errorMessages", errorMessages);
			request.getRequestDispatcher("updateprofile.jsp").forward(request, response);
		} else {

			boolean isprofileAdded = service.updateProfile(jobSeekerProfile);
			if (isprofileAdded) {
				Part part = request.getPart("resume");
				InputStream inputStream = part.getInputStream();
				byte[] resumeByteArray = new byte[inputStream.available()];

				inputStream.read(resumeByteArray);

				String resumePath = request.getServletContext().getRealPath("/");

				resumePath = resumePath + "/resumes/";

				File resumeFileDirectoryPath = new java.io.File(resumePath);
				if (!resumeFileDirectoryPath.exists()) {
					resumeFileDirectoryPath.mkdir();
				}

				FileOutputStream fileOutputStream = new FileOutputStream(
						resumeFileDirectoryPath + "/" + jsUser.getId() + ".pdf");
				System.out.println(resumeFileDirectoryPath);
				fileOutputStream.write(resumeByteArray);
				fileOutputStream.flush();
				fileOutputStream.close();
				request.getSession().removeAttribute("profile");
				request.getSession().setAttribute("profile", jobSeekerProfile);
				response.sendRedirect("displayprofile");

			} else {
				request.setAttribute("sqlError", "some internal error");
				request.getRequestDispatcher("updateprofile.jsp").forward(request, response);
			}

		}

	}

}
