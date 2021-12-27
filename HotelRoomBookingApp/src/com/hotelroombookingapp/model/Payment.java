package com.hotelroombookingapp.model;

import java.util.Objects;

public class Payment 
{
	private int id;
	private long cardNumber;
	private Guest guestId;
	public Payment(int id, long cardNumber, Guest guestId) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.guestId = guestId;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", cardNumber=" + cardNumber + ", guestId=" + guestId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cardNumber, guestId, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return cardNumber == other.cardNumber && Objects.equals(guestId, other.guestId) && id == other.id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Guest getGuestId() {
		return guestId;
	}
	public void setGuestId(Guest guestId) {
		this.guestId = guestId;
	}
	
	
}