package com.hotelroombookingapp.model;

import java.util.Objects;

public class OccupiedMeetingHalls 
{
	private int id;
	private String checkIn;
	private String checkOut;
	private int meetingHallNumber;
	private MeetingHall meetingHall;
	private Reservation reservation;
	
	public OccupiedMeetingHalls(int id, String checkIn, String checkOut, int meetingHallNumber, MeetingHall meetingHall,
			Reservation reservation) 
	{
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.meetingHallNumber = meetingHallNumber;
		this.meetingHall = meetingHall;
		this.reservation = reservation;
	}
	
	public OccupiedMeetingHalls() 
	{
		super();
	}
	
	@Override
	public String toString() 
	{
		return "OccupiedMeetingHalls [id=" + id + "\ncheckIn=" + checkIn + "\ncheckOut=" + checkOut
				+ "\nmeetingHallNumber=" + meetingHallNumber + "\nmeetingHall=" + meetingHall + "\nreservation="
				+ reservation + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public int getMeetingHallNumber() {
		return meetingHallNumber;
	}
	public void setMeetingHallNumber(int meetingHallNumber) {
		this.meetingHallNumber = meetingHallNumber;
	}
	public MeetingHall getMeetingHall() {
		return meetingHall;
	}
	public void setMeetingHall(MeetingHall meetingHall) {
		this.meetingHall = meetingHall;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	@Override
	public int hashCode() 
	{
		return Objects.hash(checkIn, checkOut, id, meetingHall, meetingHallNumber, reservation);
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OccupiedMeetingHalls other = (OccupiedMeetingHalls) obj;
		return Objects.equals(checkIn, other.checkIn) && Objects.equals(checkOut, other.checkOut) && id == other.id
				&& Objects.equals(meetingHall, other.meetingHall) && meetingHallNumber == other.meetingHallNumber
				&& Objects.equals(reservation, other.reservation);
	}
	
	
}
