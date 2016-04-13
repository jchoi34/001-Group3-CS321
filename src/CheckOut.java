
public class CheckOut {

	Customer c = new Customer();
	boolean validation;
	Reservation res;
	Customer name;
	public void checkOut(Customer c)
	{
		c.STATUS_CHECKED_OUT = true;   // update checked out status
		c.STATUS_CHECKED_IN = false;   // update checked in status
	}
	
	boolean validateUserInformation(){
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
