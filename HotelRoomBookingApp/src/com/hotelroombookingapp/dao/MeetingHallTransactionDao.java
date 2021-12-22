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

public class MeetingHallTransactionDao
{
	public void bookMeetingHall(Guest guestObj) throws SQLException, ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Scanner sc = new Scanner(System.in);
		int vacantMeetingRoomNumber=0;
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
		
		String fetchVacantMeetingRoom="select meeting_hall_number from meeting_hall_details where status='vacant'";
		
		String bookMeetingRoomQuery="insert into meeting_hall_transaction(meeting_hall_number,check_in,check_out,category,location,guest_id) values(?,?,?,?,?,?)";
		String updateBookMeetingRoomQuery="update meeting_hall_details set status='occupied' where meeting_hall_number=?";
//		System.out.println(bookRoomQuery);
		Connection conn = ConnectionUtil.getDbConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(fetchVacantMeetingRoom);
		if(rs.next())
		{
			vacantMeetingRoomNumber=rs.getInt(1);
		}
		
		PreparedStatement pstmt = conn.prepareStatement(bookMeetingRoomQuery);
		PreparedStatement pstmt2 = conn.prepareStatement(updateBookMeetingRoomQuery);
		
		GuestDao guestDaoObj = new GuestDao();
		
		guestId=guestDaoObj.findGuestId(guestObj);
//		System.out.println(guestId);
		
		pstmt.setInt(1, vacantMeetingRoomNumber);
		pstmt.setDate(2, new java.sql.Date(checkIn.getTime()));
		pstmt.setDate(3, new java.sql.Date(checkOut.getTime()));
		pstmt.setString(4, category);
		pstmt.setString(5,location);
		pstmt.setInt(6, guestId);
		
		pstmt2.setInt(1, vacantMeetingRoomNumber);
		
//		System.out.println(bookRoomQuery);

		
		i = pstmt.executeUpdate();
		if(i>0)
		{
			System.out.println("Meeting Hall booked");
			pstmt2.executeUpdate();
		}
		else
		{
			System.out.println("Error in booking");
		}

	}
	
	
	
	public void cancelMeetingHall(Guest guestObj) throws SQLException
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter meeting hall number");
		int meetingRoomNumber = Integer.parseInt(sc.nextLine());
		
		String updateCancelRoomQuery = "update meeting_hall_details set status='vacant' where meeting_hall_number=?";
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = conn.prepareStatement(updateCancelRoomQuery);
				
		pstmt.setInt(1, meetingRoomNumber);
				
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