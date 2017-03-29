package com.childdaycarecenter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.childdaycarecenter.configuration.Connectionmanager;
import com.childdaycarecenter.registrationinformation.Child;

public class Savechildinformation {

public void saveChilddata(Child child)

	{
	
	Connection con = null;
	con = Connectionmanager.getConnection();
	
	try {
		String InsertSQL1 = "INSERT INTO CHILD VALUES (?, ?, ?, ?, ?, CHILD_SEQ12.NEXTVAL)";
		PreparedStatement ps1 = con.prepareStatement(InsertSQL1, Statement.RETURN_GENERATED_KEYS);
		ps1.setString(1, child.getFirstName_ci());
		ps1.setString(2, child.getLastName_ci());
		ps1.setString(3, child.getBirthDate_ci());
		ps1.setString(4, child.getGender_ci());
		ps1.setInt(5, child.getAge_ci());
		ps1.executeUpdate();
		System.out.println("Registered successfully");
		ps1.close();
	} catch (SQLException e) {
		System.out.println("Exception Occure due to" + e.getMessage());
	}
	
	}
}

