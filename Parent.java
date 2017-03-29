package com.childdaycarecenter.registrationinformation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Parent {
	
	private String firstName_pi;
	private String lastName_pi;
	private String birthDate_pi;
	private String gender_pi;
	private String address_pi;
	private String emailId_pi;
	private String contactNumber_pi;
	private String guardianName_pi;
	private String guardianContact_pi;
	private String firstname_ci;
	
	public void readparent()
	{
		Scanner parentscanner = new Scanner(System.in);
		
		System.out.println("Enter your Firstname");
		firstName_pi = parentscanner.nextLine();
		
		System.out.println("Enter your Lastname");
		lastName_pi = parentscanner.nextLine();
		
		System.out.println("Enter your BirthDate");
		birthDate_pi = parentscanner.next();
		parentscanner.nextLine();
		
		try
		{
			SimpleDateFormat DateFormat3 = new SimpleDateFormat("dd-mm-yyyy");
			DateFormat3.setLenient(false);
			Date date3 = null;
			date3 = DateFormat3.parse(birthDate_pi);
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Enter your gender (MALE OR FEMALE OR OTHERS)");
		gender_pi = parentscanner.nextLine();
		
		System.out.println("Enter your Address");
		address_pi = parentscanner.nextLine();
		
		System.out.println("Enter your Mailid");
		emailId_pi = parentscanner.nextLine();
		
		System.out.println("Enter your ContactNumber");
		contactNumber_pi = parentscanner.nextLine();
		
		System.out.println("Enter GuardianName");
		guardianName_pi = parentscanner.nextLine();
		
		System.out.println("Enter Guardian Contact");
		guardianContact_pi = parentscanner.nextLine();
		
		System.out.println("Enter your child's firstname");
		firstname_ci = parentscanner.nextLine();
	}

	public String getFirstname_ci() {
		return firstname_ci;
	}

	public void setFirstname_ci(String firstname_ci) {
		this.firstname_ci = firstname_ci;
	}

	public String getFirstName_pi() {
		return firstName_pi;
	}

	public void setFirstName_pi(String firstName_pi) {
		this.firstName_pi = firstName_pi;
	}

	public String getLastName_pi() {
		return lastName_pi;
	}

	public void setLastName_pi(String lastName_pi) {
		this.lastName_pi = lastName_pi;
	}

	public String getBirthDate_pi() {
		return birthDate_pi;
	}

	public void setBirthDate_pi(String birthDate_pi) {
		this.birthDate_pi = birthDate_pi;
	}

	public String getGender_pi() {
		return gender_pi;
	}

	public void setGender_pi(String gender_pi) {
		this.gender_pi = gender_pi;
	}

	public String getAddress_pi() {
		return address_pi;
	}

	public void setAddress_pi(String address_pi) {
		this.address_pi = address_pi;
	}

	public String getEmailId_pi() {
		return emailId_pi;
	}

	public void setEmailId_pi(String emailId_pi) {
		this.emailId_pi = emailId_pi;
	}

	public String getContactNumber_pi() {
		return contactNumber_pi;
	}

	public void setContactNumber_pi(String contactNumber_pi) {
		this.contactNumber_pi = contactNumber_pi;
	}

	public String getGuardianName_pi() {
		return guardianName_pi;
	}

	public void setGuardianName_pi(String guardianName_pi) {
		this.guardianName_pi = guardianName_pi;
	}

	public String getGuardianContact_pi() {
		return guardianContact_pi;
	}

	public void setGuardianContact_pi(String guardianContact_pi) {
		this.guardianContact_pi = guardianContact_pi;
	}

	

}
