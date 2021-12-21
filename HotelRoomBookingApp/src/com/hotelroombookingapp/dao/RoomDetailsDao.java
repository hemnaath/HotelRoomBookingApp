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

public class RoomDetailsDao {
	
	public void bookRoom(Guest guestObj) throws SQLException, ParseException
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
		
		
		
		
		String bookRoomQuery="update room_details set check_in=?,check_out=?,made_by=?,category=?,location=?,guest_id=? where room_number=?";
		String updateBookRoomQuery="update room_details set status='occupied' where room_number=?";
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = conn.prepareStatement(bookRoomQuery);
		PreparedStatement pstmt2 = conn.prepareStatement(updateBookRoomQuery);
		
		GuestDao guestDaoObj = new GuestDao();
		RoomDetailsDao roomDao = new RoomDetailsDao();

		
		pstmt.setDate(1, new java.sql.Date(checkIn.getTime()));
		pstmt.setDate(2, new java.sql.Date(checkOut.getTime()));
		pstmt.setString(3, guestObj.getFirstName());
		pstmt.setString(4, category);
		pstmt.setString(5,location);
		int guestId=guestDaoObj.findGuestId(guestObj);
		pstmt.setInt(6, guestId);
		pstmt.setInt(7, roomDao.findRoomNumber());
		
		pstmt2.setInt(1, roomDao.findRoomNumber());
		
		int i = pstmt.executeUpdate();
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
		
		String cancelRoomQuery = "delete from room_details where room_number=? and guest_id=?";
		String updateCancelRoomQuery = "insert into room_details(room_number,status)values(?,'vacant')";
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = conn.prepareStatement(cancelRoomQuery);
		PreparedStatement pstmt2 = conn.prepareStatement(updateCancelRoomQuery);
		
		GuestDao guestDaoObj = new GuestDao();
		
		pstmt.setInt(1, roomNumber);
		int guestId=guestDaoObj.findGuestId(guestObj);
		pstmt.setInt(2, guestId);
		
		pstmt2.setInt(1, roomNumber);
		
		int i=pstmt.executeUpdate();
		if(i>0)
		{
			System.out.println("Booking Cancelled");
			pstmt2.executeQuery();
		}
		else
		{
			System.out.println("Invalid Room");
		}
	}
	
	
	
	
	
	
	public int findRoomNumber() throws SQLException
	{
		int vacantRoomNumber=0;
		String findRoomNumberQuery="select room_number from room_details where status='vacant'";
		Connection conn = ConnectionUtil.getDbConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(findRoomNumberQuery);
		if(rs.next())
		{
			vacantRoomNumber = rs.getInt(1);
//			System.out.println(vacantRoomNumber);
		}
//		RoomDetailsDao roomDao = new RoomDetailsDao();
		return vacantRoomNumber;
	}

}
