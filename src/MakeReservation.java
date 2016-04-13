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
  * Make Reservation Array of Strings Format - Input
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


  /*****************************************************************************
  * Reservation Details
  * @author Mars
  * 
  * 0 - reservationID	:	Integer - Unique ID for reservation (assigned by Framework)
  * 1 - status			:	Integer - 1=Reserved, 2=Checked In, 3=Checked Out, 4=No Show, 5=Must Pay
  * 2 - startDate		:	Integer - The start date of the reservation (1-31)
  * 3 - endDate			:	Integer - The end date of the reservation (1-31)
  * 4 - roomType		:	Integer - The room type (1 for single, 2 for double)
  * 5 - numOccupants	:	Integer - The number of occupants in the room
  * 6 - guaranteed		:	Boolean - True if the reservation is guaranteed with a credit card, false if not guaranteed
  * 7 - roomNumber		:	Integer - The room number assigned to this reservation
  * 8 - customerID		:	Integer - The customer ID for the customer who made this reservation
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
// Variables
	int status, cusID, startDate, endDate, day, roomtype, occupants, roomNum;
	boolean guaranteed, available;
	Customer cus;
	Reservation res;
	
	public MakeReservation(String [] res_info) {
		status = 1;
		roomtype = Integer.parseInt(res_info[5]);
		occupants = Integer.parseInt(res_info[6]);
		startDate = Integer.parseInt(res_info[3]);
		endDate = Integer.parseInt(res_info[4]);
		day = startDate;
		available = true;
		
		
		
		// Check Customer Information
		if (Framework.getCustomerByName(res_info[1]) == Null)	// Check if customer exists
		{
			cus = new Customer();
			cus.setName(res_info[1]);
			cus.setAddress(res_info[2]);
			
			if (res_info[7] == "1")
			{
				cus.setCCType(res_info[8]);
				cus.setCCExpiration(res_info[9]);
				cus.setCCNumber(res_info[10]);
			}
		}
		
		cusID = cus.getCustomerID();
		
		// Set guaranteed to boolean type given res_info[7]
		if (res_info[7] == "0")
		{
			guaranteed = false;
		}
		else
		{
			guaranteed = true;
		}
		
		// NEED TO DEFINE ROOM NUMBER
		
		
		
		// Check Room Availability
		for (int i = (endDate - startDate)+1; i >0; i--)
		{
			// Check if room is available on this day
			if (Room_Available)
			{
				available = available && true;
			}
			else
			{
				available = available && false;
			}
		}
		
		if (available)
		{
			// Make Reservation
			
			// Get Reservation ID
			
			// Reduce NUM_*_ROOMS?... this is
		}
		
		
		
	}
}
	