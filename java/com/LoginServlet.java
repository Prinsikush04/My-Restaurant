package com;

import java.io.IOException;



import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbs.RegistDBS;
import com.dto.Login;

 
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet

   {
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login lg = new Login();
		lg.setName(request.getParameter("t1"));
		lg.setContact(request.getParameter("t2"));
		lg.setEmail(request.getParameter("t3"));
		String op = request.getParameter("b1");
       String target="";
		RegistDBS db = new RegistDBS();
		int x=0;
		if(op.equals("Registration"))
		{
			x = db.registration(lg);
			if(x>0)
			{
				 target="/index.jsp";
			}
			else {
				target="/login.jsp";
				request.setAttribute("msg","could not be registered");
			}
			
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
		rd.forward(request, response);
	
	 
	  }

   }
