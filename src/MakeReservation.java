import java.util.*;
 
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
  * Reservation Details - Output
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
  * Make Reservation - Pseudocode
  * @author Mars
  * 
  * Needs
  * 	verify customer
  * 	verify room availability given dates and room type
  * 	make reservation
  *	
  * Parameters: res_info array, hotelRooms array
  * 
  * Pseudo code:
  * 	verify if customer's name already exist in Framework
  * 		if it does not: create new customer with details in res_info
  * 						add new customer to Framework to get customer ID
  * 						save customer ID
  * 		if it does: get customer ID of the customer found
  * 	verify if reservation is guaranteed from res_info
  * 		if not guaranteed: set boolean to false
  * 		if guaranteed: set boolean to true
  * 						set customer credit card information (number, expiration date, type)
  * 	From the array of hotleRooms
  * 		verify if room is the right type
  * 			if it is wrong type: do nothing
  * 			if it is right type: from the list of days requested
  * 				verify if room is available
  * 					if it is: mark it available is true
  * 					if it is not: mark it available is false
  * 				verify available is still true
  * 					if true: set found flag to stop searching
  * 					if false: do nothing
  * 	verify room was found for specified days
  * 		if true: create new reservation with details gathered
  * 				 add new reservation to Framework to get reservation ID
  * 				 save reservation ID
  * 		if false: return error?
  *					  Display error: Room type not available for specific days
  */

public class MakeReservation {
// Variables
	String customerName, address, ccType, ccExpiration, ccNumber;
	int startDate, endDate, roomtype, occupants, status, cusID, roomNum, resID;
	boolean guaranteed;
	
	public MakeReservation(String [] res_info, ArrayList<Customer> customers, int date, ManagerReport mgr, List<Room> hotelRooms) {
		status = 1;
		roomtype = Integer.parseInt(res_info[5]);
		occupants = Integer.parseInt(res_info[6]);
		startDate = Integer.parseInt(res_info[3]);
		endDate = Integer.parseInt(res_info[4]);
		int day = startDate;
		boolean available = true;
		boolean found = false;
				
		// Customer Information
		Customer cus = new Customer();
		cus.setName(res_info[1]);
		cus.setAddress(res_info[2]);
		
		if (res_info[7] == "1")
		{
			cus.setCCType(res_info[8]);
			cus.setCCExpiration(res_info[9]);
			cus.setCCNumber(res_info[10]);
			guaranteed = true;
		}
		else
		{
			guaranteed = true;
		}
				
		cus.setCustomerID(Framework.storeCustomer(cus));

		
		System.out.println("Make Reservation request for " + cus.getName() + ":");
				
		
		// Check Room Availability
		for (int r=0; (r < hotelRooms.size()) && !found; r++)
		{
			if (hotelRooms.get(r).getType() == roomtype)
			{
				for (int i = startDate; i <= endDate; i++)
				{
					// Check if room is available on this day
					//	if room is not available on any day(s) return false
					if (hotelRooms.get(r).getReserved(i))
					{
						available = available && true;
					}
					else
					{
						available = available && false;
					}
				}
				
				// After checking all requested day(s)
				if (available) 
				{
					found = true;
					roomNum = hotelRooms.get(r).getRoomNum();
					
					// Book room
					hotelRooms.get(r).setReserved(startDate, endDate, true);
				}
			}
		}

		
			// Make Reservation
			Reservation res = new Reservation();
			res.setStatus(1);
			res.setStartDate(startDate);
			res.setEndDate(endDate);
			res.setRoomType(roomtype);
			res.setNumOccupants(occupants);
			res.setGuaranteed(guaranteed);
			res.setRoomNumber(roomNum);
			res.setCustomerID(cusID);
			
			// Get Reservation ID
			res.setReservationID(Framework.storeReservation(res));
			
		// Outputs
		if (res.getStatus() == 1)
		{
			System.out.println("Reservation: Success");
			if (guaranteed)
			{
				System.out.println("Guaranteed: True");
			}
			else
			{
				System.out.println("Guaranteed: False");
			}
			
			System.out.println("Check In: January " + startDate + ", 2015" ); 	// Output guideline says to use 2015 @_@
			System.out.println("Check Out: January " + endDate + ", 2015" ); 	// Output guideline says to use 2015 @_@

		}
		else
		{
			System.out.println("Reservation: Failed");
			System.out.println("Guaranteed:");
			System.out.println("Check In:" );
			System.out.println("Check Out:" );
		}
		


	}
}
	