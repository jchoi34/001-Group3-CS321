/***************************************************
 * Attributes/Variables and Descriptions
 * 
 * Boolean validationResp - Returns status of credential validation
 * Boolean checkInResp - Returns status of performCheckIn method
 * Customer cus - Instance of Customer class
 * Reservation res - Instance of Reservation class
 * String customerName - String variable containing customer's name
 * int reservationID - Int variable containign customer's reservation ID
 *
 *
 ***************************************************/
 /*************************************************** 
  * CheckIn pseudo code
  * @author kuntharith buon
  *	
  * Main Sequence:
  * Obtain name and reservationID from customer
  * Call performCheckIn Method
  * 
  * performCheckIn Sequence:
  * Call validateUserInformation method
  * If (validateUserInformation)
  * 	check the reservation status to see whether or not the customer has 
  * 	already checked-in/checked-out
  * 	If(customer has not checked-in/checked-out)
  * 		Set the reservation status to checked-in
  * 		Set  checkInResp variable to true
  * 
  * return checkInResp;
  * 
  * validateUserInformation Sequence:
  * Create an instance of Customer class and search for customer using 
  * 	customerName to and the Framework.getCustomerByName method
  * If method returns null
  * 	Display invalid credentials message to customer
  * Create an instance of Reservation and search for reservation associated with
  * 	customer by using the customer's id and calling Framework.getReservationByCID
  * 	method.
  * If method returns null
  * 	Display reservation not found message to user
  * else
  * 	Compare user provided reservation ID to the reservation id that was returned
  * 	if ID matches
  * 		set validationResp to true
  * 	
  * return validationResp;
  * 
  * updateCreditCard Sequence:
  * Obtain new credit card information, such as ccType, ccNumber, ccExpiration,
  * from guest and Set accordingly if information provided is valid
  *
 ***************************************************/



public class CheckIn {
	boolean validationResp, checkInResp;
	Customer cus;
	Reservation res;
	String customerName, ccType, ccExpiration, ccNumber;
	int reservationID;
	
	public CheckIn(String[] instructionData){
		for (int i = 1; i < instructionData.length; i++){
			switch(i){
			case 1:
				System.out.println("Name = " + instructionData[i]);		// Added for testing
				this.customerName = instructionData[i];
				break;
			case 2:
				System.out.println("Type = " + instructionData[i]);		// Added for testing
				this.ccType = instructionData[i];
				break;
			case 3:
				System.out.println("Expiration = " + instructionData[i]);		// Added for testing
				this.ccExpiration = instructionData[i];
				break;
			case 4:
				System.out.println("Number = " + instructionData[i]);		// Added for testing
				this.ccNumber = instructionData[i];
				break;
			}
		}
	}
	
	 boolean validateUserInformation(Customer cust, Reservation reserve){	// Added parameters for testing
		try {
			//Search for Customer and Reservation
			cust = Framework.getCustomerByName(cust.getName());
			reserve = Framework.getReservationByCID(cust.getCustomerID()); 
			validationResp = true;
		}
		catch(NullPointerException e){}
		return validationResp;
	}
	 
	 boolean validateUserInformation(){
		try {
			//Search for Customer and Reservation
			cus = Framework.getCustomerByName(customerName);
			res = Framework.getReservationByCID(cus.getCustomerID()); 
			validationResp = true;
		}
		catch(NullPointerException e){}
		return validationResp;
	}
	
	public void performCheckIn(){
		if (validateUserInformation()){ //Customer Found
			int currentResStatus = res.getStatus();
			//Not Checked-In or Has not Checked-Out
			if (currentResStatus != Framework.STATUS_CHECKED_IN && currentResStatus != Framework.STATUS_CHECKED_OUT){ 
				res.setStatus(Framework.STATUS_CHECKED_IN); //Sets the status to checked-in
				Framework.modifyReservation(res.getReservationID(), res);
				System.out.println("Success: Check-In Successful"); 
			}
			else{
				System.out.println("Failed: Customer has already checked-in/checked-out");
			}
		}
		else{
			System.out.println("Failed: " + customerName+ " Not Found");
		}
	}
	
	public void performCheckIn(boolean val, Reservation reserve, Customer cust){			// Added parameters for testing
		if (validateUserInformation()){ //Customer Found
			int currentResStatus = reserve.getStatus();
			//Not Checked-In or Has not Checked-Out
			if (currentResStatus != Framework.STATUS_CHECKED_IN && currentResStatus != Framework.STATUS_CHECKED_OUT){ 
				reserve.setStatus(Framework.STATUS_CHECKED_IN); //Sets the status to checked-in
				Framework.modifyReservation(reserve.getReservationID(), reserve);
				System.out.println("Success: Check-In Successful"); 
			}
			else{
				System.out.println("Failed: Customer has already checked-in/checked-out");
			}
		}
		else{
			System.out.println("Failed: " + cust.getName() + " Not Found");
		}
	}

	
	public void updateCCInfo(boolean testing){			// Added boolean testing
		//Call Bank to validate CC
		BankingSystem bank = new BankingSystem();
		if (testing){ //CC is valid						// removed bank method call for testing
			/*cus.setCCType(this.ccType);
			cus.setCCNumber(this.ccNumber);				// removed customer specific method calls for testing
			cus.setCCExpiration(this.ccExpiration);*/
			System.out.println("Success: Credit Card Information Has Been Updated");
		}
	}
	
}
