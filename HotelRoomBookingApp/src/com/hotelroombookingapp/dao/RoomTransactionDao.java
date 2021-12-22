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
		
		
		
		
		String fetchVacantRoom="select room_number from room_details where status='vacant' and category=? and location=?";
		
		String bookRoomQuery="insert into room_transaction(room_number,check_in,check_out,category,location,guest_id) values(?,?,?,?,?,?)";
		String updateBookRoomQuery="update room_details set status='occupied' where room_number=?";
//		System.out.println(bookRoomQuery);
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt1 = conn.prepareStatement(fetchVacantRoom);
		
		pstmt1.setString(1, category);
		pstmt1.setString(2, location);
		
		ResultSet rs = pstmt1.executeQuery();
		if(rs.next())
		{
			vacantRoomNumber=rs.getInt(1);
		}
//		System.out.println(vacantRoomNumber);
		PreparedStatement pstmt2 = conn.prepareStatement(bookRoomQuery);
		PreparedStatement pstmt3 = conn.prepareStatement(updateBookRoomQuery);
		
		GuestDao guestDaoObj = new GuestDao();

		guestId=guestDaoObj.findGuestId(guestObj);
//		System.out.println(guestId);
		
		pstmt2.setInt(1, vacantRoomNumber);
		pstmt2.setDate(2, new java.sql.Date(checkIn.getTime()));
		pstmt2.setDate(3, new java.sql.Date(checkOut.getTime()));
		pstmt2.setString(4, category);
		pstmt2.setString(5,location);
		pstmt2.setInt(6, guestId);
		
		pstmt3.setInt(1, vacantRoomNumber);
		
//		System.out.println(bookRoomQuery);

		
		i = pstmt2.executeUpdate();
		if(i>0)
		{
			System.out.println("Room booked");
			pstmt3.executeUpdate();
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
	
	
	
	
	
	
	public void updateRoom(Guest guestObj) throws ParseException, SQLException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Scanner sc = new Scanner(System.in);
		int vacantRoomNumber=0;
		int i=0;
		int guestId=0;
		
		System.out.println("enter room number");
		int roomNumber = Integer.parseInt(sc.nextLine());
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
		
		String updateRoomQuery="update room_transaction set check_in=?,check_out=?,category=?,location=? where room_number=?";
		
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt1 = conn.prepareStatement(updateRoomQuery);
		
		pstmt1.setDate(1, new java.sql.Date(checkIn.getTime()));
		pstmt1.setDate(2, new java.sql.Date(checkOut.getTime()));
		pstmt1.setString(3, category);
		pstmt1.setString(4, location);
		pstmt1.setInt(5, roomNumber);
		
		pstmt1.executeUpdate();

		
		String fetchVacantRoom="select room_number from room_details where status='vacant' and category=? and location=?";
		String updateRoomQuery2="update room_transaction set room_number=? where check_in=? and check_out=? and category=? and location=? and guest_id=?";
		String updateRoomQuery3 = "update room_details set status='vacant' where room_number=?";
		String updateRoomQuery4 = "update room_details set status='occupied' where room_number=?";
		
		PreparedStatement pstmt2 = conn.prepareStatement(fetchVacantRoom);
		PreparedStatement pstmt3 = conn.prepareStatement(updateRoomQuery2);
		PreparedStatement pstmt4 = conn.prepareStatement(updateRoomQuery3);
		PreparedStatement pstmt5 = conn.prepareStatement(updateRoomQuery4);
		
		pstmt2.setString(1, category);
		System.out.println(category);
		pstmt2.setString(2, location);
		System.out.println(location);

		
		ResultSet rs = pstmt2.executeQuery();
		if(rs.next())
		{
			vacantRoomNumber=rs.getInt(1);
			System.out.println(rs.getInt(1));
		}
		System.out.println(vacantRoomNumber);
		
		//pstmt2.executeQuery();
		
		GuestDao guestDaoObj = new GuestDao();
		guestId=guestDaoObj.findGuestId(guestObj);
		
		pstmt3.setInt(1, vacantRoomNumber);
		pstmt3.setDate(2, new java.sql.Date(checkIn.getTime()));
		pstmt3.setDate(3, new java.sql.Date(checkOut.getTime()));
		pstmt3.setString(4, category);
		pstmt3.setString(5, location);
		pstmt3.setInt(6, guestId);
		
		System.out.println(pstmt3.executeUpdate()>0?"new Room num updated":"new room num not updated");

		
		pstmt4.setInt(1, roomNumber);
		System.out.println(pstmt4.executeUpdate()>0?"old Room updated":"old room not updated");
		
		pstmt5.setInt(1, vacantRoomNumber);
		System.out.println(pstmt5.executeUpdate()>0?"new Room updated":"new room  not updated");
		
		if(i>0)
		{
			System.out.println("Updated Room details");
		}
		
	}
	

}
