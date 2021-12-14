package com.hotelroombookingapp.model;

import java.util.Objects;

public class WeddingHall 
{
	
	private int id;
	private int totalWeddingHalls;
	private int available;
	
	public WeddingHall(int id, int totalWeddingHalls, int available) 
	{
		super();
		this.id = id;
		this.totalWeddingHalls = totalWeddingHalls;
		this.available = available;
	}
	
	public WeddingHall() 
	{
		super();
	}
	
	@Override
	public String toString() 
	{
		return "WeddingHall [id=" + id + "\ntotalWeddingHalls=" + totalWeddingHalls + "\navailable=" + available + "]";
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
	
	@Override
	public int hashCode() 
	{
		return Objects.hash(available, id, totalWeddingHalls);
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
		WeddingHall other = (WeddingHall) obj;
		return available == other.available && id == other.id && totalWeddingHalls == other.totalWeddingHalls;
	}
	

}
