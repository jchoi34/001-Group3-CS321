


public class Room {
	// set counter to 99 so that first room number is 100
	static int number = 99;
	
	// room characteristics
	int roomNum, type, reservationID;
	boolean[] reserved = new boolean[Framework.NUM_DAYS + 1];	// +1 to avoid using element 0
			// January = 31 days; reserved will have 32 days listed from 1 to 31 (0 is ignored)
	
	public Room() {
		// Increment counter
		number = number + 1;
		
		// set room number
		roomNum = number;
	}
	
	public void setType(int type){
		this.type = type;
	}

	public void setReserved(int startDate, int endDate, boolean value){
		for (int i = startDate; i <= endDate; i++) {
			this.reserved[i] = value;
		}
	}

	public void setReservationID(int reservationID){
		this.reservationID = reservationID;
	}

	public int getRoomNum(){
		return this.roomNum;
	}

	public int getType(){
		return this.type;
	}
	
	public boolean getReserved(int date){
		return this.reserved[date];
	}

	public int getReservationID(){
		return this.reservationID;
	}
	
}
