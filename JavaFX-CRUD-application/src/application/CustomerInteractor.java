package application;

public class CustomerInteractor {
	
	private CustomerModel model;
	
	public CustomerInteractor(CustomerModel model) {
		this.model = model;
	}
	
	public void saveCustomer() {
        System.out.println("Saving account: " + model.getAccountNumber() +
           " Name: " + model.getCustomerName());
    }
}
