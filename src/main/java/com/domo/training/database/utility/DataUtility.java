package com.domo.training.database.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.domo.training.database.Properties;

public class DataUtility {
	static Connection conn;
	CsvWriter csvWriter;
	
	public DataUtility(){
		 conn = DatabaseConnection.getConnection();
		 csvWriter = new CsvWriter();
	}
	
	public void fetchData(String query) {
		//which takes the query to be executed and stores the data in a csv file
		List<String[]> data = new ArrayList<String[]>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
		     
		    //processing column names
			String[] headers = new String[numberOfColumns];
			
		    for (int i = 1; i <= numberOfColumns; i++) {
		        String columnName = rsmd.getColumnName(i);
		        headers[i-1] = columnName;
		    }
		    data.add(headers);
		    
		    //processing data
		    while (rs.next()) {
		    	String[] dataEntry = new String[numberOfColumns];
		    	for (int i = 1; i <= numberOfColumns; i++) {
		            String columnValue = rs.getString(i);
		            dataEntry[i-1] = columnValue;
		        }
		    	data.add(dataEntry);
		    }
		    
		    //writing to csv
		    String path =  Properties.getFilePath();
		    csvWriter.writeToFile(path, data);
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void retrieveColumnNames(String[] tables) {
		//which takes the table names and list out the column names and store it into a csv file.
		String [] headers = {"table", "columns"};
		List<String[]> data = new ArrayList<String[]>();
		data.add(headers);
		
		
		try {
			for (String table:tables) {
				String[] dataEntry = new String[2];
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(String.format("PRAGMA table_info('%s')", table));
				
				//Get column names of the table
				StringBuffer columns = new StringBuffer();
			    while (rs.next()) {
			        String columnName = rs.getString("name");
			    	columns.append(columnName + " ");
			    }
			    
			    dataEntry[0] = table;
			    dataEntry[1] = columns.toString();
			    data.add(dataEntry);
			}
			
			//writing to csv
		    String path =  Properties.getFilePath();
		    csvWriter.writeToFile(path, data);
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void retrieveTableNames() {
		//list the table names and store it into a csv file.
		String query = "Select name from sqlite_master where type='table'";
		this.fetchData(query);
	}
}
