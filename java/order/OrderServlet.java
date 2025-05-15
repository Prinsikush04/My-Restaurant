package order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.dbs.OrderDBS;
import order.dto.OrderDTO;

 
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 OrderDTO o = new OrderDTO();
		 try {
		 o.setItem_id(Integer.parseInt(request.getParameter("item_id")));
		 }
		 catch(Exception e) {
			 System.out.println("first"+e);
		 }
		 o.setName(request.getParameter("name"));
		 try {
			 o.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			 System.out.println("Quentity : "+o.getQuantity());
			 //o.setPrice(Double.parseDouble(request.getParameter("price")));
			// o.setTotal_price(Double.parseDouble(request.getParameter("total_price")));
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 
		 
		 OrderDBS db = new OrderDBS();
		 OrderDTO or= db.getPrice(o);
		 or.setTotal_price(o.getQuantity()*or.getPrice());
		 or.setQuantity(o.getQuantity());
		 
		 double t = o.getQuantity()*or.getPrice();
		  
		   
		 or.setTotal_price(t);
		 request.setAttribute("tprice", t);
		 
	     request.setAttribute("OrderDTO", or);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/order2.jsp");
			rd.forward(request, response);
		 
		 
	}

}
