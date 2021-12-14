package com.hotelroombookingapp.model;

import java.util.Objects;

public class RoomType 
{
	
	private int id;
	private String category;
	private int capacity;
	
	public RoomType(int id, String category, int capacity) 
	{
		super();
		this.id = id;
		this.category = category;
		this.capacity = capacity;
	}
	
	public RoomType() 
	{
		super();
	}
	
	@Override
	public String toString() 
	{
		return "RoomType [id=" + id + "\ncategory=" + category + "\ncapacity=" + capacity + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public int hashCode() 
	{
		return Objects.hash(capacity, category, id);
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
		RoomType other = (RoomType) obj;
		return capacity == other.capacity && Objects.equals(category, other.category) && id == other.id;
	}
	

}
