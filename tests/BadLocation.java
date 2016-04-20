import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * System/Acceptance Testing
 * Scenario:
 * Bad Location - No one ever checks in
 *
 * @author Kuntharith Buon
 */
public class BadLocation {
	HRS hrs;
	String fileLocationEclipse = System.getProperty("user.dir") + "/TestFiles/ManagerReport/";
	String fileLocation = System.getProperty("user.dir")+"/TestFiles/ManagerReport/";
	String readFile(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileLocation+fileName));
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
			Framework.init(fileLocation+fileName);
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
	
	
	public static void main(String[] args){
		org.junit.runner.JUnitCore.main("BadLocation");
	}
	
	@org.junit.Test 
	public void badLocation(){
		String expect = "";
		try {
			expect = readFile("/outputs/output_badlocation.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		readInstructions("/inputs/badlocation.txt");
		String actual = execute(hrs);
		Customer cus = Framework.getCustomerByName("Bernard L. Silver");
		assertEquals(expect, actual);
	}
	
}
