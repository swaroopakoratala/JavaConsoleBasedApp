
package com.childdaycarecenter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.childdaycarecenter.configuration.Connectionmanager;
import com.childdaycarecenter.registrationinformation.Caregiver;

public class Savecaregiverinformation {

	public void saveCaregiver(Caregiver caregiver)
	{
	Connection con = null;
	con = Connectionmanager.getConnection();
	try
	{
	String insertSQL = "INSERT INTO CAREGIVER VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CAREGIVER_SEQ15.NEXTVAL,?)";
	PreparedStatement ps = (con.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS));
	ps.setString(1, caregiver.getFirstName_dcp());
	ps.setString(2, caregiver.getLastName_dcp());
	ps.setString(3, caregiver.getAddress_dcp());
	ps.setString(4, caregiver.getCity_dcp());
	ps.setString(5, caregiver.getContact_dcp());
	ps.setInt(6, caregiver.getPinCode_dcp());
	ps.setString(7, caregiver.getEmailId_dcp());
	ps.setString(8, caregiver.getSpecialSkills_dcp());
	ps.setString(9, caregiver.getBirthDate_dcp());
	ps.setString(10, caregiver.getGender_dcp());
	ps.setString(11, caregiver.getChildtype_dcp());
	ps.executeUpdate();
	System.out.println("You are registered successfully");
	ps.close();
} 
catch (SQLException e) {
	
	System.out.println("Exception Occure due to" + e.getMessage());
}
	
}
}
