
public class CheckOut {

	protected boolean validation;
	protected Reservation res;
	protected Customer customer;
	protected String customerName;
	
	
	public CheckOut(String[] instructionData){
		if(instructionData[1] != null){
			this.customerName = instructionData[1];
			validateUserInformation(customerName);
		}
	}
	
	boolean validateUserInformation(String name){
		try {
			//Search for Customer and Reservation
			customer = Framework.getCustomerByName(name); // find customer by name
			res = Framework.getReservationByCID(customer.customerID);  // find customer by id
			validation = true;
		}
		catch(NullPointerException e){
			System.out.println("Customer/Reservation Not Found"); // throw null pointer if customer not found
		}
		return validation;
}
}
