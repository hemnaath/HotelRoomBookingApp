package com.hotelroombookingapp.model;

import java.util.Objects;

public class Admin 
{
	private int id;
	private String email;
	private String password;
	
	public Admin(int id, String email, String password) 
	{
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	
	public Admin() 
	{
		super();
	}
	
	@Override
	public String toString() 
	{
		return "Admin [id=" + id + "\nemail=" + email + "\npassword=" + password + "]";
	}
	
	@Override
	public int hashCode() 
	{
		return Objects.hash(email, id, password);
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
		Admin other = (Admin) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(password, other.password);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
