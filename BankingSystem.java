/*Author: Nicholas Bennett

BankingSystem Psuedocode

*/

public class BankingSystem
{
	boolean validateCreditCard(String ccType, String ccNumber, String ccExpiration)
	{
		//Card type check
		boolean verified = true;
		if (!(ccType.equalsIgnoreCase("Visa") || ccType.equalsIgnoreCase("MasterCard") || ccType.equalsIgnoreCase("American Express") || ccType.equalsIgnoreCase("Discover")))
			throw new RuntimeException("Card Verification Error: 1");

		//Expiration date check
		try
		{
			int month = Integer.parseInt(ccExpiration.substring(0, ccExpiration.indexOf('/'))); //Not needed, but just to be thorough
			int year = Integer.parseInt(ccExpiration.substring(ccExpiration.indexOf('/')+1));
			if(year < 2016)
				throw new RuntimeException("Card Verification Error: 2");
		}
		catch (StringIndexOutOfBoundsException e){throw new RuntimeException("Card Verification Error: 2");}

		int sum = 0;
        boolean c = false;
        for (int i = ccNumber.length() - 1; i >= 0; i--)
        {
                int n = Integer.parseInt(ccNumber.substring(i, i + 1));
                if (c)
                {
                        n *= 2;
                        if (n > 9)
                        {
                                n = (n % 10) + 1;
                        }
                }
                sum += n;
                c = !c;
        }
        return (sum % 10 == 0);
		
		//Card number check
		
		/*int last = ccNumber.charAt(ccNumber.length()) - '0';
		ccNumber = ccNumber.substring(0,ccNumber.length());
		
		String reversed = "";	//Reverse the remaining numbers
		for(int r = 0; r < ccNumber.length(); r++)
			reversed = reversed + ccNumber.charAt(r);

		int[] digArray = new int[reversed.length()];	//Convert reversed number to an array of digits
		for(int i = 0; i < reversed.length(); i++)
			digArray[i] = reversed.charAt(i) - '0';

		for(int j = 0; j <= 14; j+=2)	//Multiply every other digit by 2
		{
			try
			{
				digArray[j] *= 2;
				if(digArray[j] > 9)
					digArray[j] -= 9;
			}
			catch (ArrayIndexOutOfBoundsException e){throw new RuntimeException("Card Verification Error: 2");}
		}
		
		int sum = last;	//Get sum of digits
		for(int k = 0; k < digArray.length; k++)
			sum += digArray[k];

		if(sum % 10 != 0)	//Check %10 (should be 0)
			throw new RuntimeException("Card Verification Error: 3");
		return verified;*/
		
	}		
}