
package com.dbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.dto.ReservDTO;

public class ReservDBS {
Connection con = null;
	public ReservDBS() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant?user=root&password=root");
			
		} catch (Exception e) {
			System.out.println("Error in loading drivers and making connection"); 
		}
	}
	public int reservation(ReservDTO rs)
	{
		int x=0;
		try {
		 PreparedStatement ps = con.prepareStatement("insert into reservation values(?,?,?,?,?,?,?,?)");
		 ps.setString(1,rs.getName());
		 ps.setString(2,rs.getEmail());
		 ps.setString(3,rs.getContact());
		 ps.setString(4,rs.getTime());
		 ps.setString(5,rs.getDate());
		 ps.setString(6,rs.getPreferred_food());
		 ps.setString(7,rs.getOccasion());
		 ps.setString(8,rs.getNo_person());
		 x = ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Error in sql query "
					+e);
		}
			
		return x;
	}
	public int deleteTable(ReservDTO rs)
	{
		int x=0;
		try {
		 PreparedStatement ps = con.prepareStatement(" delete from reservation where email=? ");
 		 ps.setString(1,rs.getEmail());
		 x = ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Error in sql query "
					+e);
		}
			
		return x;
	}
	public int updateTable(ReservDTO rs)
	{
		int x=0;
		try {
		 PreparedStatement ps = con.prepareStatement("update reservation set name=?,contact=?,time=?,date=?,no_person=?,occasion=?,preferred_food=? where email=?");
		 ps.setString(1,rs.getName());
		 ps.setString(2,rs.getContact());
		 ps.setString(3,rs.getTime());
		 ps.setString(4,rs.getDate());
		 ps.setString(5,rs.getNo_person());
		 ps.setString(6,rs.getOccasion());
		 ps.setString(7,rs.getPreferred_food());
		 ps.setString(8,rs.getEmail());
		 x = ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Error in sql query "
					+e);
		}
			
		return x;
	}
	
}
