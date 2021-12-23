package com.hotelroombookingapp.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.hotelroombookingapp.model.Admin;
import com.hotelroombookingapp.model.Guest;
import com.hotelroombookingapp.model.MeetingHallTransaction;
import com.hotelroombookingapp.model.RoomTransaction;
import com.hotelroombookingapp.model.WeddingHallTransaction;
import com.hotelroombookingapp.dao.AdminDao;
import com.hotelroombookingapp.dao.GuestDao;
import com.hotelroombookingapp.dao.MeetingHallTransactionDao;
//import com.hotelroombookingapp.dao.RoomDetailsDao;
import com.hotelroombookingapp.dao.RoomTransactionDao;
import com.hotelroombookingapp.dao.WeddingHallTransactionDao;

public class Main 
{
	public static void main(String args[]) throws SQLException, ParseException
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
					System.out.println("3.Forget Password");
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
																		GuestDao guestDaoObj = new GuestDao();
																		Guest guestObj = guestDaoObj.registerGuest(rgFirstname,rgLastname,rgMail,
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
//							System.out.flush();
							
						case 2:
							//Login Guest
							System.out.println("LOGIN PAGE");
							System.out.println("Enter Email");
							String lgMail=sc.nextLine();
							System.out.println("Enter Password");
							String lgPassword=sc.nextLine();
							GuestDao guestDaoObj = new GuestDao();
							Guest guestObj=guestDaoObj.loginGuest(lgMail, lgPassword);
							//if(lgMail.equals(g2.getEmail()) && lgPassword.equals(g2.getPassword())) 
							if(guestObj!=null)
							{
								System.out.println("Welcome "+guestObj.getFirstName());							
								while(flag)
								{
									System.out.println("1.Room Booking\n2.Wedding Hall Booking\n3.Meeting Hall Booking\n4.My Bookings\n5.Logout");
									int bookingOption = Integer.parseInt(sc.nextLine());
									RoomTransactionDao roomDao = new RoomTransactionDao();
									WeddingHallTransactionDao weddingDao = new WeddingHallTransactionDao();
									MeetingHallTransactionDao meetingDao = new MeetingHallTransactionDao();
									switch(bookingOption)
									{
										case 1:
											System.out.println("1.Book Room\n2.Cancel Room\n3.Update Room\n4.Logout");
											int roomOption = Integer.parseInt(sc.nextLine());
											switch(roomOption)
											{
												case 1:
													System.out.println("bookroom");
													roomDao.bookRoom(guestObj);
													break;
												case 2:
													System.out.println("cancelroom");
													roomDao.cancelRoom(guestObj);
													break;
												case 3:
													System.out.println("update room");
													roomDao.updateRoom(guestObj);
													System.out.println("Updated Successfully");
													break;
												case 4:
													flag=false;
													break;
											}
											break;
										case 2:
											System.out.println("1.Book wedding hall\n2.Cancel wedding hall\n3.Update wedding hall\n4.Logout");
											int weddingOption = Integer.parseInt(sc.nextLine());
											switch(weddingOption)
											{
												case 1:
													System.out.println("bookroom");
													weddingDao.bookWeddingHall(guestObj);
													break;
												case 2:
													System.out.println("cancelroom");
													weddingDao.cancelWeddingHall(guestObj);
													break;
												case 3:
													System.out.println("update room");
													weddingDao.updateWeddingHall(guestObj);
													break;
												case 4:
													flag=false;
													break;
											}
											break;
										case 3:
											System.out.println("1.Book meeting hall\n2.Cancel meeting hall\n3.Update meeting hall\n4.Logout");
											int meetingOption = Integer.parseInt(sc.nextLine());
											switch(meetingOption)
											{
												case 1:
													System.out.println("bookroom");
													meetingDao.bookMeetingHall(guestObj);
													break;
												case 2:
													System.out.println("cancelroom");
													meetingDao.cancelMeetingHall(guestObj);
													break;
												case 3:
													System.out.println("update room");
													meetingDao.updateMeetingHall(guestObj);
													break;
												case 4:
													flag=false;
													break;
											}
											break;
										case 4:
											System.out.println("my bookings");
											List<RoomTransaction> roomBooking=roomDao.showRoomBooking(guestObj);
											for(int i=0;i<roomBooking.size();i++)
											{
												System.out.println(roomBooking.get(i));
											}
											List<WeddingHallTransaction> weddingHallBooking= weddingDao.showWeddingHallBooking(guestObj);
											for(int i=0;i<weddingHallBooking.size();i++)
											{
												System.out.println(weddingHallBooking.get(i));
											}
											List<MeetingHallTransaction> meetingHallBooking= meetingDao.showMeetingHallBooking(guestObj);
											for(int i=0;i<meetingHallBooking.size();i++)
											{
												System.out.println(meetingHallBooking.get(i));
											}
											break;
										case 5:
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
						case 3:
							GuestDao guestDaoObj2 = new GuestDao();
							System.out.println("forget password");
							guestDaoObj2.forgetPassword();
							break;
					}
					break;
				case 2:						
					System.out.println("Enter Email-id");
					String adminMail = sc.nextLine();
					System.out.println("Enter Password");
					String adminPassword = sc.nextLine();
					AdminDao adao = new AdminDao();
					Admin adminObj=adao.loginAdmin(adminMail, adminPassword);
					if(adminObj!=null)
					{
						System.out.println("Welcome Admin");
						System.out.println("1.List all Guests\n2.Add Room\n3.Add Wedding Room\n4.Add Meeting Room"
								+ "\n5.Delete Room\n6.Delete Wedding hall\n7.Delete Meeting hall\n8.update room"
								+ "\n9.update wedding hall\n10.update meeting hall");
						int adminChoice = Integer.parseInt(sc.nextLine());
						GuestDao guestDaoObj = new GuestDao();
						RoomTransactionDao roomTransDao = new RoomTransactionDao();
						WeddingHallTransactionDao weddingTransDao = new WeddingHallTransactionDao();
						MeetingHallTransactionDao meetingTransDao = new MeetingHallTransactionDao();
						switch(adminChoice)
						{
						case 1:
							//list all user
							List<Guest> guestList = guestDaoObj.showAllUser();
							for(int i=0;i<guestList.size();i++)
							{
								System.out.println(guestList.get(i));
							}
							break;
						case 2:
							roomTransDao.addRoomAdmin();
							break;
						case 3:
							weddingTransDao.addWeddingHallAdmin();
							break;
						case 4:
							meetingTransDao.addMeetingHallAdmin();
							break;
						case 5:
							roomTransDao.deleteRoomAdmin();
							break;
						case 6:
							weddingTransDao.deleteWeddingHallAdmin();
							break;
						case 7:
							meetingTransDao.deleteMeetingHallAdmin();
							break;
						case 8:
							roomTransDao.updateRoomAdmin();
							break;
						case 9:
							weddingTransDao.updateWeddingHallAdmin();
							break;
						case 10:
							meetingTransDao.updateMeetingHallAdmin();
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
