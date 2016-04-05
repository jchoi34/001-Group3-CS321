
public class CheckIn {
	//Testing Frameworks
	public static void main(String[] args){
		Customer cus = new Customer();
		int customerID = Framework.storeCustomer(cus);
		System.out.println("CID " + customerID);
		Reservation res = new Reservation();
		int resID = Framework.storeReservation(res);
		System.out.println("RID " + resID);
		Customer cusII = Framework.getCustomerByName("Alan Turing");
	}
}
