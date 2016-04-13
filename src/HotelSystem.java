package Hotel;
import java.io.IOException;
import java.util.*;

//Main Class

public class HotelSystem {

	public static void main(String[] args){
		HotelSystem system = new HotelSystem();
		
		// Create all rooms and put it into an array
		int totalRooms = Framework.NUM_SINGLE_ROOMS + Framework.NUM_DOUBLE_ROOMS;	//Using Framework class static final integers????????????
		List<Room> hotelRooms = new ArrayList<Room>();
		
		for (int i = 0; i < totalRooms; i++)
		{
			hotelRooms.add(new Room());
			hotelRooms.get(i).setReserved(false);
		}
				
		system.readInstructions("src/SampleInputs/sample1.txt", hotelRooms);
	}
	
	void readInstructions(String fileName, List<Room> hotelRooms){
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
			executeInstruction(instruction, instructionData, hotelRooms);
		}
	}
	
	void executeInstruction(int instruction, String[] instructionData, List<Room> hotelRooms){
		switch (instruction){
		case 1:
			//Make a reservation
			
			// Maybe??????
			try {
				Hotel.MakeReservation.class.newInstance().MakeReservation(instructionData, hotelRooms);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Maybe??????			
			
			break;
		case 2:
			//Check In
			break;
		case 3:
			//Check Out
			break;
		case 4:
			//Print Management Report
			break;
		case 5:
			//Day Change
			break;
		case 6: 
			//6PM Alarm
			break;
		}
	}

}
