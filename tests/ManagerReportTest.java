/**
 * Unit Tests for ManagerReport class
 * @author Kuntharith Buon
 */
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ManagerReportTest {
	HRS hrs;
	ManagerReport mgr;
	int date;
	String fileLocationEclipse = System.getProperty("user.dir") + "/src/TestFiles/ManagerReport/";
	String fileLocation = System.getProperty("user.dir")+"/TestFiles/ManagerReport/";
	List<Room> rooms = new ArrayList<Room>();
	
	public static void main(String[] args){
		 org.junit.runner.JUnitCore.main("ManagerReportTest");
	}
	
	@org.junit.Before
	public void setUp(){
		hrs = new HRS();
		int totalRooms = Framework.NUM_SINGLE_ROOMS + Framework.NUM_DOUBLE_ROOMS;	//Using Framework class static final integers????????????
		hrs.hotelRooms = new ArrayList<Room>();

		for (int i = 0; i < totalRooms; i++)
		{
			hrs.hotelRooms.add(new Room());
			hrs.hotelRooms.get(i).setReserved(1, Framework.NUM_DAYS, false);
		}
	}
	
	@org.junit.After
	public void tearDown(){
		for (int i = 0; i < hrs.customers.size(); i++){
			Customer cus = Framework.getCustomerByID(hrs.customers.get(i).customerID);
			Framework.deleteReservation(Framework.getReservationByCID(cus.customerID).getReservationID());
			Framework.deleteCustomer(cus.customerID);
		}
		hrs.customers.clear();
	}
	
	String readFile(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileLocationEclipse+fileName));
		try{
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while (line != null){
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		}
		finally {
			br.close();
		}
	}
	
	void readInstructions(String fileName){
		try {
			Framework.init(fileLocationEclipse+fileName);
		}
		catch(IOException e){
			return;
		}
	}
	
	String execute(HRS hrs){
		StringBuilder tempSB = new StringBuilder();
		while (Framework.hasNextInstruction()){
			
			//Get the instruction data for the next instruction from the framework
			String[] instructionData = Framework.nextInstruction();
			
			//The first line of every instruction contains the instruction number
			int instruction = Integer.parseInt(instructionData[0]);
			
			//pass off the handling of the instruction to a different function
			tempSB.append(hrs.executeInstruction(instruction, instructionData));
		}
		return tempSB.toString();
	}
	
	
	/**
	 * checks date < 1;
	 */
	@org.junit.Test
	public void dateI(){
		date = 0;
		mgr = new ManagerReport();
		String expect = "Error: Invalid Date";
		String actual = mgr.printManagementReport(date, hrs.systemClock.currentDate, rooms);
		assertEquals(expect, actual);
	}
	
	/**
	 * checks date > 31
	 */
	@org.junit.Test
	public void dateII(){
		date = 32;
		mgr = new ManagerReport();
		String expect = "Error: Invalid Date";
		String actual = mgr.printManagementReport(date, hrs.systemClock.currentDate, rooms);
		assertEquals(expect, actual);
	}
	
	/**
	 * Empty Print w/ Date
	 */
	
	@org.junit.Test 
	public void emptyPrint(){
		mgr = new ManagerReport();
		hrs = new HRS();
		date = hrs.systemClock.currentDate;
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("\n==================January %d, 2015==================\n", date));
		sb.append("\n");
		sb.append(String.format("\nManagement report for 1/%d/2015", date));
		sb.append(String.format("\nNumber of Reservations: %d", 0));
		sb.append(String.format("\nSingle Rooms Reserved: %d", 0));
		sb.append(String.format("\nDouble Rooms Reserved: %d", 0));
		sb.append(String.format("\nOccupancy Rate: %d%%", 0));
		sb.append(String.format("\nTotal Revenue: $%.2f\n", 0.00));
		//READ INSTRUCTIONS
		String expect = sb.toString();
		String actual = mgr.printManagementReport(date, hrs.systemClock.currentDate, rooms);
		System.out.println(expect + "\n" + actual);
		assertEquals(expect, actual);
	}
	
	/**
	 * Empty Print w/o Date
	 */
	@org.junit.Test
	public void emptyPrintII(){
		String expect = "Error: Please Provide A Date For Print Management Option";
		readInstructions("/inputs/emptyPrintII.txt");
		String actual = execute(hrs);
		assertEquals(expect, actual);
	}
	
	/**
	 * Day Change, Print
	 */
	@org.junit.Test
	public void test(){
		hrs = new HRS();
		String expect = "";
		try {
			expect = readFile("/outputs/output_test.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		readInstructions("/inputs/test.txt");
		String actual = execute(hrs);
		assertEquals(expect, actual);
	}

	/**
	* Two Customers Check In, Only one checks out, print report
	* @1
	* ...
	* @2
	* ...
	* @5
	* @1
	* ...
	* @5
	* @2
	* ...
	* @3
	* ...
	* @5
	* @4
	*/ 
	/**
	 * If Reservation == null, customer checked out.. currently displaying as NO-SHOW FIX IT!
	 */
	@org.junit.Test
	public void testII(){
		String expect = "";
		try {
			expect = readFile("/outputs/output_testII.txt");
		} catch (IOException e){
			e.printStackTrace();
		}
		readInstructions("/inputs/testII.txt");
		String actual = execute(hrs);
		assertEquals(expect, actual);
	}
	
//	/**
//	 * Full input but
//	 * Doesnt provide a date for print management report
//	 */
//	@org.junit.Test
//	public void testIII(){
//		String expect = "Error: Please Provide A Date For Print Management Option";
//		readInstructions("/inputs/testIII.txt");
//		String actual = execute(hrs);
//		assertEquals(expect, actual);
//		
//	}
	
	
	/**
	 * Testing create new report objects
	 */
	@org.junit.Test 
	public void newObjectTest(){
		mgr = new ManagerReport();
		for (int i = 0; i < 100; i++){
			mgr.createNewReportObj(hrs.systemClock.currentDate, new Customer());
		}
		
		assert(100 == mgr.reportObj.size());
	}
	
	/**
	 * System Clock is Jan 10, but print only up to Jan 2;
	 */
	@org.junit.Test 
	public void moreDaysThanPrint(){
		for (int i = 1; i < 10; i++)
			hrs.systemClock.currentDate++;
		mgr = new ManagerReport();
		String expect = "";
		try {
			expect = readFile("/outputs/output_test.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String actual = mgr.printManagementReport(2, hrs.systemClock.currentDate, rooms);
		assertEquals(expect, actual);
	}

	/**
	 * Try to print more than current clock date
	 */
	@org.junit.Test 
	public void morePrintThanDays(){
		hrs.systemClock.currentDate++;
		mgr = new ManagerReport();
		String expect = "Error: Trying to Time Travel";
		String actual = mgr.printManagementReport(5, hrs.systemClock.currentDate, rooms);
		assertEquals(expect, actual);
		
	}
	
}
