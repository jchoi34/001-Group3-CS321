
public class CheckOut {

	boolean validation = false;
	Customer cus;
	Reservation res;
	String customerName;
	public CheckOut(String[] instructionData){
		this.customerName = instructionData[1]; //Sets customer name
	}
	
	public void performCheckOut(){
		if (validateUserInformation()){
			int status = res.getStatus();
			switch (status){
			case 2:
				res.setStatus(Framework.STATUS_CHECKED_OUT);
				Framework.modifyReservation(res.getReservationID(), res);
				System.out.println("Success: Check-Out Successful!");
				break;
			case 3:
				System.out.println("Error: " + customerName + " Has Already Checked-Out");
				break;
			default:
				System.out.println("Error: " + customerName + " Has Not Checked-In");
				break;
			}
		}else{
			System.out.println("Failed: Customer Not Found!");
		}
	}
	
	boolean validateUserInformation(){
		try {
			//Search for Customer and Reservation
			cus = Framework.getCustomerByName(this.customerName); // Find Customer By Name
			res = Framework.getReservationByCID(cus.customerID);  // find Reservation By CustomerID
			validation = true;
		}
		catch(NullPointerException e){}
		return validation;
}
}
