package com.childdaycarecenter.timetable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.childdaycarecenter.configuration.Connectionmanager;

public class Infants
{
	 boolean res=false;

 public void infant()

 {
  try 
     {
	  Connection con4 = null;
		{
			con4 = Connectionmanager.getConnection();
			PreparedStatement ps=con4.prepareStatement("select * from CHILDSCHEDULE_I");
			ResultSet rs=ps.executeQuery();
	 System.out.println("timings \t Activities");
	if(rs!=null)
	  {
		
		while(rs.next())
		{
		 res=true;
		
	     String time=rs.getString(1);
	     String act=rs.getString(2);
	     System.out.println(time+"\t\t "+act+" ");
		}
		if(res==false)
			System.out.println("No records found");
	  }
	
     } 
     }
  catch (SQLException e) 
  {
	
	  System.out.println("Exception Occure due to" + e.getMessage());
  }	
  
 }
}

