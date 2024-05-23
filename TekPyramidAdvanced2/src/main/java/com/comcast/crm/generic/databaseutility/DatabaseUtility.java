package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.comcast.crm.IConstantPath.IConstantPath;
import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
     Connection connection;
     Statement statement;
	 public void getDBConnection() {
		 try {
			 Driver driver=new Driver();
			 DriverManager.registerDriver(driver);
			 connection=DriverManager.getConnection(IConstantPath.DB_Url,IConstantPath.DB_User,IConstantPath.DB_Pass);
		     statement =connection.createStatement();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		  
	 }
	 
	 public void closeDbConnection()
		{
			try {
				connection.close();
			}catch(Exception e)
			{
				
			}
		}
	 
	 public ResultSet exceuteSelectQuery(String Query) {
		 ResultSet result = null;
			 try {
				 result=statement.executeQuery(Query);
			     
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return result;
	 }
	 
	 public int executeNonSelectQuery(String Query)
		{
			int result=0;
			try {
			Statement stat=connection.createStatement();
			 result=stat.executeUpdate(Query);
			}
			catch(Exception e) {}
			return result;
		}

	
}
