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
		String category = (categoryChoice==1)?"premium":(categoryChoice==2)?"luxury":(categoryChoice==3)?"standard":"budget";
		System.out.println("enter location");
		String location = sc.nextLine();
		
		String fetchVacantMeetingRoom="select meeting_hall_number from meeting_hall_details where status='vacant' and category=? and location=?";
		
		String bookMeetingRoomQuery="insert into meeting_hall_transaction(meeting_hall_number,check_in,check_out,category,location,guest_id) values(?,?,?,?,?,?)";
		String updateBookMeetingRoomQuery="update meeting_hall_details set status='occupied' where meeting_hall_number=?";
//		System.out.println(bookRoomQuery);
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt1 = conn.prepareStatement(fetchVacantMeetingRoom);
		
		pstmt1.setString(1, category);
		pstmt1.setString(2, location);
		
		ResultSet rs = pstmt1.executeQuery();
		if(rs.next())
		{
			vacantMeetingRoomNumber=rs.getInt(1);
		}
		
		PreparedStatement pstmt2 = conn.prepareStatement(bookMeetingRoomQuery);
		PreparedStatement pstmt3 = conn.prepareStatement(updateBookMeetingRoomQuery);
		
		GuestDao guestDaoObj = new GuestDao();
		
		guestId=guestDaoObj.findGuestId(guestObj);
//		System.out.println(guestId);
		
		pstmt2.setInt(1, vacantMeetingRoomNumber);
		pstmt2.setDate(2, new java.sql.Date(checkIn.getTime()));
		pstmt2.setDate(3, new java.sql.Date(checkOut.getTime()));
		pstmt2.setString(4, category);
		pstmt2.setString(5,location);
		pstmt2.setInt(6, guestId);
		
		pstmt3.setInt(1, vacantMeetingRoomNumber);
		
//		System.out.println(bookRoomQuery);

		
		i = pstmt2.executeUpdate();
		if(i>0)
		{
			System.out.println("Meeting Hall booked");
			pstmt3.executeUpdate();
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
	
	
	
	public void updateMeetingHall(Guest guestObj) throws ParseException, SQLException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Scanner sc = new Scanner(System.in);
		int vacantMeetingHallNumber=0;
		int i=0;
		int guestId=0;
		
		System.out.println("enter meeting hall number");
		int meetingHallNumber = Integer.parseInt(sc.nextLine());
		System.out.println("enter check-in date");
		Date checkIn = sdf.parse(sc.nextLine());
		System.out.println("enter check-out date");
		Date checkOut = sdf.parse(sc.nextLine());
		System.out.println("enter category");
		System.out.println("1.Premium\n2.luxury\n3.standard\n4.budget");
		int categoryChoice = Integer.parseInt(sc.nextLine());
		String category = (categoryChoice==1)?"premium":(categoryChoice==2)?"luxury":(categoryChoice==3)?"standard":"budget";
		System.out.println("enter location");
		String location = sc.nextLine();
		
		String updateRoomQuery="update meeting_hall_transaction set check_in=?,check_out=?,category=?,location=? where meeting_hall_number=?";
		
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt1 = conn.prepareStatement(updateRoomQuery);
		
		pstmt1.setDate(1, new java.sql.Date(checkIn.getTime()));
		pstmt1.setDate(2, new java.sql.Date(checkOut.getTime()));
		pstmt1.setString(3, category);
		pstmt1.setString(4, location);
		pstmt1.setInt(5, meetingHallNumber);
		
		pstmt1.executeUpdate();

		
		String fetchVacantRoom="select meeting_hall_number from meeting_hall_details where status='vacant' and category=? and location=?";
		String updateRoomQuery2="update meeting_hall_transaction set meeting_hall_number=? where check_in=? and check_out=? and category=? and location=? and guest_id=?";
		String updateRoomQuery3 = "update meeting_hall_details set status='vacant' where meeting_hall_number=?";
		String updateRoomQuery4 = "update meeting_hall_details set status='occupied' where meeting_hall_number=?";
		
		PreparedStatement pstmt2 = conn.prepareStatement(fetchVacantRoom);
		PreparedStatement pstmt3 = conn.prepareStatement(updateRoomQuery2);
		PreparedStatement pstmt4 = conn.prepareStatement(updateRoomQuery3);
		PreparedStatement pstmt5 = conn.prepareStatement(updateRoomQuery4);
		
		pstmt2.setString(1, category);
//		System.out.println(category);
		pstmt2.setString(2, location);
//		System.out.println(location);

		
		ResultSet rs = pstmt2.executeQuery();
		if(rs.next())
		{
			vacantMeetingHallNumber=rs.getInt(1);
			System.out.println(rs.getInt(1));
		}
//		System.out.println(vacantRoomNumber);
		
		GuestDao guestDaoObj = new GuestDao();
		guestId=guestDaoObj.findGuestId(guestObj);
		
		pstmt3.setInt(1, vacantMeetingHallNumber);
		pstmt3.setDate(2, new java.sql.Date(checkIn.getTime()));
		pstmt3.setDate(3, new java.sql.Date(checkOut.getTime()));
		pstmt3.setString(4, category);
		pstmt3.setString(5, location);
		pstmt3.setInt(6, guestId);
		
		pstmt3.executeUpdate();

		
		pstmt4.setInt(1, meetingHallNumber);
		pstmt4.executeUpdate();
		
		pstmt5.setInt(1, vacantMeetingHallNumber);
		pstmt5.executeUpdate();
		
		if(i>0)
		{
			System.out.println("Updated Room details");
		}
		
	}
	
		
	
}