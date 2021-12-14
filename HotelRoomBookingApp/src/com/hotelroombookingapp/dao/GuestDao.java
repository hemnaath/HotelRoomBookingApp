package com.hotelroombookingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelroombookingapp.model.Guest;

public class GuestDao {
	
	
	
	public Guest registerGuest(String rgFirstname,String rgLastname,String rgMail,String rgPassword,String rgConfirmPassword,
			long rgMobileNumber)
	{
		String registerquery = "insert into guest(firstname,lastname,email,password,confirm_password,mobile) values (?,?,?,?,?,?)";
		Connection conn = ConnectionUtil.getDbConnection();
		 
		Guest g1=null;
		
		try
		{
			PreparedStatement p = conn.prepareStatement(registerquery);
			p.setString(1, rgFirstname);
			p.setString(2, rgLastname);
			p.setString(3, rgMail);
			p.setString(4, rgPassword);
			p.setString(5, rgConfirmPassword);
			p.setLong(6, rgMobileNumber);
			
			p.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return g1;
	}
	
	
	
	
	public Guest loginGuest(String gUserName,String gPassword)
	{
		String loginquery = "select * from guest where email=? and password=?";
		Connection conn = ConnectionUtil.getDbConnection();
		
		Guest g2=null;
		try
		{
			PreparedStatement p2 = conn.prepareStatement(loginquery);
			p2.setString(1, gUserName);
			p2.setString(2, gPassword);
			ResultSet rs1 = p2.executeQuery();
			while(rs1.next())
			{
				g2 = new Guest(rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5),rs1.getString(6),
						rs1.getLong(7));
			}
		}
		catch(Exception e)
		{ 	
			e.printStackTrace();
		}
		return g2;
	}

}
