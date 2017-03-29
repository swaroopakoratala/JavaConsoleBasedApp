package com.childdaycarecenter;

import java.util.Scanner;

import com.childdaycarecenter.assignment.Childassignment;
import com.childdaycarecenter.assignment.Viewchildrenlist;
import com.childdaycarecenter.dao.Savecaregiverinformation;
import com.childdaycarecenter.dao.Savechildinformation;
import com.childdaycarecenter.dao.Saveparentinformation;
import com.childdaycarecenter.newspublishing.Newspublishing;
import com.childdaycarecenter.performancereport.Performancereport;
import com.childdaycarecenter.registrationinformation.Child;
import com.childdaycarecenter.registrationinformation.Caregiver;
import com.childdaycarecenter.registrationinformation.Parent;
import com.childdaycarecenter.timetable.Infants;
import com.childdaycarecenter.timetable.Toodlers;

public class Daycarecenter {

	public static void main(String[] args) {
		
	String x;
	
	do
	{
		Scanner wc = new Scanner(System.in);
		System.out.println("Choose a choice between a to g");
		System.out.println(" a - Registration for CareGiver\n b - Registration for Child\n c - Registration for parent\n d - Timetable for Infants\n e - Timetable for Toodlers\n After registration \n f - View list of Children assigned to Caregiver \n g - View Child Performance report");
		x = wc.nextLine();
	switch(x)
	{
	case "a": 
		Caregiver caregiver = new Caregiver();
		caregiver.readcaregiver();
		Savecaregiverinformation savecaregiver = new Savecaregiverinformation();
		savecaregiver.saveCaregiver(caregiver);
	break;
	case "b":
		Child child = new Child();
		child.readchild();
		Savechildinformation savechild = new Savechildinformation();
		savechild.saveChilddata(child);
	break;	
	case "c":
		Parent parent = new Parent();
		parent.readparent();
		Saveparentinformation saveparent = new Saveparentinformation();
		saveparent.saveParentdata(parent);
	break;		
	case "d":  
			System.out.println("For Infants");
	 		Infants infants=new Infants();
	 		infants.infant();
	break;
	case "e":
		  System.out.println("For Toddlers");
    	  Toodlers toodlers=new Toodlers();
    	  toodlers.toddler();
	break;	
	case "f":
		
		Childassignment childassignment = new Childassignment();
		childassignment.childAssignment();
		Viewchildrenlist getlistofassignment = new Viewchildrenlist();	
	break;	
	case "g":
		
		Performancereport childperformance = new Performancereport();
		Newspublishing sendmail = new Newspublishing();
		sendmail.mail();	
	break;
	
	}
		
		
	 }	while(!"quit".equals(x));
	System.out.println("Good Bye");
  }

}

