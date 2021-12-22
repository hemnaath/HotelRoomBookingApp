package com.hotelroombookingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.hotelroombookingapp.model.Guest;

public class WeddingHallTransactionDao
{
	public void bookWeddingHall(Guest guestObj) throws SQLException, ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Scanner sc = new Scanner(System.in);
		int vacantWeddingRoomNumber=0;
		int guestId=0;
		int i=0;
		
		System.out.println("enter check-in date");
		Date checkIn = sdf.parse(sc.nextLine());
		System.out.println("enter check-out date");
		Date checkOut = sdf.parse(sc.nextLine());
		System.out.println("enter category");
		System.out.println("1.Premium\n2.luxury\n3.standard\n4.budget");
		int categoryChoice = Integer.parseInt(sc.nextLine());
		String category = (categoryChoice==1)?"Premium":(categoryChoice==2)?"luxury":(categoryChoice==3)?"standard":"budget";
		System.out.println("enter location");
		String location = sc.nextLine();
		
		String fetchVacantWeddingRoom="select wedding_hall_number from wedding_hall_details where status='vacant' and category=? and location=?";
		
		String bookWeddingRoomQuery="insert into wedding_hall_transaction(wedding_hall_number,check_in,check_out,category,location,guest_id) values(?,?,?,?,?,?)";
		String updateWeddingRoomQuery="update wedding_hall_details set status='occupied' where wedding_hall_number=?";
//		System.out.println(bookRoomQuery);
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt1 = conn.prepareStatement(fetchVacantWeddingRoom);
		
		pstmt1.setString(1, category);
		pstmt1.setString(2, location);
		
		ResultSet rs = pstmt1.executeQuery();
		if(rs.next())
		{
			vacantWeddingRoomNumber=rs.getInt(1);
		}
		
		PreparedStatement pstmt2 = conn.prepareStatement(bookWeddingRoomQuery);
		PreparedStatement pstmt3 = conn.prepareStatement(updateWeddingRoomQuery);
		
		GuestDao guestDaoObj = new GuestDao();
		
		guestId=guestDaoObj.findGuestId(guestObj);
//		System.out.println(guestId);
		
		pstmt2.setInt(1, vacantWeddingRoomNumber);
		pstmt2.setDate(2, new java.sql.Date(checkIn.getTime()));
		pstmt2.setDate(3, new java.sql.Date(checkOut.getTime()));
		pstmt2.setString(4, category);
		pstmt2.setString(5,location);
		pstmt2.setInt(6, guestId);
		
		pstmt3.setInt(1, vacantWeddingRoomNumber);
		
//		System.out.println(bookRoomQuery);

		
		i = pstmt2.executeUpdate();
		if(i>0)
		{
			System.out.println("Weddings Hall booked");
			pstmt3.executeUpdate();
		}
		else
		{
			System.out.println("Error in booking");
		}

	}
	
	
	
	public void cancelWeddingHall(Guest guestObj) throws SQLException
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter wedding hall number");
		int weddingRoomNumber = Integer.parseInt(sc.nextLine());
		
		String updateCancelWeddingRoomQuery = "update wedding_hall_details set status='vacant' where wedding_hall_number=?";
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = conn.prepareStatement(updateCancelWeddingRoomQuery);
				
		pstmt.setInt(1, weddingRoomNumber);
				
		int i=pstmt.executeUpdate();
		if(i>0)
		{
			System.out.println("Booking Cancelled");
		}
		else
		{
			System.out.println("Invalid Room");
		}
	}
	
	
}