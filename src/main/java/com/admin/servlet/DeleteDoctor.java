package com.admin.servlet;

import java.io.IOException;

import com.dao.DoctorDetailsDao;
import com.db.DataBaseConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//		int id = Integer.parseInt(req.getParameter("id"));
		int id = Integer.valueOf(req.getParameter("id"));

		DoctorDetailsDao dao = new DoctorDetailsDao(DataBaseConnection.getConnection());

		HttpSession session = req.getSession();

		if(dao.deleteDoctorById(id))
		{
			session.setAttribute("successMsg", "Doctor deleted successfully !");
			resp.sendRedirect("admin/view_doctor.jsp");
		}
		else
		{
			session.setAttribute("failureMsg", "Something went wrong !");
			resp.sendRedirect("admin/view_doctor.jsp");
		}
	}

}












