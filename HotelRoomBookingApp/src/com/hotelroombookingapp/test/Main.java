package com.hotelroombookingapp.test;

import java.util.Scanner;

import com.hotelroombookingapp.model.Guest;
import com.hotelroombookingapp.dao.GuestDao;

public class Main 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("1.USER"+"\n"+"2.ADMIN");
		int choice = Integer.parseInt(sc.nextLine());
		
		switch(choice)
		{
		case 1:
			System.out.println("1.Register");
			System.out.println("2.Login");
			int userchoice = Integer.parseInt(sc.nextLine());
			
			switch(userchoice)
			{
			case 1:
				
				System.out.println("Enter Firstname");
				String rgFirstname = sc.nextLine();
				
				System.out.println("Enter Lastname");
				String rgLastname = sc.nextLine();
				
				System.out.println("Enter Email");
				String rgMail = sc.nextLine();
				
				System.out.println("Enter Password");
				String rgPassword = sc.nextLine();
				
				System.out.println("Confirm Password");
				String rgConfirmPassword = sc.nextLine();
				
				System.out.println("Enter Mobile Number");
				long rgMobileNumber = sc.nextLong();
				
				GuestDao guestregisterdao = new GuestDao();
				Guest g1 = guestregisterdao.registerGuest(rgFirstname,rgLastname,rgMail,rgPassword,rgConfirmPassword,rgMobileNumber);
				
		
				System.out.println("Registered Successfully");
				
				break;
				
			case 2:
				//Login Guest
				System.out.println("Enter Email");
				String lgMail=sc.nextLine();
				
				System.out.println("Enter Password");
				String lgPassword=sc.nextLine();
				
				
				GuestDao gdao2 = new GuestDao();
				Guest g2=gdao2.loginGuest(lgMail, lgPassword);
				System.out.println("Welcome "+g2.getFirstName());
				System.out.println("");
				
				break;
			
			}
			break;
			case 2:
				System.out.println("Admin CRUD");
				break;
		}
		
		
		
		
	}

}
