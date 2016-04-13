import java.util.ArrayList;

public class Date {
	int currentDate = 1;
	StringBuilder sb;
	
	public void dayChange(ArrayList<Customer> customers){
		performSixPMCheck(customers);
		this.currentDate = this.currentDate + 1;
	}
	
	public void performSixPMCheck(ArrayList<Customer> customers){
		for (int i = 0; i < customers.size(); i++){
			Reservation res = Framework.getReservationByCID(customers.get(i).getCustomerID());
			if (currentDate >= res.getStartDate())
				res.setStatus(Framework.STATUS_NO_SHOW);
			Framework.modifyReservation(res.getReservationID(), res);
		}
	}
	
	public String toString(){
		sb = new StringBuilder(String.format("January %d, 2015", this.currentDate));
		return sb.toString();
	}
}
