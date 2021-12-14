package com.hotelroombookingapp.model;

import java.util.Objects;

public class OccupiedRooms 
{
	
	private int id;
	private String checkIn;
	private String checkOut;
	private int roomNumber;
	private Room room;
	private Reservation reservation;
	
	public OccupiedRooms(int id, String checkIn, String checkOut, int roomNumber, Room room, Reservation reservation) 
	{
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomNumber = roomNumber;
		this.room = room;
		this.reservation = reservation;
	}
	
	public OccupiedRooms() 
	{
		super();
	}
	
	@Override
	public String toString() 
	{
		return "OccupiedRooms [id=" + id + "\ncheckIn=" + checkIn + "\ncheckOut=" + checkOut + "\nroomNumber="
				+ roomNumber + "\nroom=" + room + "\nreservation=" + reservation + "]";
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
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
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
		return Objects.hash(checkIn, checkOut, id, reservation, room, roomNumber);
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
		OccupiedRooms other = (OccupiedRooms) obj;
		return Objects.equals(checkIn, other.checkIn) && Objects.equals(checkOut, other.checkOut) && id == other.id
				&& Objects.equals(reservation, other.reservation) && Objects.equals(room, other.room)
				&& roomNumber == other.roomNumber;
	}
	

}
