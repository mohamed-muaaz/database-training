package com.domo.training.database;

import com.domo.training.database.utility.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataUtility utility = new DataUtility();
		
		//Fetching data
		String query = "select * from Car";
		
		utility.fetchData(query);
		
		//Uncomment following to Retrieve column names of tables
		String[] tables = {"CarOwner", "Car"};
		utility.retrieveColumnNames(tables);
		
		//Uncomment following to Retrieve all the table names
		utility.retrieveTableNames();
		
		//Close connection
		DatabaseConnection.close();
	}

}
