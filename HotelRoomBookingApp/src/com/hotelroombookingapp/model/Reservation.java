package com.hotelroombookingapp.model;

import java.util.Objects;

public class Reservation 
{
	private int id;
	private String checkIn;
	private String checkOut;
	private String madeBy;
	private String booking;
	private String location;
	private Guest guest;
	
	public Reservation(int id, String checkIn, String checkOut, String madeBy, String booking, String location, Guest guest) 
	{
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.madeBy = madeBy;
		this.booking = booking;
		this.location = location;
		this.guest = guest;
	}
	
	@Override
	public int hashCode() 
	{
		return Objects.hash(booking, checkIn, checkOut, guest, id, madeBy, location);
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
		Reservation other = (Reservation) obj;
		return Objects.equals(booking, other.booking) && Objects.equals(checkIn, other.checkIn)
				&& Objects.equals(checkOut, other.checkOut) && Objects.equals(guest, other.guest) && id == other.id
				&& Objects.equals(madeBy, other.madeBy) && Objects.equals(location, other.location);
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
	public String getMadeBy() {
		return madeBy;
	}
	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}
	public String getBooking() {
		return booking;
	}
	public void setBooking(String booking) {
		this.booking = booking;
	}
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() 
	{
		return "Reservation [id=" + id + "\ncheckIn=" + checkIn + "\ncheckOut=" + checkOut + "\nmadeBy=" + madeBy
				+ "\nbooking=" + booking + "\nlocation=" + location + "\nguest=" + guest + "]";
	}
	public Reservation() 
	{
		super();
	}
}
