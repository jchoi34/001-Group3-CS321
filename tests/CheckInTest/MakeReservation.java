import java.util.ArrayList;
import java.util.List;

public class MakeReservation {
	String customerName, address, ccType, ccExpiration, ccNumber;
	int checkInDate, checkOutDate, roomType, numOfOccupants, status, cusID, roomNum, guaranteed;

	public MakeReservation(String[] instructionData, ArrayList<Customer> customers, int date, ManagerReport mgr, List<Room> hotelRooms){
		int day = checkInDate;
		boolean available = true;
		boolean found = false;

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
		
		// Customer Information
		Customer cus = new Customer();
		cus.setName(customerName);
		cus.setAddress(address);
		cus.setCCType(ccType);
		cus.setCCNumber(ccNumber);
		cus.setCCExpiration(ccExpiration);
		cus.setCustomerID(Framework.storeCustomer(cus));

		
		
		// Check Room Availability
		for (int r=0; (r < hotelRooms.size()) && !found; r++)
		{
			if (hotelRooms.get(r).getType() == roomType)
			{
				for (int i = checkInDate; i <= checkOutDate; i++)
				{
					// Check if room is available on this day
					//	if room is not available on any day(s) return false
					if (hotelRooms.get(r).getReserved(i))
					{
						available = available && true;
					}
					else
					{
						available = available && false;
					}
				}
				
				// After checking all requested day(s) and room is still available
				if (available) 
				{
					found = true;
					roomNum = hotelRooms.get(r).getRoomNum();
					
					// Book room for specific days before someone else gets it ;)
					hotelRooms.get(r).setReserved(checkInDate, checkOutDate, true);
				}
			}
		}

		Reservation res = new Reservation();
		res.setStatus(1);
		res.setStartDate(checkInDate);
		res.setEndDate(checkOutDate);
		res.setCustomerID(cus.getCustomerID());
		res.setGuaranteed(guaranteed);
		res.setRoomType(roomType);
		res.setNumOccupants(numOfOccupants);
		res.setRoomNumber(roomNum);

		// Get Reservation ID
		res.setReservationID(Framework.storeReservation(res));
		
		mgr.createNewReportObj(date, cus);
		customers.add(cus);
	}	
}