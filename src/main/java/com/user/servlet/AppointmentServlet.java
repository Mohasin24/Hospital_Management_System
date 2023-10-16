package com.user.servlet;

import java.io.IOException;

import com.dao.AppointmentDao;
import com.db.DataBaseConnection;
import com.entity.UserAppointment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addAppointment")
public class AppointmentServlet extends HttpServlet	
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int userId = Integer.parseInt(req.getParameter("userId"));
		String fullName = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String appointmentDate = req.getParameter("appointmentDate");
		String email = req.getParameter("email");
		String phNo = req.getParameter("phno");
		String diseases = req.getParameter("diseases");
		int doctorId = Integer.parseInt(req.getParameter("doctorId"));
		String address = req.getParameter("address");
		String status = req.getParameter("status");

		AppointmentDao dao = new AppointmentDao(DataBaseConnection.getConnection());
		UserAppointment appointment = new UserAppointment(userId, fullName, gender, age, appointmentDate, email, phNo, diseases, doctorId, address, "Pending");

		HttpSession session = req.getSession();

		if(dao.addAppointment(appointment))
		{
			session.setAttribute("successMsg", "Appointment added successfully");
			resp.sendRedirect("user_appointment.jsp");
		}
		else
		{
			session.setAttribute("failureMsg", "Something went wrong");
			resp.sendRedirect("user_appointment.jsp");
		}


	}

}











