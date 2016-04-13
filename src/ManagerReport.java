import java.util.ArrayList;

public class ManagerReport{
	ArrayList<ReportObject> reportObj = new ArrayList<ReportObject>();
	ReportObject rptObj = new ReportObject();
	class ReportObject{
		int date;
		Customer cus; 
		
		public ReportObject(){}
		
		public ReportObject(int date, Customer cus){
			this.date = date;
			this.cus = cus;
		}
		
		public void addReportObject(int date, Customer cus){
			ReportObject tmp = new ReportObject(date, cus);
			reportObj.add(tmp);
		}
		
	}
	
	public void printManagementReport(int date){
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 1; i <= date; i++){
			sb.append(String.format("==================January %d, 2015==================", i));
				for (int x = count; x < reportObj.size(); x++){
					System.out.println(reportObj.get(x).cus.getName() + " " + reportObj.get(x).date);
					if (reportObj.get(x).date != i){
						count = x+1;
						break;
					}
					sb.append(String.format("\nMake Reservation request for %s", reportObj.get(x).cus.getName()));
					sb.append(String.format("\nGuaranteed: %s", (1 == Framework.getReservationByCID(reportObj.get(x).cus.getCustomerID()).getGuaranteed())));
					sb.append(String.format("\nCheck In: January %d, 2015", Framework.getReservationByCID(reportObj.get(x).cus.getCustomerID()).getStartDate()));
					sb.append(String.format("\nCheck In: January %d, 2015\n", Framework.getReservationByCID(reportObj.get(x).cus.getCustomerID()).getEndDate()));
					if (Framework.getReservationByCID(reportObj.get(x).cus.getCustomerID()).getStatus() == Framework.STATUS_NO_SHOW)
						sb.append(String.format("\n%s did not show.", reportObj.get(x).cus.getName()));
				}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public void createNewReportObj(int date, Customer cus){
		rptObj.addReportObject(date, cus);
	}
	
}


//// How are the reservation objects stored? Cuz I just wrote it as though they were stored in a linked list - there is a while loop that goes
//// through the linked list and counts up the number of rooms occupied or the number of guests in the hotel, based upon a choice input
//// by the user (manager).
//
//getReport(int date)
//   {
//   // date is passed to function as parameter; date will be the matching criteria for the record search
//   // initialize variables
//   int choice = 0;
//   int total_guests = 0;
//   int total_rooms = 0;
//   
//   System.out.print("*Enter '1' to view guest data*\n*Enter '2' to view room data*\n");
//   System.in.scan("%d" + choice);
//
//   switch(choice)
//   {
//   case 1: // SUM TOTAL NUMBER OF GUESTS IN HOTEL
//   // for every reservation object that has a start date less than or equal to date AND end date is greater than or equal to date
//   // signifies that the room is occupied
//   while(ResObjList != null)
//      {if (Reservation.getStartDate() <= date && Reservation.getEndDate() >= date)
//      total_guests += Reservation.getNumOccupants();
//      ResObjList = ResObjList.next;}
//   System.out.print("The total number of guests for Date %d:  %d\n" + date + total_guests);
//   break;
//
//   case 2: // SUM TOTAL OF RESERVED ROOMS IN HOTEL
//   // for every Reservation object that is status 'reserved' on that date
//   while(ResObjList != null)
//   {if (Reservation.getStartDate() <= date && Reservation.getStatus() == 1)
//      total_rooms++;
//   ResObjList = ResObjList.next;}
//   System.out.print("The total number of rooms booked for Date %d:  %d\n" + date + total_rooms);
//   break;
//
//   default:
//   }
//   }

