package com.hotelroombookingapp.test;

import java.util.List;
import java.util.Scanner;

import com.hotelroombookingapp.model.Admin;
import com.hotelroombookingapp.model.Guest;
import com.hotelroombookingapp.dao.AdminDao;
import com.hotelroombookingapp.dao.GuestDao;

public class Main 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		boolean flag=true;
		boolean flag2=true;
		int emailBreak=0;
		int firstNameBreak=0;
		int passwordBreak=0;
		char confirmFlag='n';
		int confirmBreak=0;
		int numberBreak=0;
		char numberFlag='n';
		int lastNameBreak=0;
		char lastNameFlag='n';
		char passwordFlag='n';
		char emailFlag='n';
		char firstNameFlag='n';
		while(flag2)
		{
			System.out.println("1.USER\n2.ADMIN");
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
							System.out.println("REGISTER PAGE");
							do
							{
								System.out.println("Enter Firstname");
								String rgFirstname = sc.nextLine();
								if(rgFirstname.matches("[a-zA-Z]{3,}"))
								{
									do
									{
										System.out.println("Enter Lastname");
										String rgLastname = sc.nextLine();
										if(rgLastname.matches("[a-zA-Z]{3,}"))
										{
											do 
											{
												System.out.println("Enter Email");
												String rgMail = sc.nextLine();
												if(rgMail.matches("[a-zA-Z0-9]+[@][a-z]+[.][a-z]{2,3}"))
												{
													do 
													{
														System.out.println("Enter Password");
														String rgPassword = sc.nextLine();
														if(rgPassword.matches("[A-Z]+[a-z]+[0-9]+"))
														{
															System.out.println("Confirm Password");
															String rgConfirmPassword = sc.nextLine();
															if(rgPassword.equals(rgConfirmPassword))
															{
																do
																{
																	System.out.println("Enter Mobile Number");
																	String rgMobileNumber = sc.nextLine();
																	if(rgMobileNumber.matches("[0-9]{10}"))
																	{
																		GuestDao guestregisterdao = new GuestDao();
																		Guest g1 = guestregisterdao.registerGuest(rgFirstname,rgLastname,rgMail,
																				rgPassword,
																		rgConfirmPassword,Long.parseLong(rgMobileNumber));
																		System.out.println("Registered Successfully");
																		passwordBreak=1;
																		emailBreak=1;
																		firstNameBreak=1;
																		lastNameBreak=1;
																		numberBreak=1;
																		confirmBreak=1;
																	}
																	else
																	{
																		System.out.println("enter valid mobile number");
																		numberFlag='y';
																	}
																	if(numberBreak==1)
																	{
																		break;
																	}
																}while(numberFlag!='n');
															}
															else
															{
																System.out.println("password mismatch");
																confirmFlag='y';
															}
															if(confirmBreak==1)
															{
																break;
															}
														}	
														else
														{
															System.out.println("password must contain atleast one capital letter, "
																	+ "one small letter, one digits");
															passwordFlag='y';
														}
														if(passwordBreak==1)
														{
															break;
														}
													}while(passwordFlag!='n');
												}
												else
												{
													System.out.println("Enter a valid e-mail");
													emailFlag='y';
												}
												if(emailBreak==1) 
												{
													break;
												}
											}while(emailFlag!='n');
										}
										else
										{
											System.out.println("Enter a valid name");
											lastNameFlag='y';
										}
										if(lastNameBreak==1)
										{
											break;
										}
									}while(lastNameFlag!='n');
								}
								else
								{
									System.out.println("Enter a valid name");
									firstNameFlag='y';
								}
								if(firstNameBreak==1)
								{
									break;
								}
							}while(firstNameFlag!='n');
//							System.out.flush();1
							
						case 2:
							//Login Guest
							System.out.println("LOGIN PAGE");
							System.out.println("Enter Email");
							String lgMail=sc.nextLine();
							System.out.println("Enter Password");
							String lgPassword=sc.nextLine();
							GuestDao gdao2 = new GuestDao();
							Guest g2=gdao2.loginGuest(lgMail, lgPassword);
							//if(lgMail.equals(g2.getEmail()) && lgPassword.equals(g2.getPassword())) 
							if(g2!=null)
							{
								System.out.println("Welcome "+g2.getFirstName());							
								while(flag)
								{
									System.out.println("1.book\n2.cancel\n3.update\n4.logout");
									int userOption = Integer.parseInt(sc.nextLine());
									switch(userOption)
									{
										case 1:
											System.out.println("Book Room");
											break;
										case 2:
											System.out.println("delete booked room");
											break;
										case 3:
											System.out.println("update booked rooms");
											break;
										case 4:
											flag=false;
											break;
									}
								}
							}
							else
							{
								System.out.println("Invalid username or password");
							}
							break;
					}
					break;
				case 2:						
					System.out.println("Enter Email-id");
					String adminMail = sc.nextLine();
					System.out.println("Enter Password");
					String adminPassword = sc.nextLine();
					AdminDao adao = new AdminDao();
					Admin a2=adao.loginAdmin(adminMail, adminPassword);
					if(a2!=null)
					{
						System.out.println("Welcome Admin");
						System.out.println("1.List all Guests");
						int adminChoice = Integer.parseInt(sc.nextLine());
						switch(adminChoice)
						{
						case 1:
							//list all user
							GuestDao gdao3 = new GuestDao();
							List<Guest> guestList = gdao3.showAllUser();
							for(int i=0;i<guestList.size();i++)
							{
								System.out.println(guestList.get(i));
							}
							break;
						}
					}
					else
					{
						System.out.println("invalid username or password");
					}												
			}
		}
	}
}
