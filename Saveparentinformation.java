package com.childdaycarecenter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.childdaycarecenter.configuration.Connectionmanager;
import com.childdaycarecenter.registrationinformation.Parent;

public class Saveparentinformation {

	public void saveParentdata(Parent parent)
	{
		Connection con2 = null;
		con2 = Connectionmanager.getConnection();
		try {
			String InsertSQL2 = "INSERT INTO PARENT VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps2 = con2.prepareStatement(InsertSQL2);
			ps2.setString(1, parent.getBirthDate_pi());
			ps2.setString(2, parent.getGender_pi());
			ps2.setString(3, parent.getAddress_pi());
			ps2.setString(4, parent.getEmailId_pi());
			ps2.setString(5, parent.getContactNumber_pi());
			ps2.setString(6, parent.getGuardianName_pi());
			ps2.setString(7, parent.getGuardianContact_pi());
			ps2.setString(8, parent.getFirstName_pi());
			ps2.setString(9, parent.getLastName_pi());
			ps2.setString(10, parent.getFirstname_ci());
			ps2.executeUpdate();
			
			System.out.println("Registered successfully");
			ps2.close();
		} catch (SQLException e) {
			System.out.println("Exception Occure due to" + e.getMessage());
		}
	
	}
}
