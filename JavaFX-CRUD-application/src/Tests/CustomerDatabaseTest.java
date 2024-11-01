package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import application.CustomerDatabase;

public class CustomerDatabaseTest {
	
	@Test
	void saveCustomerIdTest() {
		CustomerDatabase db = new CustomerDatabase();
		assertEquals(1, db.saveCustomer(new HashMap<String,String>()), "Id is incremented");
	}
	
	@Test
	void saveCustomerIdIncrementTwiceTest() {
		CustomerDatabase db = new CustomerDatabase();
		db.saveCustomer(new HashMap<String, String>());
		
		assertEquals(2, db.saveCustomer(new HashMap<String,String>()), "Id is incremented");
	}
	
	@Test
	void saveCustomerIdInsertionTest() {
		CustomerDatabase db = new CustomerDatabase();
		HashMap<String, String> customerRecord = new HashMap<>();
		db.saveCustomer(customerRecord);
		
		assertEquals("1",db.getData().get(1).get("id_"), "Id is inserted");
	}
	
	@Test
	void saveCustomerRecordCorrectTest() {
		CustomerDatabase db = new CustomerDatabase();
		HashMap<String, String> customerRecord = new HashMap();
		customerRecord.put("name", "Fred");
		
		db.saveCustomer(customerRecord);
		assertEquals("Fred", db.getData().get(1).get("name"), "Name is correct");
	}
}
