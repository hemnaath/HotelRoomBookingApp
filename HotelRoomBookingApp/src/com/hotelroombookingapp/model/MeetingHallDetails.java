package com.hotelroombookingapp.model;

import java.util.Objects;

public class MeetingHallDetails {
	
	private int room_number;
	private String madeBy;
	private String checkIn;
	private String checkOut;
	private String category;
	private String location;
	private Guest guest_id;
	public MeetingHallDetails(int room_number, String madeBy, String checkIn, String checkOut, String category,
			String location, Guest guest_id) {
		super();
		this.room_number = room_number;
		this.madeBy = madeBy;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.category = category;
		this.location = location;
		this.guest_id = guest_id;
	}
	public MeetingHallDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RoomDetails [room_number=" + room_number + ", madeBy=" + madeBy + ", checkIn=" + checkIn + ", checkOut="
				+ checkOut + ", category=" + category + ", location=" + location + ", guest_id=" + guest_id + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(category, checkIn, checkOut, guest_id, location, madeBy, room_number);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetingHallDetails other = (MeetingHallDetails) obj;
		return Objects.equals(category, other.category) && Objects.equals(checkIn, other.checkIn)
				&& Objects.equals(checkOut, other.checkOut) && Objects.equals(guest_id, other.guest_id)
				&& Objects.equals(location, other.location) && Objects.equals(madeBy, other.madeBy)
				&& room_number == other.room_number;
	}
	public int getRoom_number() {
		return room_number;
	}
	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}
	public String getMadeBy() {
		return madeBy;
	}
	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Guest getGuest_id() {
		return guest_id;
	}
	public void setGuest_id(Guest guest_id) {
		this.guest_id = guest_id;
	}
	
	

}
