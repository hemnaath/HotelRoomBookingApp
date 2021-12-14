package com.hotelroombookingapp.model;

import java.util.Objects;

public class Payment 
{
	private int id;
	private String modeOfPayment;
	private String dateOfPay;
	private Guest guest;
	
	public Payment(int id, String modeOfPayment, String dateOfPay, Guest guest) 
	{
		super();
		this.id = id;
		this.modeOfPayment = modeOfPayment;
		this.dateOfPay = dateOfPay;
		this.guest = guest;
	}
	
	public Payment() 
	{
		super();
	}
	
	@Override
	public String toString() 
	{
		return "Payment [id=" + id + "\nmodeOfPayment=" + modeOfPayment + "\ndateOfPay=" + dateOfPay + "\nguest="
				+ guest + "]";
	}
	
	@Override
	public int hashCode() 
	{
		return Objects.hash(dateOfPay, guest, id, modeOfPayment);
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
		Payment other = (Payment) obj;
		return Objects.equals(dateOfPay, other.dateOfPay) && Objects.equals(guest, other.guest) && id == other.id
				&& Objects.equals(modeOfPayment, other.modeOfPayment);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getDateOfPay() {
		return dateOfPay;
	}
	public void setDateOfPay(String dateOfPay) {
		this.dateOfPay = dateOfPay;
	}
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	
}
