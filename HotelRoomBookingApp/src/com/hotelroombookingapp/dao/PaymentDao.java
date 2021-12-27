package com.hotelroombookingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.hotelroombookingapp.model.Guest;

public class PaymentDao 
{
	public void payment(Guest guestObj) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Card Details");
		long cardNumber = sc.nextLong();
		
		String cardDetailsQuery = "insert into cardDetailsValues values (?)";
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = conn.prepareStatement(cardDetailsQuery);
		pstmt.setLong(1, cardNumber);
		pstmt.executeUpdate();
	}
}
