import static org.junit.Assert.*;

import java.io.FileReader;
import java.util.ArrayList;

import org.junit.Test;

public class CheckOutTests {
	
	  public static void failFmt(String fmt, Object... args){
		    fail(String.format(fmt,args));
		  }

			
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void checkOutTest1(){
	  // Check construct Node
		  
		  	Date systemClock = new Date();
			ArrayList<Customer> customers = new ArrayList<Customer>();
			ManagerReport mgr = new ManagerReport();
			String fileName;
			HotelSystem system = new HotelSystem();
			FileReader file = new FileReader(fileName);
			system.fileName = fileName;
			system.readInstructions(fileName);
			
	     if(! actualString.equals(expectedString)){
	         failFmt("Node toString:\n"+
	            "Expect: "+expectedString + "\n"+
	            "Actual: "+actualString+"\n"+"");
	       }
	  }
}
