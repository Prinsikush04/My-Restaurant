package order.dbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import order.dto.OrderDTO;

public class OrderDBS {
Connection con=null;
	public OrderDBS() {
		try
		 {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant?user=root&password=root");
		} 
		 catch (Exception e)
		 {
			 System.out.println("Error in loading drivers and making connection"+e);
		} 
	}
	
	public OrderDTO getPrice(OrderDTO o)
	{
		
		 
		OrderDTO o1 = new OrderDTO();
		try {
			
			
		PreparedStatement ps = con.prepareStatement("select * from Menu where item_id=?");
		ps.setInt(1, o.getItem_id());
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()==true)
		{
			o1.setItem_id(rs.getInt("item_id"));
			o1.setName(rs.getString("name"));
			o1.setPrice(rs.getDouble("price"));
			//o1.setQuantity(rs.getInt("quantity"));
		}
		}
		catch(Exception e) {
			System.out.println("Error in sql query"+e);
			
		}
		
		return o1;
	}

}
