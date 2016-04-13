
public class CheckOut {

	protected boolean validation, checkOutResp;
	protected Reservation reservation;
	protected Customer customer;
	protected String customerName;
	
	
	public CheckOut(String[] instructionData){
		if(instructionData[1] != null){
			this.customerName = instructionData[1];
		}
	}
	
	public boolean performCheckIn(){
		if (validateUserInformation(customerName)){ //Customer Found
			//Not Checked-In or Has not Checked-Out
			if (reservation.getStatus() == 2){  // if user is checked in
				reservation.setStatus(3); // check out
				checkOutResp = true;
			}
		}
		return checkOutResp;
	}
	
	boolean validateUserInformation(String name){
		try {
			//Search for Customer and Reservation
			customer = Framework.getCustomerByName(name); // find customer by name
			reservation = Framework.getReservationByCID(customer.customerID);  // find customer by id
			validation = true;
		}
		catch(NullPointerException e){
			System.out.println("Customer/Reservation Not Found"); // throw null pointer if customer not found
		}
		return validation;
}
}
