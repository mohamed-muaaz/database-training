package DataUtility;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.domo.training.database.utility.DataUtility;
import com.domo.training.database.utility.DatabaseConnection;

public class UtilityTest {
	DataUtility utility;
	
	@BeforeMethod
	public void createUtilityObject() {
		utility = new DataUtility();
	}
	
	@AfterTest
	public void disconnectDatabase() {
		DatabaseConnection.close();
	}
	
	@DataProvider(name="Queries")
	public Object[][] getQueries(){
		Object[][] queries = new Object[5][1];
		queries[0][0] = "select * from Car";
		queries[1][0] = "select * from CarOwner";
		queries[2][0] = "select id, brand, model from Car";
		queries[3][0] = "select Car.id, brand, model " +
			                "from Car join Carowner " +
			                "on Car.owner_id=CarOwner.id " +
			                "where license_number='0143526RY'";
		queries[4][0] = "select * from CarOwner where name='John'";
		return queries;
	}
	
	@Test(priority=1,
			description="This is the test case for testing the fetchData() method",
			dataProvider="Queries")
	public void testFetchData(String query) {
		utility.fetchData(query);
		System.out.println("Test Fetch Data");
	}
	
	@DataProvider(name="Tables")
	public Object[][] getTables(){
		String[] tables1 = {"Car"};
		String[] tables2 = {"CarOwner"};
		String[] tables3 = {"Car", "CarOwner"};
		Object[][] tables = new Object[3][1];
		tables[0][0] = tables1;
		tables[1][0] = tables2;
		tables[2][0] = tables3;
		return tables;
	}
	
	@Test(priority=2,
			description="This is the test case for testing the retrievColumnNames() method",
			dataProvider="Tables")
	public void testRetrieveColumnNames(String[] tables) {
		utility.retrieveColumnNames(tables);
		System.out.println("Test retrieve column names");
	}
	
	@Test(priority=3,
			description="This is the test case for testing the retrieveTableNames() method")
	public void testRetrieveTableNames() {
		utility.retrieveTableNames();
		System.out.println("Test retrieve table names");
	}
}
