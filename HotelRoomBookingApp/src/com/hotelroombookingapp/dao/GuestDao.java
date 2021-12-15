package com.hotelroombookingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotelroombookingapp.model.Guest;

public class GuestDao {
	
	
	
	public Guest registerGuest(String rgFirstname,String rgLastname,String rgMail,String rgPassword,String rgConfirmPassword,
			long rgMobileNumber)
	{
		String registerquery = "insert into guest(firstname,lastname,email,password,mobile) values (?,?,?,?,?)";
		Connection conn = ConnectionUtil.getDbConnection();
		 
		Guest g1=null;
		
		try
		{
			PreparedStatement p = conn.prepareStatement(registerquery);
			p.setString(1, rgFirstname);
			p.setString(2, rgLastname);
			p.setString(3, rgMail);
			p.setString(4, rgPassword);
			p.setLong(5, rgMobileNumber);
			
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
//			System.out.println(rs1.getString(2));
			while(rs1.next())
			{
				g2 = new Guest(rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5),rs1.getLong(6));
			}
		}
		catch(Exception e)
		{ 	
			e.printStackTrace();
		}
		return g2;
	}
	
	
	
	
	
	
	public List<Guest> showAllUser()
	{
		List<Guest> guestList = new ArrayList<Guest>();
		String allUserQuery = "select * from guest";
		
		Connection conn = ConnectionUtil.getDbConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(allUserQuery);
			while(rs.next())
			{
				Guest guest = new Guest(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getLong(6));
				guestList.add(guest);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return guestList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
