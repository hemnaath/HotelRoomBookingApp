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

public class ReservationDao {
	
	public boolean bookRoom(Guest guestObj) 
	{
		int i=0;
		try {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String bookRoomQuery = "insert into reservation_details (check_in,check_out,made_by,booking,category,location,guest_id) values (?,?,?,?,?,?,?)";
		System.out.println(bookRoomQuery);
		System.out.println("enter check-in date");
		Date checkIn = sdf.parse(sc.nextLine());
		
		System.out.println("enter check-out date");
		Date checkOut = sdf.parse(sc.nextLine());
		
		System.out.println("made by: " + guestObj.getFirstName()+" "+guestObj.getLastName());
		
		System.out.println("what u want to book");
		System.out.println("1.Rooms\n2.Wedding Hall\n3.Meeting Hall");
		int bookingChoice = Integer.parseInt(sc.nextLine());
		System.out.println("select category");
		System.out.println("1.Premium\n2.luxury\n3.standard\n4.budget");
		int categoryChoice = Integer.parseInt(sc.nextLine());
		String booked=(bookingChoice==1)?"Room":(bookingChoice==2)?"Wedding Hall":"Meeting Hall";
		String categoryCheck = (categoryChoice==1)?"Premium":(categoryChoice==2)?"luxury":(categoryChoice==3)?"standard":"budget";
		
		System.out.println("enter location");
		String location = sc.nextLine();
		
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = conn.prepareStatement(bookRoomQuery);
		GuestDao gDao = new GuestDao();
//		gDao.findGuestId(guestObj);
		
		pstmt.setDate(1, new java.sql.Date(checkIn.getTime()));
		pstmt.setDate(2, new java.sql.Date(checkOut.getTime()));
		pstmt.setString(3, guestObj.getFirstName());
		pstmt.setString(4, booked);
		pstmt.setString(5, categoryCheck);
		pstmt.setString(6,location);
//		System.out.println(gDao.findGuestId(guestObj));
		int guestId=gDao.findGuestId(guestObj);
		pstmt.setInt(7, guestId);
		
		 i=pstmt.executeUpdate();
		if(i>0)
		{
			System.out.println("Booked Successfully");
		}
		else
		{
			System.err.println("Failed to book");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
//		switch(bookingChoice)
//		{
//		case 1:
//			System.out.println("select category");
//			System.out.println("1.Premium\\n2.luxury\n3.standard\n4.budget");
//			int categoryChoice = Integer.parseInt(sc.nextLine());
//			switch(categoryChoice)
//			{
//				case 1:
//					String 
//					break;
//				case 2;
//				
//			}
//		}
		return (i<0)?true:false;
	}
	
	
	
	
	
	public void cancelBooking(Guest guestObj)
	{
		int i;
		try
		{
			String cancelRoomQuery="delete from reservation_details where guest_id = ?";
			Connection conn = ConnectionUtil.getDbConnection();
			PreparedStatement pstmt = conn.prepareStatement(cancelRoomQuery);
			GuestDao gDao = new GuestDao();
			int guestId=gDao.findGuestId(guestObj);
			pstmt.setInt(1, guestId);
			
			i = pstmt.executeUpdate();
			if(i>0)
			{
				System.out.println("Cancelled Successfully");
			}
			else
			{
				System.out.println("There is a error in Cancellation");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
