import java.io.IOException;
import java.util.ArrayList;
//Main Class

public class HotelSystem {
	Date systemClock = new Date();
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ManagerReport mgr = new ManagerReport();
	public static void main(String[] args){
		HotelSystem system = new HotelSystem();
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
	
	void executeInstruction(int instruction, String[] instructionData){
		switch (instruction){
		case 1:
			//Make a reservation
			TestReservation res = new TestReservation(instructionData, customers, systemClock.currentDate, mgr);
			break;
		case 2:
			//Check In
			CheckIn checkInObj = new CheckIn(instructionData);
//			if (instructionData.length > 2)
//				checkInObj.updateCCInfo();
			checkInObj.performCheckIn();
			break;
		case 3:
			//Check Out
			CheckOut checkOutObj = new CheckOut(instructionData);
			checkOutObj.performCheckOut();
			break;
		case 4:
			//Print Management Report
			mgr.printManagementReport(systemClock.currentDate);
			break;
		case 5:
			//Day Change
			systemClock.dayChange(customers);
			break;
		case 6: 
			//6PM Alarm
			systemClock.performSixPMCheck(customers);
			break;
		}
	}
	
}
