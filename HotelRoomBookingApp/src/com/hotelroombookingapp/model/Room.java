package com.hotelroombookingapp.model;

import java.util.Objects;

public class Room {
	
	private int id;
	private int totalRooms;
	private int availble;
	private Reservation reservation;
	public Room(int id, int totalRooms, int availble, Reservation reservation) {
		super();
		this.id = id;
		this.totalRooms = totalRooms;
		this.availble = availble;
		this.reservation = reservation;
	}
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", totalRooms=" + totalRooms + ", availble=" + availble + ", reservation="
				+ reservation + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(availble, id, reservation, totalRooms);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return availble == other.availble && id == other.id && Objects.equals(reservation, other.reservation)
				&& totalRooms == other.totalRooms;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalRooms() {
		return totalRooms;
	}
	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}
	public int getAvailble() {
		return availble;
	}
	public void setAvailble(int availble) {
		this.availble = availble;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
}
