/******************************************************************************
 * Attribute and Description
  
NUM_SINGLE_ROOMS - The number of single rooms available in the hotel
NUM_DOUBLE_ROOMS - The number of double rooms available in the hotel
NUM_DAYS - The number of days that the hotel reservation system must support (January=31)
SINGLE_RATE - The nightly rate for a single room (in dollars)
DOUBLE_RATE - The nightly rate for a double room (in dollars)
STATUS_RESERVED - The status code for a reserved reservation
STATUS_CHECKED_IN - The status code for a checked in reservation
STATUS_CHECKED_OUT - The status code for a checked out reservation
STATUS_NO_SHOW - The status code for a no show reservation
STATUS_MUST_PAY - The status code for a must pay reservation
*******************************************************************************/
 
 /*****************************************************************************
  * Make Reservation Array of Strings Format
  * @author Mars
  *
  * 0 - 1 = 1
  * 1 - Name = Gregory C. Stanton
  * 2 - Address = 4653 Turkey Pen Road, New York, NY 10013
  * 3 - Checkin Date (1-31) = 10
  * 4 - Checkout Date (1-31) = 10
  * 5 - Room Type (1 or 2) = 1
  * 6 - Number of Occupants (1-4) = 2
  * 7 - Guaranteed? (0=No, 1=Yes) = 1
  * 8 - Credit Card Info (if 1 above) = MasterCard
  * 9 - Credit Card Expiration Date (if 1 above) = 10/2016
  * 10 - Credit Card Number (if 1 above) = 1234 1234 1234 1234 12
  *******************************************************************************/
 
 /******************************************************************************
  * Make Reservation pseudo code
  * @author Mars
  * 
  * Need
  * 	verify_rooms
  *	int customerID
  *	
  *	
  * call method (string [] res_info)
  *	
  *	
  * create new customer object
  * 	Customer cus = new Customer( details from res_info…);
  *	
  *	//Try catch begin
  *	if customer is not in DB
  * 		//store customer in framework DB
  * 		customerID = Framework.storeCustomer(cus);
  *	else
  *		customerID = getCusID();
  *	set cut customerID
  *	//Try catch end
  *	
  *	//for loop through days to check if room type is available
  *	// Use a flag or counter to conclude if successful etc?
  *	if room type during specified days = available
  *		if guaranteed = 1
  *			//create new reservation object
  *			Reservation res = new Reservation( full cus_info);
  *		else
  *			//create new reservation object
  *			Reservation res = new Reservation( cus_info , null, null, null);
  *	
  *	
  * 		//store reservation in framework DB
  * 		int resID = Framework.storeReservation(res);
  *	else
  *		Display error: Room type not available
  */


public class MakeReservation {
    public static void main(String[] args) {
        System.out.println("Hello, World");
        
        
    }

}