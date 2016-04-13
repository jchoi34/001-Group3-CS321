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
	
	public String printManagementReport(int date){
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
		System.out.println(System.getProperty("user.dir"));
		return sb.toString();
	}
	
	public void createNewReportObj(int date, Customer cus){
		rptObj.addReportObject(date, cus);
	}
	
}

