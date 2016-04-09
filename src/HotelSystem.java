import java.io.IOException;

//Main Class

public class HotelSystem {
	
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
