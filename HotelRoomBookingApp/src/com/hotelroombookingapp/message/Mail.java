package com.hotelroombookingapp.message;

import com.hotelroombookingapp.model.MeetingHallTransaction;
import com.hotelroombookingapp.model.RoomTransaction;
import com.hotelroombookingapp.model.WeddingHallTransaction;

public class Mail 
{
	public static String bookRoomMail(RoomTransaction roomTransObj)
	{
		String message="Welcome HR Residensy"+"\nYour Booking is Confirmed"+"\nRoom Number :"+roomTransObj.getroomNumber()
		+"\nCheck-In"+roomTransObj.getCheckIn()+"\nCheck-Out"+roomTransObj.getCheckOut()+"\nCategory"+roomTransObj.getCategory()+
		"\nLocation"+roomTransObj.getLocation();
		return message;
	}
	
	public static String cancelRoomMail(RoomTransaction roomTransObj)
	{
		String message="Welcome HR Residensy"+"\nYour Booking is Cancelled"+"\nRoom Number :"+roomTransObj.getroomNumber();
		return message;
	}
	
	public static String updateRoomMail(RoomTransaction roomTransObj)
	{
		String message="Welcome HR Residensy"+"\nYour Booking is Updated"+"\nRoom Number :"+roomTransObj.getroomNumber()
		+"\nCheck-In"+roomTransObj.getCheckIn()+"\nCheck-Out"+roomTransObj.getCheckOut()+"\nCategory"+roomTransObj.getCategory()+
		"\nLocation"+roomTransObj.getLocation();
		return message;
	}
	
	
	
	
	public static String bookWeddingHallMail(WeddingHallTransaction weddingHallTransObj)
	{
		String message="Welcome HR Residensy"+"\nYour Booking is Confirmed"+"\nWedding Hall Number :"+weddingHallTransObj.getroomNumber()
		+"\nCheck-In"+weddingHallTransObj.getCheckIn()+"\nCheck-Out"+weddingHallTransObj.getCheckOut()+"\nCategory"+weddingHallTransObj.getCategory()+
		"\nLocation"+weddingHallTransObj.getLocation();
		return message;
	}
	
	public static String cancelWeddingHallMail(WeddingHallTransaction weddingHallTransObj)
	{
		String message="Welcome HR Residensy"+"\nYour Booking is Cancelled"+"\nWedding Hall Number :"+weddingHallTransObj.getroomNumber();
		return message;
	}
	
	public static String updateWeddingHallMail(WeddingHallTransaction weddingHallTransObj)
	{
		String message="Welcome HR Residensy"+"\nYour Booking is Updated"+"\nWedding Hall Number :"+weddingHallTransObj.getroomNumber()
		+"\nCheck-In"+weddingHallTransObj.getCheckIn()+"\nCheck-Out"+weddingHallTransObj.getCheckOut()+"\nCategory"+weddingHallTransObj.getCategory()+
		"\nLocation"+weddingHallTransObj.getLocation();
		return message;
	}
	
	
	
	
	
	
	
	public static String bookMeetingHallMail(MeetingHallTransaction meetingHallTransObj)
	{
		String message="Welcome HR Residensy"+"\nYour Booking is Confirmed"+"\nMeeting Hall Number :"+meetingHallTransObj.getroomNumber()
		+"\nCheck-In"+meetingHallTransObj.getCheckIn()+"\nCheck-Out"+meetingHallTransObj.getCheckOut()+"\nCategory"+meetingHallTransObj.getCategory()+
		"\nLocation"+meetingHallTransObj.getLocation();
		return message;
	}
	
	public static String cancelMeetingHallMail(MeetingHallTransaction meetingHallTransObj)
	{
		String message="Welcome HR Residensy"+"\nYour Booking is Cancelled"+"\nMeeting Hall Number :"+meetingHallTransObj.getroomNumber();
		return message;
	}
	
	public static String updateMeetingHallMail(MeetingHallTransaction meetingHallTransObj)
	{
		String message="Welcome HR Residensy"+"\nYour Booking is Updated"+"\nWedding Hall Number :"+meetingHallTransObj.getroomNumber()
		+"\nCheck-In"+meetingHallTransObj.getCheckIn()+"\nCheck-Out"+meetingHallTransObj.getCheckOut()+"\nCategory"+meetingHallTransObj.getCategory()+
		"\nLocation"+meetingHallTransObj.getLocation();
		return message;
	}
}
