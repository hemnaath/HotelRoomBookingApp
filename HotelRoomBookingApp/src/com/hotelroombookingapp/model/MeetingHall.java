package com.hotelroombookingapp.model;

import java.util.Objects;

public class MeetingHall 
{
	private int id;
	private int totalMeetingHalls;
	private int availible;
	
	public MeetingHall(int id, int totalMeetingHalls, int availible) 
	{
		super();
		this.id = id;
		this.totalMeetingHalls = totalMeetingHalls;
		this.availible = availible;
	}
	
	public MeetingHall() 
	{
		super();
	}
	
	@Override
	public String toString() 
	{
		return "MeetingHall [id=" + id + "\ntotalMeetingHalls=" + totalMeetingHalls + "\navailible=" + availible + "]";
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
	
	@Override
	public int hashCode() 
	{
		return Objects.hash(availible, id, totalMeetingHalls);
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
		MeetingHall other = (MeetingHall) obj;
		return availible == other.availible && id == other.id && totalMeetingHalls == other.totalMeetingHalls;
	}
	
}
