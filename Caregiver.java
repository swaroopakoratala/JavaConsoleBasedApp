package com.childdaycarecenter.registrationinformation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Caregiver {

	private String firstName_dcp;
	private String lastName_dcp;
	private String address_dcp;
	private String city_dcp;
	private String contact_dcp;
	private Integer pinCode_dcp;
	private String emailId_dcp;
	private String PreviousExperience;
	private String specialSkills_dcp;
	private String birthDate_dcp;
	private String gender_dcp;
	private String childtype_dcp;
	
	
	public void readcaregiver()
	{
	Scanner caregiverscanner = new Scanner(System.in);
	
	System.out.println("Enter your Firstname: ");
	
	 firstName_dcp = caregiverscanner.nextLine();
	
	System.out.println("Enter your Lastname: ");
	
	 lastName_dcp = caregiverscanner.nextLine();
	 
	System.out.println("Enter your Address: ");
		
	 address_dcp = caregiverscanner.nextLine(); 
	 
	System.out.println("Enter your City: ");
		

	city_dcp = caregiverscanner.nextLine();
	 
	System.out.println("Enter your Contact: ");
		
	 contact_dcp = caregiverscanner.nextLine();
	 
	 
	System.out.println("Enter your Pincode: ");
		
	 pinCode_dcp = caregiverscanner.nextInt();	 
	 caregiverscanner.nextLine();
	 
	System.out.println("Enter your Email: ");
		
	 emailId_dcp = caregiverscanner.nextLine();	
	 
	System.out.println("Enter your PreviousExperience: ");
		
	 PreviousExperience = caregiverscanner.nextLine();
	 
	System.out.println("Enter your SpecialSkills: ");
		
	 specialSkills_dcp = caregiverscanner.nextLine();
	 
	 System.out.println("Enter your birth date");
	 
	 birthDate_dcp = caregiverscanner.nextLine();
	 
	 
	 try {
		 SimpleDateFormat DateFormat4 = new SimpleDateFormat("dd-mm-yyyy");
		 DateFormat4.setLenient(false);
		 Date date5 = null;
		date5 = DateFormat4.parse(birthDate_dcp);
	} catch (java.text.ParseException e) {
		
		e.printStackTrace();
	}
	
	 System.out.println("Enter Gender");
	 gender_dcp = caregiverscanner.nextLine();
	
	 System.out.println("Enter you choice of teaching (Infants or toodlers)");
	
	 childtype_dcp = caregiverscanner.nextLine();
	
	}


	public String getFirstName_dcp() {
		return firstName_dcp;
	}


	public void setFirstName_dcp(String firstName_dcp) {
		this.firstName_dcp = firstName_dcp;
	}


	public String getLastName_dcp() {
		return lastName_dcp;
	}


	public void setLastName_dcp(String lastName_dcp) {
		this.lastName_dcp = lastName_dcp;
	}


	public String getAddress_dcp() {
		return address_dcp;
	}


	public void setAddress_dcp(String address_dcp) {
		this.address_dcp = address_dcp;
	}


	public String getCity_dcp() {
		return city_dcp;
	}


	public void setCity_dcp(String city_dcp) {
		this.city_dcp = city_dcp;
	}


	public String getContact_dcp() {
		return contact_dcp;
	}


	public void setContact_dcp(String contact_dcp) {
		this.contact_dcp = contact_dcp;
	}


	public Integer getPinCode_dcp() {
		return pinCode_dcp;
	}


	public void setPinCode_dcp(Integer pinCode_dcp) {
		this.pinCode_dcp = pinCode_dcp;
	}


	public String getEmailId_dcp() {
		return emailId_dcp;
	}


	public void setEmailId_dcp(String emailId_dcp) {
		this.emailId_dcp = emailId_dcp;
	}


	public String getPreviousExperience() {
		return PreviousExperience;
	}


	public void setPreviousExperience(String previousExperience) {
		PreviousExperience = previousExperience;
	}


	public String getSpecialSkills_dcp() {
		return specialSkills_dcp;
	}


	public void setSpecialSkills_dcp(String specialSkills_dcp) {
		this.specialSkills_dcp = specialSkills_dcp;
	}


	public String getBirthDate_dcp() {
		return birthDate_dcp;
	}


	public void setBirthDate_dcp(String birthDate_dcp) {
		this.birthDate_dcp = birthDate_dcp;
	}


	public String getGender_dcp() {
		return gender_dcp;
	}


	public void setGender_dcp(String gender_dcp) {
		this.gender_dcp = gender_dcp;
	}


	public String getChildtype_dcp() {
		return childtype_dcp;
	}


	public void setChildtype_dcp(String childtype_dcp) {
		this.childtype_dcp = childtype_dcp;
	}




	}
