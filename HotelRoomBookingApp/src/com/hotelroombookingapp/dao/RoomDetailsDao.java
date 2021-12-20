package com.hotelroombookingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		
		System.out.println("enter checkin date");
		Date checkIn = sdf.parse(sc.nextLine());
		System.out.println("enter checkin date");
		Date checkOut = sdf.parse(sc.nextLine());
		System.out.println("enter category");
		System.out.println("1.Premium\n2.luxury\n3.standard\n4.budget");
		int categoryChoice = Integer.parseInt(sc.nextLine());
		String category = (categoryChoice==1)?"Premium":(categoryChoice==2)?"luxury":(categoryChoice==3)?"standard":"budget";
		System.out.println("enter location");
		String location = sc.nextLine();
		
		
		
		
		String bookRoomQuery="insert into room_details(made_by,check_in,check_out,category,location,guest_id) "
				+ "values(?,?,?,?,?,?)";
		String updateBookRoomQuery="update room_details set status='occupied' where made_by=?";
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = conn.prepareStatement(bookRoomQuery);
		PreparedStatement pstmt2 = conn.prepareStatement(updateBookRoomQuery);
		
		GuestDao gDao = new GuestDao();
		
		pstmt.setString(1, guestObj.getFirstName());
		pstmt.setDate(2, new java.sql.Date(checkIn.getTime()));
		pstmt.setDate(3, new java.sql.Date(checkOut.getTime()));
		pstmt.setString(4, category);
		pstmt.setString(5,location);
		int guestId=gDao.findGuestId(guestObj);
		pstmt.setInt(6, guestId);
		
		pstmt2.setString(1, guestObj.getFirstName());
		
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

}
