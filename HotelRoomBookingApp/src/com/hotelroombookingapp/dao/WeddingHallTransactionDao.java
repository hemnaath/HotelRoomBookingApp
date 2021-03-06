package com.hotelroombookingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.hotelroombookingapp.message.Mail;
import com.hotelroombookingapp.message.Mailer;
import com.hotelroombookingapp.model.Guest;
import com.hotelroombookingapp.model.RoomTransaction;
import com.hotelroombookingapp.model.WeddingHallTransaction;

public class WeddingHallTransactionDao
{
	public WeddingHallTransaction bookWeddingHall(Guest guestObj) throws SQLException, ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Scanner sc = new Scanner(System.in);
		int vacantWeddingRoomNumber=0;
		int guestId=0;
		int i=0;
		boolean dateFlag=true;
		Date checkIn;
		Date checkOut;
		
		do {
		System.out.println("enter check-in date");
		checkIn = sdf.parse(sc.nextLine());
		System.out.println("enter check-out date");
		checkOut = sdf.parse(sc.nextLine());
		if(checkIn.after(checkOut))
		{
			System.out.println("Invalid Date Format");
			dateFlag=false;
		}
		else
		{
			dateFlag=true;
		}
		}while(dateFlag!=true);
		System.out.println("enter category");
		System.out.println("1.Premium\n2.luxury\n3.standard\n4.budget");
		int categoryChoice = Integer.parseInt(sc.nextLine());
		String category = (categoryChoice==1)?"premium":(categoryChoice==2)?"luxury":(categoryChoice==3)?"standard":"budget";
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
		WeddingHallTransaction weddingHallTransObj = new WeddingHallTransaction(vacantWeddingRoomNumber,String.valueOf(checkIn),
				String.valueOf(checkOut),category,location);

		
		i = pstmt2.executeUpdate();
	

		
		if(i>0)
		{
			System.out.println("Weddings Hall booked");
			pstmt3.executeUpdate();
			Mailer.send("hemnaathrsurya@gmail.com", "hemnaath@18!!", guestObj.getEmail(), "Hotel Room Booking Application", Mail.bookWeddingHallMail(weddingHallTransObj));

		}
		else
		{
			System.out.println("Error in booking");
		}
		return weddingHallTransObj;

	}
	
	
	
	public WeddingHallTransaction cancelWeddingHall(Guest guestObj) throws SQLException
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter wedding hall number");
		int weddingRoomNumber = Integer.parseInt(sc.nextLine());
		
		String updateCancelWeddingRoomQuery = "update wedding_hall_details set status='vacant' where wedding_hall_number=?";
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = conn.prepareStatement(updateCancelWeddingRoomQuery);
				
		pstmt.setInt(1, weddingRoomNumber);
		
		WeddingHallTransaction weddingHallTransObj = new WeddingHallTransaction(weddingRoomNumber,null,null,null,null);

				
		int i=pstmt.executeUpdate();
		

		
		if(i>0)
		{
			System.out.println("Booking Cancelled");
			Mailer.send("hemnaathrsurya@gmail.com", "hemnaath@18!!", guestObj.getEmail(), "Hotel Room Booking Application", Mail.cancelWeddingHallMail(weddingHallTransObj));

		}
		else
		{
			System.out.println("Invalid Room");
		}
		return weddingHallTransObj;
	}
	
	
	
	
	public WeddingHallTransaction updateWeddingHall(Guest guestObj) throws ParseException, SQLException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Scanner sc = new Scanner(System.in);
		int vacantWeddingRoomNumber=0;
		int i=0;
		int guestId=0;
		boolean dateFlag=true;
		Date checkIn;
		Date checkOut;
		
		System.out.println("enter wedding room number");
		int weddingRoomNumber = Integer.parseInt(sc.nextLine());
		do {
		System.out.println("enter check-in date");
		checkIn = sdf.parse(sc.nextLine());
		System.out.println("enter check-out date");
		checkOut = sdf.parse(sc.nextLine());
		if(checkIn.after(checkOut))
		{
			System.out.println("Invalid Date Format");
			dateFlag=false;
		}
		else
		{
			dateFlag=true;
		}
		}while(dateFlag!=true);
		System.out.println("enter category");
		System.out.println("1.premium\n2.luxury\n3.standard\n4.budget");
		int categoryChoice = Integer.parseInt(sc.nextLine());
		String category = (categoryChoice==1)?"Premium":(categoryChoice==2)?"luxury":(categoryChoice==3)?"standard":"budget";
		System.out.println("enter location");
		String location = sc.nextLine();
		
		String updateRoomQuery="update wedding_hall_transaction set check_in=?,check_out=?,category=?,location=? where wedding_hall_number=?";
		
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt1 = conn.prepareStatement(updateRoomQuery);
		
		pstmt1.setDate(1, new java.sql.Date(checkIn.getTime()));
		pstmt1.setDate(2, new java.sql.Date(checkOut.getTime()));
		pstmt1.setString(3, category);
		pstmt1.setString(4, location);
		pstmt1.setInt(5, weddingRoomNumber);
		
		pstmt1.executeUpdate();

		
		String fetchVacantRoom="select wedding_hall_number from wedding_hall_details where status='vacant' and category=? and location=?";
		String updateRoomQuery2="update wedding_hall_transaction set wedding_hall_number=? where check_in=? and check_out=? and category=? and location=? and guest_id=?";
		String updateRoomQuery3 = "update wedding_hall_details set status='vacant' where wedding_hall_number=?";
		String updateRoomQuery4 = "update wedding_hall_details set status='occupied' where wedding_hall_number=?";
		
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
			vacantWeddingRoomNumber=rs.getInt(1);
			System.out.println(rs.getInt(1));
		}
//		System.out.println(vacantRoomNumber);
		
		GuestDao guestDaoObj = new GuestDao();
		guestId=guestDaoObj.findGuestId(guestObj);
		
		pstmt3.setInt(1, vacantWeddingRoomNumber);
		pstmt3.setDate(2, new java.sql.Date(checkIn.getTime()));
		pstmt3.setDate(3, new java.sql.Date(checkOut.getTime()));
		pstmt3.setString(4, category);
		pstmt3.setString(5, location);
		pstmt3.setInt(6, guestId);
		
		pstmt3.executeUpdate();
		
		WeddingHallTransaction weddingHallTransObj = new WeddingHallTransaction(vacantWeddingRoomNumber,String.valueOf(checkIn),String.valueOf(checkOut)
				,category,location);
		Mailer.send("hemnaathrsurya@gmail.com", "hemnaath@18!!", guestObj.getEmail(), "Hotel Room Booking Application", Mail.updateWeddingHallMail(weddingHallTransObj));


		
		pstmt4.setInt(1, weddingRoomNumber);
		pstmt4.executeUpdate();
		
		pstmt5.setInt(1, vacantWeddingRoomNumber);
		pstmt5.executeUpdate();
		
		if(i>0)
		{
			System.out.println("Updated Room details");
		}
		return weddingHallTransObj;
		
	}
	
	
	
	
	
	
	
	public List<WeddingHallTransaction> showWeddingHallBooking(Guest guestObj) throws SQLException	
	{
		int guestId=0;
		List<WeddingHallTransaction> weddingHallBooking = new ArrayList<WeddingHallTransaction>();
		
		String showWeddingHallBookingQuery = "select * from wedding_hall_transaction where guest_id=?";
		
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = conn.prepareStatement(showWeddingHallBookingQuery);
		
		GuestDao guestDaoObj = new GuestDao();
		guestId=guestDaoObj.findGuestId(guestObj);
		
		pstmt.setInt(1, guestId);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			WeddingHallTransaction weddingHallTrans = new WeddingHallTransaction(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			weddingHallBooking.add(weddingHallTrans);
		}
		
		return weddingHallBooking;
	}
	
	
	
	
	
	public void addWeddingHallAdmin() throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter wedding hall number");
		int weedingHallNumber = Integer.parseInt(sc.nextLine());
		System.out.println("enter wedding hall category");
		String weddingHallCategory = sc.nextLine();
		System.out.println("enter wedding hall location");
		String weddingHallLocation = sc.nextLine();
		System.out.println("enter wedding hall price");
		int weddingHallPrice = Integer.parseInt(sc.nextLine());
		
		
		String addWeddingHallQuery="insert into wedding_hall_details(wedding_hall_number,category,location,price) values(?,?,?,?)";
		
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = conn.prepareStatement(addWeddingHallQuery);
		
		pstmt.setInt(1,weedingHallNumber);
		pstmt.setString(2,weddingHallCategory);
		pstmt.setString(3,weddingHallLocation);
		pstmt.setInt(4,weddingHallPrice);
		
		int i=pstmt.executeUpdate();
		if(i>0)
		{
			System.out.println("wedding hall added");
		}
		else
		{
			System.out.println("Error");
		}
	}
	
	
	
	
	
	
	public void deleteWeddingHallAdmin() throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter wedding hall number");
		int weddingHallNumber = Integer.parseInt(sc.nextLine());
		
		String deleteWeddingHallQuery = "delete from wedding_hall_details where wedding_hall_number=?";
		
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = conn.prepareStatement(deleteWeddingHallQuery);
		
		pstmt.setInt(1, weddingHallNumber);
		
		int i=pstmt.executeUpdate();
		if(i>0)
		{
			System.out.println("wedding hall deleted");
		}
		else
		{
			System.err.println("error");
		}
	}
	
	
	
	
	
	public void updateWeddingHallAdmin() throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter wedding room number");
		int weddingHallNumber = Integer.parseInt(sc.nextLine());
		System.out.println("enter wedding room category");
		String weddingHallCategory = sc.nextLine();
		System.out.println("enter wedding room location");
		String weddingHallLocation = sc.nextLine();
		System.out.println("enter wedding room price");
		int weddingHallPrice = Integer.parseInt(sc.nextLine());
		
		String updateRoomQuery="update wedding_hall_details set category=?,location=?,price=? where wedding_hall_number=?";
		
		Connection conn = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = conn.prepareStatement(updateRoomQuery);
		
		pstmt.setString(1, weddingHallCategory);
		pstmt.setString(2, weddingHallLocation);
		pstmt.setInt(3, weddingHallPrice);
		pstmt.setInt(4, weddingHallNumber);
		
		int i=pstmt.executeUpdate();
		if(i>0)
		{
			System.out.println("wedding hall updated");
		}
		else
		{
			System.err.println("error");
		}
	}
	
	
	
	
	
	
}