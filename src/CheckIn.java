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
  * @author kuntharith
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
  */



public class CheckIn {
	boolean validationResp, checkInResp;
	Customer cus;
	Reservation res;
	String customerName;
	int reservationID;
	
	public CheckIn(String customerName, int reservationID){
		this.customerName = customerName;
		this.reservationID = reservationID;
	}
	
	 boolean validateUserInformation(){
		try {
			//Search for Customer and Reservation
			cus = Framework.getCustomerByName(customerName);
			res = Framework.getReservationByCID(cus.getCustomerID()); 
			validationResp = true;
		}
		catch(NullPointerException e){
			System.out.println("Customer/Reservation Not Found");
		}
		return validationResp;
	}
	
	public boolean performCheckIn(){
		if (validateUserInformation()){ //Customer Found
			int currentResStatus = res.getStatus();
			//Not Checked-In or Has not Checked-Out
			if (currentResStatus != 2 || currentResStatus != 3){ 
				res.setStatus(2);
				checkInResp = true;
			}
		}
		return checkInResp;
	}
	
}
