package com.hotelroombookingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hotelroombookingapp.model.Guest;

public class GuestDao {
	
	
	
	public Guest registerGuest(String rgFirstname,String rgLastname,String rgMail,String rgPassword,String rgConfirmPassword,
			long rgMobileNumber)
	{
		String registerquery = "insert into guest_details (firstname,lastname,email,password,mobile) values (?,?,?,?,?)";
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
		String loginquery = "select * from guest_details where email=? and password=?";
		Connection conn = ConnectionUtil.getDbConnection();
		
		Guest guestObj=null;
		try
		{
			PreparedStatement p2 = conn.prepareStatement(loginquery);
			p2.setString(1, gUserName);
			p2.setString(2, gPassword);
			ResultSet rs1 = p2.executeQuery();
//			System.out.println(rs1.getString(2));
			while(rs1.next())
			{
				guestObj = new Guest(rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5),rs1.getLong(6));
			}
		}
		catch(Exception e)
		{ 	
			e.printStackTrace();
		}
		return guestObj;
	}
	
	
	public int findGuestId(Guest guestObj) 
	{
		int guestId=0;
		try
		{
			String findIdQuery="select id from guest_details where email=?";
			Connection conn = ConnectionUtil.getDbConnection();
			PreparedStatement pstmt = conn.prepareStatement(findIdQuery);
			pstmt.setString(1, guestObj.getEmail());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				guestId = rs.getInt(1);
//				System.out.println(guestId);
			}
			else
			{
				System.out.println("guest not found");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return guestId;
	}
	
	
	
	public List<Guest> showAllUser()
	{
		List<Guest> guestList = new ArrayList<Guest>();
		String allUserQuery = "select * from guest_details";
		
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
	
	
	
	
	
	
	public void forgetPassword() throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter email");
		String mail=sc.nextLine();
		System.out.println("Enter new password");
		String passwd=sc.nextLine();
		
		String forgetPasswordQuery = "update guest_details set password=? where email=?";
		
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = conn.prepareStatement(forgetPasswordQuery);
		
		pstmt.setString(1, passwd);
		pstmt.setString(2, mail);
		
		int i = pstmt.executeUpdate();
		if(i>0)
		{
			System.out.println("Password changed successfully");
		}
	}
	
	
	

}
