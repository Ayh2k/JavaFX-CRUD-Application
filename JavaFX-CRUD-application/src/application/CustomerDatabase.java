package application;

import java.util.HashMap;
import java.util.Map;

public class CustomerDatabase {
	
	private Map<Integer, Map<String, String>> data = new HashMap<>();
	private Integer nextKey = 0;
	
	public int saveCustomer(Map<String, String> customerRecords) {
		customerRecords.put("_id", (++nextKey).toString());
		data.put(nextKey, customerRecords);
		return nextKey;
	}
	
	public Map<Integer, Map<String, String>> getData() {
		return data;
	}
	
}
