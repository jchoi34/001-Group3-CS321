package Hotel;


public class Reservation {
	
	int reservationID, status, startDate, endDate, roomType, numOccupants, roomNum, customerID;
	boolean guaranteed;
	
	public void setReservationID(int reservationID){
		this.reservationID = reservationID;
	}
	
	public void setStatus(int status){
		this.status = status;
	}
	
	public void setStartDate(int startDate){
		this.startDate = startDate;
	}
	
	public void setEndDate(int endDate){
		this.endDate = endDate;
	}
	
	public void setRoomType(int roomType){
		this.roomType = roomType;
	}
	
	public void setNumOccupants(int numOccupants){
		this.numOccupants = numOccupants;
	}
	
/*	public void setGuaranteed(int guaranteed){
		this.guaranteed = guaranteed;
	}*/
	
	public void setGuaranteed(boolean guaranteed){
		this.guaranteed = guaranteed;
	}
	
	public void setRoomNumber(int roomNum){
		this.roomNum = roomNum;
	}
	
	public void setCustomerID(int customerID){
		this.customerID = customerID;
	}
	
	public int getReservationID(){
		return this.reservationID;
	}
	
	public int getStatus(){
		return this.status;
	}
	
	public int getStartDate(){
		return this.startDate;
	}
	
	public int getEndDate(){
		return this.endDate;
	}
	
	public int getRoomType(){
		return this.roomType;
	}
	
	public int getNumOccupants(){
		return this.numOccupants;
	}
	
/*	public int getGuaranteed(){
		return this.guaranteed;
	}*/
	
	public boolean getGuaranteed(){
		return this.guaranteed;
	}
	
	public int getRoomNumber(){
		return this.roomNum;
	}
	
	public int getCustomerID(){
		return this.customerID;
	}
	
	
}
