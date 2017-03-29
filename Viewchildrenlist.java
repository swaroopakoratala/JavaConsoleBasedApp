package com.childdaycarecenter.assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.childdaycarecenter.configuration.Connectionmanager;
public class Viewchildrenlist {
	
	ArrayList<Integer> childlargelist_I = new ArrayList<Integer>();
	
	ArrayList<Integer> childlargelist_T = new ArrayList<Integer>();
	
	Connection con = null;
	{
		con = Connectionmanager.getConnection();	
		
	try 
	{
		Statement stmt = con.createStatement();
		  ResultSet rs = stmt.executeQuery("SELECT DISTINCT CAREGIVERID,CHILDID FROM CLASSROOM_I");
		  HashMap<Integer,List<Integer>> map_i = new HashMap<Integer,List<Integer>>();
		  List<Integer> careGiverList = new ArrayList<>();
		  while(rs.next())
		  {
			  childlargelist_I.add(rs.getInt(2)); 
			  Set<Integer> hs = new HashSet<>();
			  hs.addAll(childlargelist_I);
			  childlargelist_I.clear();
			  childlargelist_I.addAll(hs);
			  careGiverList.add(rs.getInt(1));
			
		  } 

		  List<List<Integer>> chunkList = getChunkList1(childlargelist_I, 5);
		  for(int i=0; i < chunkList.size() ; i++){
			  map_i.put(careGiverList.get(i), chunkList.get(i));
		  }
		  
		  map_i.entrySet().forEach(a ->{		  
			  insertintoInfants(a.getKey(), a.getValue());
			  System.out.println("This CareGiver " + a.getKey()+ " is assigned to infant children " +a.getValue());
		  });  
	}
	 
	catch (SQLException e) {
		System.out.println("Exception Occure due to" + e.getMessage());
	}
	
	try
	{
		Statement stmt1 = con.createStatement();
		ResultSet rs1 = stmt1.executeQuery("SELECT CAREGIVERID, CHILDID FROM CLASSROOM_T");
		 HashMap<Integer,List<Integer>> map_t = new HashMap<Integer,List<Integer>>();
		  List<Integer> careGiverList1 = new ArrayList<>();
		while(rs1.next())
		{
			childlargelist_T.add(rs1.getInt(2));
			Set<Integer> hs1 = new HashSet<>();
			  hs1.addAll(childlargelist_T);
			  childlargelist_T.clear();
			  childlargelist_T.addAll(hs1);
			  careGiverList1.add(rs1.getInt(1));
			  Set<Integer> hs2 = new HashSet<>();
			  hs2.addAll(careGiverList1);
			  careGiverList1.clear();
			  careGiverList1.addAll(hs2);
			  
		}
		
		List<List<Integer>> chunkList1 = getChunkList1(childlargelist_T, 5);
		for(int i=0; i < chunkList1.size() ; i++){
			  map_t.put(careGiverList1.get(i), chunkList1.get(i));
		  }
		  
		  map_t.entrySet().forEach(a ->{		  
			  insertintoToodlers(a.getKey(), a.getValue());
			  System.out.println("This CareGiver " + a.getKey()+ " is assigned to toodler children " +a.getValue());
		  });  
	}
	catch (SQLException e) {
		System.out.println("Exception Occure due to" + e.getMessage());
	}
}
	private List<List<Integer>> getChunkList1(ArrayList<Integer> largeList, int chunkSize) {
		List<List<Integer>> chunkList = new ArrayList<>();
        for (int i = 0 ; i <  largeList.size() ; i += chunkSize) {
            chunkList.add(largeList.subList(i , i + chunkSize >= largeList.size() ? largeList.size() : i + chunkSize));
        }
        return chunkList;
	}
	
	 private void insertintoToodlers(Integer key, List<Integer> sublist1) {
		
		 for(int i=0;i<sublist1.size();i++)
		 {
			 try
			 {
				 String sql1 = "INSERT INTO ASSIGN_TOODLERS(CAREGIVERID,CHILDID) VALUES(?,?)";
				 PreparedStatement toodlerinsert = con.prepareStatement(sql1);
				 toodlerinsert.setInt(1, key);
				 toodlerinsert.setInt(2, sublist1.get(i));
				 toodlerinsert.executeUpdate();
				 
			 }
			 catch (SQLException e) {
					
				 System.out.println("Exception Occure due to" + e.getMessage());
				}
		 }
		
	}

	  private void insertintoInfants(int key , List<Integer> sublist1){
		  for (int i=0; i< sublist1.size(); i++)
		  {
		try
				{
					String sql = "INSERT INTO ASSIGN_INFANTS(CAREGIVERID,CHILDID) VALUES(?,?)";
					PreparedStatement infantinsert = con.prepareStatement(sql);
					infantinsert.setInt(1, key);
					infantinsert.setInt(2, sublist1.get(i));
					infantinsert.executeUpdate();
				}
		catch (SQLException e) {
			
			System.out.println("Exception Occure due to" + e.getMessage());
		}
		  }
	  }
	}
