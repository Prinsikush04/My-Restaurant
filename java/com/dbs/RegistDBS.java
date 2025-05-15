package com.dbs;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.dto.Login;

public class RegistDBS
{
    Connection con = null;
	public RegistDBS()
	{
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
		public int registration(Login l)
		{
			 int x=0;
		
		 try
		 {
			  
			 PreparedStatement ps = con.prepareStatement("insert into registration values(?,?,?)");
			ps.setString(1,l.getName());
			ps.setString(2,l.getContact());
			ps.setString(3,l.getEmail());
			x=ps.executeUpdate();
		} 
		 catch (Exception e) 
		 {
			System.out.println("Error in sql query"+e); 
		}
		 return x;
		
	}

}
 