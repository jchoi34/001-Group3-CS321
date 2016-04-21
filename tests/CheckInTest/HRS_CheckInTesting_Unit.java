import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class HRS_CheckInTesting_Unit {
	Date systemClock = new Date();
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ManagerReport mgr = new ManagerReport();

	
	public static void main(String[] args){
		String[] name = {"2", "Wendy"};
		String[] partial = {"2", "Anna", "visa"};
		String[] valid = {"2", "Anna", "visa", "2/2016", "5412 2765 2503 1552 28"};
		String[] invalid = {"2", "Bob", "Bob", "Visa", "Visa", "3/2017", "5412 2765 2503 1552 28"};

		HRS_CheckInTesting_Unit system = new HRS_CheckInTesting_Unit();

		System.out.println("\n*************************************************************");
		System.out.println("*                      Test: CheckIn()                      *");
		System.out.println("*************************************************************\n");
		System.out.println("===== Check-In() Test 1 =====");
		System.out.println("Test String[] = just name");
		CheckIn checkInObj1 = new CheckIn(name);

		System.out.println("===== Check-In() Test 2 =====");
		System.out.println("Test String[] = name, type");
		CheckIn checkInObj2 = new CheckIn(partial);

		System.out.println("===== Check-In() Test 3 =====");
		System.out.println("Test String[] = name, type, CCexp, CCnum");
		CheckIn checkInObj3 = new CheckIn(valid);

		System.out.println("===== Check-In() Test 4 =====");
		System.out.println("Test String[] = name, name, type, type, CCexp, CCnum");
		CheckIn checkInObj4 = new CheckIn(invalid);
		
		
		System.out.println("\n*************************************************************");
		System.out.println("*                    Test: updateCCInfo()                   *");
		System.out.println("*************************************************************\n");
		System.out.println("===== updateCCInfo() Test 1 =====");
		System.out.print("False test: ");
		checkInObj2.updateCCInfo(false);
		
		System.out.println("\n===== updateCCInfo() Test 2 =====");
		System.out.print("True test: ");
		checkInObj2.updateCCInfo(true);
		System.out.println("\n");
		
		
		System.out.println("\n*************************************************************");
		System.out.println("*               Test: validateUserInformation()               *");
		System.out.println("*************************************************************\n");
		
		// Create test_user cus and test_res res
        // Customer Information
        Customer cus1 = new Customer();
        cus1.setName("Kathy");
        cus1.setCCType("Visa");
        cus1.setCCNumber("1234 2765 2503 1552 28");
        cus1.setCCExpiration("11/2016");
        cus1.setCustomerID(Framework.storeCustomer(cus1));	// Customer added to Framework        
        // Reservation Information
        Reservation res1 = new Reservation();
        res1.setStatus(1);
        res1.setCustomerID(cus1.getCustomerID());
		res1.setReservationID(Framework.storeReservation(res1));	// Reservation added to Framework
		
        // Customer Information
        Customer cus0 = new Customer();
        cus0.setName("Bob");
        cus0.setCCType("MasterCard");
        cus0.setCCNumber("5412 2765 2503 1552 28");
        cus0.setCCExpiration("10/2016");
        cus0.setCustomerID(99);
        // Reservation Information
        Reservation res0 = new Reservation();
        res0.setStatus(1);
        res0.setCustomerID(cus0.getCustomerID());

		System.out.println("res1 customer ID = " + res1.getCustomerID() + "\nres0 customer ID = " + res0.getCustomerID());

		System.out.println("===== validateUserInformation() Test 1 =====");
		System.out.println("User doesn’t exist and Reservation doesn’t exist");
		System.out.println("validationResp = " + checkInObj1.validateUserInformation(cus0, res0));
		
		System.out.println("===== validateUserInformation() Test 2 =====");
		System.out.println("User doesn’t exist and Reservation exists");
		System.out.println("validationResp = " + checkInObj1.validateUserInformation(cus0, res1));

		System.out.println("===== validateUserInformation() Test 3 =====");
		System.out.println("User exists and Reservation doesn’t exist");
		System.out.println("validationResp = " + checkInObj1.validateUserInformation(cus1, res0));

		System.out.println("===== validateUserInformation() Test 4	 =====");
		System.out.println("User exists and Reservation exists");
		System.out.println("validationResp = " + checkInObj1.validateUserInformation(cus1, res1));		
		
		
		
		System.out.println("\n*************************************************************");
		System.out.println("*                    Test: performCheckIn()                   *");
		System.out.println("*************************************************************\n");
		System.out.println("===== performCheckIn() Test 1 =====");
		System.out.println("performCheckIn() = false");
		checkInObj1.performCheckIn(false, res1, cus1);
		
		System.out.println("===== performCheckIn() Test 2 =====");
		System.out.println("performCheckIn() = true and checked-in");
		res1.setStatus(Framework.STATUS_CHECKED_IN);
		checkInObj1.performCheckIn(true, res1, cus1);

		
		System.out.println("===== performCheckIn() Test 3 =====");
		System.out.println("performCheckIn() = true and checked-out");
		res1.setStatus(Framework.STATUS_CHECKED_OUT);
		checkInObj1.performCheckIn(true, res1, cus1);
		
		System.out.println("===== performCheckIn() Test 4 =====");
		System.out.println("performCheckIn() = true and not checked-in/out");
		res1.setStatus(1);
		checkInObj1.performCheckIn(true, res1, cus1);

	}
/************************************************************************	
			//Check In
			CheckIn checkInObj = new CheckIn(instructionData);
			if (instructionData.length > 2)
				checkInObj.updateCCInfo();
			checkInObj.performCheckIn();
************************************************************************/
	void printCheckIn(CheckIn obj)
	{
		try{
			System.out.println("\tName = " + obj.cus.getName());
		} catch(NullPointerException e) {
			System.out.println("\tName = null");
		}
		
		try {
			System.out.println("\tCC Type = " + obj.cus.getCCType());
		} catch(NullPointerException e) {
			System.out.println("\tCC Type = null");
		}
		
		try {
			System.out.println("\tCC Expiration = " + obj.cus.getCCExpiration());
		} catch(NullPointerException e) {
			System.out.println("\tCC Expiration = null");
		}

		try {
			System.out.println("\tCC Number = " + obj.cus.getCCNumber());
		} catch(NullPointerException e) {
			System.out.println("\tCC Number = null");
		}
	}
}
