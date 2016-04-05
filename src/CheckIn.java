
public class CheckIn {
	boolean validationResp, checkInResp;
	Customer cus;
	Reservation res;
	String customerName;
	int reservationID;
	//Testing Frameworks
//	public static void main(String[] args){
//		Customer cus = new Customer();
//		cus.setName("Alan Turing");
//		int customerID = Framework.storeCustomer(cus);
//		System.out.println("CID " + customerID);
//		Reservation res = new Reservation();
//		int resID = Framework.storeReservation(res);
//		System.out.println("RID " + resID);
//		Customer cusII = Framework.getCustomerByName("Alan Turing");
//		System.out.println(cusII);
//		Reservation resII = Framework.getReservationByCID(cusII.customerID);
//		System.out.println(resII);
//		
//		Customer cusIII = new Customer();
//		cusIII.setName("TEST");
//		int c2ID = Framework.storeCustomer(cusIII);
//		Reservation resIII = Framework.getReservationByCID(cusII.customerID);
//		System.out.println(resIII);
//	}
	
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
