package com.hotelroombookingapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil 
{
	public static Connection getDbConnection()
	{
		Connection conn=null;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}
