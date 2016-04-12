
public class CheckOut {

	protected Customer c = new Customer();
	protected boolean validation;
	protected Reservation res;
	protected Customer name;
	public void checkOut(Customer c)
	{
		if(validateUserInformation(c)){
		c.STATUS_CHECKED_OUT = true;   // update checked out status
		c.STATUS_CHECKED_IN = false;   // update checked in status
		}
	}
	
	boolean validateUserInformation(Customer c){
		try {
			//Search for Customer and Reservation
			name = Framework.getCustomerByName(c.name); // find customer by name
			res = Framework.getReservationByCID(c.customerID);  // find customer by id
			validation = true;
		}
		catch(NullPointerException e){
			System.out.println("Customer/Reservation Not Found"); // throw null pointer if customer not found
		}
		return validation;
}
}
