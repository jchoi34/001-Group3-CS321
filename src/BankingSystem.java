/*Author: Nicholas Bennett

BankingSystem Psuedocode

*/

public class BankingSystem
{
	boolean validateCreditCard(String type, int number, String date)
	{
		//Card type check
		boolean verified = true;
		if (!(type.equalsIgnoreCase("Visa") || type.equalsIgnoreCase("MasterCard") || type.equalsIgnoreCase("American Express") || type.equalsIgnoreCase("Discover")))
			throw new RuntimeException("Card Verification Error: 1");

		//Expiration date check
		try
		{
			int month = Integer.parseInt(date.substring(0, date.indexOf('/'))); //Not needed, but just to be thorough
			int year = Integer.parseInt(date.substring(date.indexOf('/')));
			if(year < 2016)
				throw new RuntimeException("Card Verification Error: 2");
		}
		catch (StringIndexOutOfBoundsException e){throw new RuntimeException("Card Verification Error: 2");}

		//Card number check
		int last = number % 10;
		int reversed = 0;

		number /= 10;		//Reverse the remaining numbers
		while(number != 0)
		{
			reversed *= 10;
			reversed += number % 10;
			number /= 10;
		}

		String revString = String.valueOf(reversed);	//Convert reversed int to an array of digits
		int[] digArray = new int[revString.length()];
		for(int i = 0; i < revString.length(); i++)
			digArray[i] = revString.charAt(i) - '0';

		for(int j = 0; j <= 14; j+=2)	//Multiply every other digit by 2
		{
			digArray[j] *= 2;
			if(digArray[j] > 9)
				digArray[j] -= 9;
		}
		
		int sum = last;	//Get sum of digits
		for(int k = 0; k < digArray.length; k++)
			sum += digArray[k];

		if(sum % 10 != 0)	//Check %10 (should be 0)
			throw new RuntimeException("Card Verification Error: 3");
		
		return verified;
	}		
}