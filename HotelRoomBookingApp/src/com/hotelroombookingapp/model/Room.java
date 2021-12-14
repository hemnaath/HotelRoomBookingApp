package com.hotelroombookingapp.model;

import java.util.Objects;

public class Room {
	
	private int id;
	private int totalRooms;
	private int availble;
	private RoomType roomType;
	
	public Room(int id, int totalRooms, int availble, RoomType roomType) 
	{
		super();
		this.id = id;
		this.totalRooms = totalRooms;
		this.availble = availble;
		this.roomType = roomType;
	}
	
	public Room() 
	{
		super();
	}
	
	@Override
	public String toString() 
	{
		return "Room [id=" + id + "\ntotalRooms=" + totalRooms + "\navailble=" + availble + "\nroomType=" + roomType + "]";
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
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	
	@Override
	public int hashCode() 
	{
		return Objects.hash(availble, id, roomType, totalRooms);
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
		Room other = (Room) obj;
		return availble == other.availble && id == other.id && Objects.equals(roomType, other.roomType)
				&& totalRooms == other.totalRooms;
	}
	
	

}
