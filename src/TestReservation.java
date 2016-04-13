import java.util.ArrayList;

public class TestReservation {
	String customerName, address, ccType, ccExpiration, ccNumber;
	int checkInDate, checkOutDate, roomType, numOfOccupants,guaranteed;
	public TestReservation(String[] instructionData, ArrayList<Customer> customers, int date, ManagerReport mgr){
		for (int i = 1; i < instructionData.length; i++){
			switch (i){
			case 1:
				this.customerName = instructionData[i];
				break;
			case 2:
				this.address = instructionData[i];
				break;
			case 3:
				this.checkInDate = Integer.parseInt(instructionData[i]);
				break;
			case 4:
				this.checkOutDate = Integer.parseInt(instructionData[i]);
				break;
			case 5: 
				this.roomType = Integer.parseInt(instructionData[i]);
				break;
			case 6:
				this.numOfOccupants = Integer.parseInt(instructionData[i]);
				break;
			case 7:
				this.guaranteed = Integer.parseInt(instructionData[i]);
				break;
			case 8:
				this.ccType = instructionData[i];
				break;
			case 9:
				this.ccExpiration = instructionData[i];
				break;
			case 10:
				this.ccNumber = instructionData[i];
				break;
			}
		}
		Customer cus = new Customer();
		cus.setName(customerName);
		cus.setAddress(address);
		cus.setCCType(ccType);
		cus.setCCNumber(ccNumber);
		cus.setCCExpiration(ccExpiration);
		cus.setCustomerID(Framework.storeCustomer(cus));
		Reservation res = new Reservation();
		res.setStartDate(checkInDate);
		res.setEndDate(checkOutDate);
		res.setCustomerID(cus.getCustomerID());
		res.setGuaranteed(guaranteed);
		int resID = Framework.storeReservation(res);
		mgr.createNewReportObj(date, cus);
		customers.add(cus);
//		System.out.println(cus.customerID);
//		System.out.println(Framework.getReservationByCID(cus.customerID));
	}
	
}
