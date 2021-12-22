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

public class RoomTransactionDao {
	
	public void bookRoom(Guest guestObj) throws SQLException, ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Scanner sc = new Scanner(System.in);
		int vacantRoomNumber=0;
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
		
		
		
		
		String fetchVacantRoom="select room_number from room_details where status='vacant'";
		
		String bookRoomQuery="insert into room_transaction(room_number,check_in,check_out,category,location,guest_id) values(?,?,?,?,?,?)";
		String updateBookRoomQuery="update room_details set status='occupied' where room_number=?";
//		System.out.println(bookRoomQuery);
		Connection conn = ConnectionUtil.getDbConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(fetchVacantRoom);
		if(rs.next())
		{
			vacantRoomNumber=rs.getInt(1);
		}
//		System.out.println(vacantRoomNumber);
		PreparedStatement pstmt = conn.prepareStatement(bookRoomQuery);
		PreparedStatement pstmt2 = conn.prepareStatement(updateBookRoomQuery);
		
		GuestDao guestDaoObj = new GuestDao();
//		RoomTransactionDao roomDao = new RoomTransactionDao();

		guestId=guestDaoObj.findGuestId(guestObj);
//		System.out.println(guestId);
		
		pstmt.setInt(1, vacantRoomNumber);
		pstmt.setDate(2, new java.sql.Date(checkIn.getTime()));
		pstmt.setDate(3, new java.sql.Date(checkOut.getTime()));
		pstmt.setString(4, category);
		pstmt.setString(5,location);
		pstmt.setInt(6, guestId);
		
		pstmt2.setInt(1, vacantRoomNumber);
		
//		System.out.println(bookRoomQuery);

		
		i = pstmt.executeUpdate();
		if(i>0)
		{
			System.out.println("Room booked");
			pstmt2.executeUpdate();
		}
		else
		{
			System.out.println("Error in room booking");
		}
	}
	
	
	
	
	
	public void cancelRoom(Guest guestObj) throws SQLException
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter room number");
		int roomNumber = Integer.parseInt(sc.nextLine());
		
		String updateCancelRoomQuery = "update room_details set status='vacant' where room_number=?";
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = conn.prepareStatement(updateCancelRoomQuery);
				
		pstmt.setInt(1, roomNumber);
				
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
	
	
	
	
	
	
	public void updateRoom() throws ParseException, SQLException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Scanner sc = new Scanner(System.in);
		
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
		
		String updateRoomQuery="update room_transaction set check_in=?,check_out=?,category=?,location=?";
		
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = conn.prepareStatement(updateRoomQuery);
		
		pstmt.setDate(1, new java.sql.Date(checkIn.getTime()));
		pstmt.setDate(2, new java.sql.Date(checkOut.getTime()));
		pstmt.setString(4, location);
		
		
	}
	

}
