package com.hotelroombookingapp.model;

import java.util.Objects;

public class MeetingHall 
{
	private int id;
	private int totalMeetingHalls;
	private int availible;
	private Reservation reservation;
	public MeetingHall(int id, int totalMeetingHalls, int availible, Reservation reservation) {
		super();
		this.id = id;
		this.totalMeetingHalls = totalMeetingHalls;
		this.availible = availible;
		this.reservation = reservation;
	}
	public MeetingHall() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MeetingHall [id=" + id + ", totalMeetingHalls=" + totalMeetingHalls + ", availible=" + availible
				+ ", reservation=" + reservation + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(availible, id, reservation, totalMeetingHalls);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetingHall other = (MeetingHall) obj;
		return availible == other.availible && id == other.id && Objects.equals(reservation, other.reservation)
				&& totalMeetingHalls == other.totalMeetingHalls;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalMeetingHalls() {
		return totalMeetingHalls;
	}
	public void setTotalMeetingHalls(int totalMeetingHalls) {
		this.totalMeetingHalls = totalMeetingHalls;
	}
	public int getAvailible() {
		return availible;
	}
	public void setAvailible(int availible) {
		this.availible = availible;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
	
}
