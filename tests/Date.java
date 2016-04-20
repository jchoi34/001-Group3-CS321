/***************************************************
 * Date Class
 * @author Kuntharith Buon
 * 
 * Date.java is in charge of keeping track of the date, dayChange, and the
 * 1800h signal
***************************************************/
import java.util.ArrayList;

public class Date {
	int currentDate = 1;
	StringBuilder sb;
	
	public void dayChange(ArrayList<Customer> customers){
		performSixPMCheck(customers); //If new day, must run 1800h check
		this.currentDate = this.currentDate + 1;
	}
	
	public void performSixPMCheck(ArrayList<Customer> customers){
		for (int i = 0; i < customers.size(); i++){
			Reservation res = Framework.getReservationByCID(customers.get(i).getCustomerID()); //Gets customer reservation
			if (currentDate >= res.getStartDate() && res.getStatus() != Framework.STATUS_CHECKED_IN){ //Checks to see if customer checks in appropriately 
				res.setStatus(Framework.STATUS_NO_SHOW);
				Framework.modifyReservation(res.getReservationID(), res); //Updates the reservation
			}
		}
	}
	
	public String toString(){
		sb = new StringBuilder(String.format("January %d, 2016", this.currentDate));
		return sb.toString();
	}
}
