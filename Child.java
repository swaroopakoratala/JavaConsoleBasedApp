package com.childdaycarecenter.registrationinformation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Child {
	
	
	private String firstName_ci;
	private String lastName_ci;
	private String birthDate_ci;
	private String gender_ci;
	private int age_ci;
	
 public void readchild()	{
	
	 Scanner childscanner = new Scanner(System.in);
	 

	System.out.println("Enter Firstname of child: ");
	
	firstName_ci = childscanner.nextLine();
	
	System.out.println("Enter Lastname of child");
	
	lastName_ci = childscanner.nextLine();
	
	System.out.println("Enter birthDate of child");
	
	birthDate_ci = childscanner.nextLine();
	
	try
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		dateFormat.setLenient(false);
		Date date2 = null;
		date2 = dateFormat.parse(birthDate_ci);
	}
	catch (ParseException e)
	{
		e.printStackTrace();
	}
	
	System.out.println("Enter Gender of child");
	
	gender_ci = childscanner.nextLine();
	
	
	System.out.println("Enter Age of child in months");
	
	age_ci = childscanner.nextInt();
	childscanner.nextLine();
	
		
	
	}

public String getFirstName_ci() {
	return firstName_ci;
}

public void setFirstName_ci(String firstName_ci) {
	this.firstName_ci = firstName_ci;
}

public String getLastName_ci() {
	return lastName_ci;
}

public void setLastName_ci(String lastName_ci) {
	this.lastName_ci = lastName_ci;
}

public String getBirthDate_ci() {
	return birthDate_ci;
}

public void setBirthDate_ci(String birthDate_ci) {
	this.birthDate_ci = birthDate_ci;
}

public String getGender_ci() {
	return gender_ci;
}

public void setGender_ci(String gender_ci) {
	this.gender_ci = gender_ci;
}

public int getAge_ci() {
	return age_ci;
}

public void setAge_ci(int age_ci) {
	this.age_ci = age_ci;
}

	

	
	
}
