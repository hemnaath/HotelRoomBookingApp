package com.hotelroombookingapp.model;

import java.util.Objects;

public class OccupiedWeddingHalls 
{
	private int id;
	private String checkIn;
	private String checkOut;
	private int wedding_hall_number;
	private WeddingHall weddingHall;
	private Reservation reservation;
	
	public OccupiedWeddingHalls(int id, String checkIn, String checkOut, int wedding_hall_number,
			WeddingHall weddingHall, Reservation reservation) 
	{
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.wedding_hall_number = wedding_hall_number;
		this.weddingHall = weddingHall;
		this.reservation = reservation;
	}
	
	public OccupiedWeddingHalls() 
	{
		super();
	}
	
	@Override
	public String toString() 
	{
		return "OccupiedWeddingHalls [id=" + id + "\ncheckIn=" + checkIn + "\ncheckOut=" + checkOut
				+ "\nwedding_hall_number=" + wedding_hall_number + "\nweddingHall=" + weddingHall + "\nreservation="
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
	public int getWedding_hall_number() {
		return wedding_hall_number;
	}
	public void setWedding_hall_number(int wedding_hall_number) {
		this.wedding_hall_number = wedding_hall_number;
	}
	public WeddingHall getWeddingHall() {
		return weddingHall;
	}
	public void setWeddingHall(WeddingHall weddingHall) {
		this.weddingHall = weddingHall;
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
		return Objects.hash(checkIn, checkOut, id, reservation, weddingHall, wedding_hall_number);
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
		OccupiedWeddingHalls other = (OccupiedWeddingHalls) obj;
		return Objects.equals(checkIn, other.checkIn) && Objects.equals(checkOut, other.checkOut) && id == other.id
				&& Objects.equals(reservation, other.reservation) && Objects.equals(weddingHall, other.weddingHall)
				&& wedding_hall_number == other.wedding_hall_number;
	}
	
}
