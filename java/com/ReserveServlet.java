package com;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbs.ReservDBS;
import com.dto.ReservDTO;

 
@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet {
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ReservDTO rs = new ReservDTO();
	System.out.println("Reservation Servlet");
	 
	rs.setName(request.getParameter("name"));
	 
	rs.setEmail(request.getParameter("email"));
	rs.setContact(request.getParameter("phone"));
	rs.setNo_person(request.getParameter("no_persons"));
	rs.setDate(request.getParameter("date"));
	rs.setTime(request.getParameter("time"));
	rs.setPreferred_food(request.getParameter("preferred_food"));
	rs.setOccasion(request.getParameter("occasion"));
	String op =request.getParameter("b1");
	int x = 0;
	ReservDBS db = new ReservDBS();
	if(op.equals("BOOK MY TABLE"))
	{
	x = db.reservation(rs);
	if(x>0)
	{
		request.setAttribute("mg", "register succesfuly");
	}
	else
	{
		request.setAttribute("mg", " could not be register  ");
	}
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
	rd.forward(request, response);
	}
	if(op.equals("DELETE TABLE"))
	{
		x = db.deleteTable(rs);
		if(x>0)
		{
			request.setAttribute("mg", "Your table cancel");
		}
		else
		{
			request.setAttribute("mg", " your table not canceled ");
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	if(op.equals("UPDATE TABLE"))
	{
		x=db.updateTable(rs);
		if(x>0)
		{
			request.setAttribute("mg", "Information updated");
		}
		else
		{
			request.setAttribute("mg", " Information not updated ");
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		
		
	}
	 
	
	}
}