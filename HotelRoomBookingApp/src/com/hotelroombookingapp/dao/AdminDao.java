package com.hotelroombookingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hotelroombookingapp.model.Admin;
import com.hotelroombookingapp.model.Guest;

public class AdminDao {

	public Admin loginAdmin(String adminMail, String adminPassword)
	{
		String loginquery="select * from admin where email=? and password=?";
		Connection conn = ConnectionUtil.getDbConnection();
		
		Admin a2 = null;
		try
		{
			PreparedStatement p2 = conn.prepareStatement(loginquery);
			p2.setString(1, adminMail);
			p2.setString(2, adminPassword);
			ResultSet rs1 = p2.executeQuery();
			while(rs1.next())
			{
				a2 = new Admin(rs1.getString(2),rs1.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a2;
	}
	
}
