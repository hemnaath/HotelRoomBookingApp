package com.hotelroombookingapp.model;

import java.util.Objects;

public class WeddingHall 
{
	
	private int id;
	private int totalWeddingHalls;
	private int available;
	private Reservation reservation;
	public WeddingHall(int id, int totalWeddingHalls, int available, Reservation reservation) {
		super();
		this.id = id;
		this.totalWeddingHalls = totalWeddingHalls;
		this.available = available;
		this.reservation = reservation;
	}
	public WeddingHall() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "WeddingHall [id=" + id + ", totalWeddingHalls=" + totalWeddingHalls + ", available=" + available
				+ ", reservation=" + reservation + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(available, id, reservation, totalWeddingHalls);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeddingHall other = (WeddingHall) obj;
		return available == other.available && id == other.id && Objects.equals(reservation, other.reservation)
				&& totalWeddingHalls == other.totalWeddingHalls;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalWeddingHalls() {
		return totalWeddingHalls;
	}
	public void setTotalWeddingHalls(int totalWeddingHalls) {
		this.totalWeddingHalls = totalWeddingHalls;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
	

}
