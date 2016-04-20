/***************************************************
 * HotelSystem Class
 * @author kuntharith buon
 * 
 * HotelSystem.java acts as main class;
 * Accepts the command-line arguments, reads and performs the instruction dataset
 * respectively according to the instruction number
 * 
***************************************************/
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class HRS {
	Date systemClock = new Date();
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ManagerReport mgr = new ManagerReport();
	String fileName;
	List<Room> hotelRooms;
	public static void main(String[] args){
		HRS system = new HRS();
		system.fileName = args[0];
		// Create all rooms and put it into an array
		int totalRooms = Framework.NUM_SINGLE_ROOMS + Framework.NUM_DOUBLE_ROOMS;	//Using Framework class static final integers????????????
		system.hotelRooms = new ArrayList<Room>();

		for (int i = 0; i < totalRooms; i++)
		{
			system.hotelRooms.add(new Room());
			system.hotelRooms.get(i).setReserved(1, Framework.NUM_DAYS, false);
		}
		system.readInstructions(args[0]);
	}
	
	void readInstructions(String fileName){
		//Initialize the framework to read instructions from the given file
		try {
			Framework.init(fileName);
		}
		catch(IOException e){
			return;
		}
		
		//Parse the instructions
		while (Framework.hasNextInstruction()){
			//Get the instruction data for the next instruction from the framework
			String[] instructionData = Framework.nextInstruction();
			
			//The first line of every instruction contains the instruction number
			int instruction = Integer.parseInt(instructionData[0]);
			
			//pass off the handling of the instruction to a different function
			executeInstruction(instruction, instructionData);
		}
	}
	
	String executeInstruction(int instruction, String[] instructionData){
		switch (instruction){
		case 1:
			//Make a reservation
			//TestReservation res = new TestReservation(instructionData, customers, systemClock.currentDate, mgr);
			MakeReservation res = new MakeReservation(instructionData, customers, systemClock.currentDate, mgr, hotelRooms);
			break;
		case 2:
			//Check In
			CheckIn checkInObj = new CheckIn(instructionData);
			if (instructionData.length > 2)
				checkInObj.updateCCInfo();
			checkInObj.performCheckIn();
			break;
		case 3:
			//Check Out
			CheckOut checkOutObj = new CheckOut(instructionData);
			checkOutObj.performCheckOut();
			break;
		case 4:
			//Print Management Report
			int reportDate;
			if (instructionData.length > 1)
				reportDate = Integer.parseInt(instructionData[1]);
			else{
				//System.out.println("Error: Please Provide A Date For Print Management Option");
				return "Error: Please Provide A Date For Print Management Option";
			}
			String report = mgr.printManagementReport(reportDate, systemClock.currentDate, hotelRooms);
			return report;
//			fileName = fileName.substring(fileName.indexOf('/')+1);
//			String loc = String.format(System.getProperty("user.dir")+"/HRS_%s", fileName);
//			try {
//				File file = new File(loc);
//				if (!file.exists())
//					file.createNewFile();
//				FileWriter fw = new FileWriter(file.getAbsolutePath());
//				BufferedWriter bw = new BufferedWriter(fw);
//				bw.write(report);
//				bw.close();
//			}catch(Exception e){
//				e.printStackTrace();
//			};
//			break;
		case 5:
			//Day Change
			systemClock.dayChange(customers);
			break;
		case 6: 
			//6PM Alarm
			systemClock.performSixPMCheck(customers);
			break;
		}
		return "";
	}
	
}
