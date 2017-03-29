package com.childdaycarecenter.assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.childdaycarecenter.configuration.Connectionmanager;

public class Childassignment {
			
		public void childAssignment()
		{	
			Connection con = null;
			{
				con = Connectionmanager.getConnection();	
		try {
			  Statement stmt = con.createStatement();
			  ResultSet rs = stmt.executeQuery("SELECT AGE_CI FROM CHILD");
				 int x =0;
			  while(rs.next())
				  {
					   x  = rs.getInt("AGE_CI");
					   if(x>5 && x<=18)
						  {
							  String sqlquery = "INSERT INTO CLASSROOM_I(CAREGIVERID,CHILDID)"
									  + "SELECT DISTINCT CAREGIVERID,CHILDID FROM CAREGIVER,CHILD WHERE CHILDTYPE = 'infants' AND AGE_CI <=18";
							  PreparedStatement ps = con.prepareStatement(sqlquery);
							  ps.executeUpdate();
						  }
						  else if(x>18 && x<36)
						  {
							  String sqlquery1 = "INSERT INTO CLASSROOM_T(CAREGIVERID,CHILDID)"
									  + "SELECT CAREGIVERID,CHILDID FROM CAREGIVER,CHILD WHERE CHILDTYPE = 'toodlers' AND AGE_CI >18";
							  PreparedStatement ps1 = con.prepareStatement(sqlquery1);
							  ps1.executeUpdate();
						  }		 
					
				  }
			    
			}	
		catch (SQLException e) {
						
			System.out.println("Exception Occure due to" + e.getMessage());
					}
			}
			
		}
		
	
}
	
