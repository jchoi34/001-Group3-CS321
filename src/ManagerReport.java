
/***************************************************
 * ManagerReport
 * @author kuntharith buon
 * 
 * ManagerReport class is responsible for producing the management report
***************************************************/
import java.util.ArrayList;
import java.util.List;

public class ManagerReport{
	ArrayList<ReportObject> reportObj = new ArrayList<ReportObject>();
	ReportObject rptObj = new ReportObject();
	class ReportObject{
		int date;
		Customer cus; 
		
		public ReportObject(){} //Default Constructor
		
		public ReportObject(int date, Customer cus){ //Creates ReportObject
			this.date = date;
			this.cus = cus;
		}
		
		public void addReportObject(int date, Customer cus){ //Adds ReportObject into Arraylist
			ReportObject tmp = new ReportObject(date, cus);
			reportObj.add(tmp);
		}
		
	}
	//Simple Formatting of the String to produce the expected output
	public String printManagementReport(int date, List<Room> rooms){ 
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 1; i <= date; i++){ 
			sb.append(String.format("\n==================January %d, 2015==================\n", i));
				for (int x = count; x < reportObj.size(); x++){
					if (reportObj.get(x).date != i){
						count = x+1;
						break;
					}
					Reservation res = Framework.getReservationByCID(reportObj.get(x).cus.getCustomerID());
					sb.append(String.format("\nMake Reservation request for %s", reportObj.get(x).cus.getName()));
					sb.append(String.format("\nGuaranteed: %s", (Framework.STATUS_RESERVED == res.getGuaranteed())));
					sb.append(String.format("\nCheck In: January %d, 2015", res.getStartDate()));
					sb.append(String.format("\nCheck Out: January %d, 2015\n", res.getEndDate()));
					if (res.getStatus() == Framework.STATUS_NO_SHOW)
						sb.append(String.format("\n%s did not show.", reportObj.get(x).cus.getName()));
				}
			sb.append("\n");
		}
		for (int i = 0; i < reportObj.size(); i++){
			Reservation res = Framework.getReservationByCID(reportObj.get(i).cus.getCustomerID());
			if (res.getStatus() == Framework.STATUS_CHECKED_OUT || res.getStatus() == Framework.STATUS_NO_SHOW){
				Framework.deleteReservation(res.getReservationID());
				reportObj.remove(i);
			}
			
		}
		int resCount = 0;
		int singleCount = 0;
		int doubleCount = 0;
		for (int i = 0; i < reportObj.size(); i++){
			Reservation res = Framework.getReservationByCID(reportObj.get(i).cus.getCustomerID());
			if (res.startDate > date)
				break;
			if (res.getStatus() == Framework.STATUS_RESERVED){
				resCount++;
				if (res.getRoomType() == 1)
					singleCount++;
				else
					doubleCount++;
			}
		}
		
		double totalRev = (Framework.SINGLE_RATE*singleCount) + (Framework.DOUBLE_RATE*doubleCount);
		
		sb.append(String.format("\nManagement report for 1/%d/2015", date));
		sb.append(String.format("\nNumber of Reservations: %d", resCount));
		sb.append(String.format("\nSingle Rooms Reserved: %d", singleCount));
		sb.append(String.format("\nDouble Rooms Reserved: %d", doubleCount));
		sb.append(String.format("\nOccupancy Rate: %d%%", (singleCount+doubleCount)/10 * 100));
		sb.append(String.format("\nTotal Revenue: $%.2f\n", totalRev));
		
		return sb.toString();
	}
	
	public void createNewReportObj(int date, Customer cus){ //Creates and add new report object into the ArrayList
		rptObj.addReportObject(date, cus);
	}
	
}
