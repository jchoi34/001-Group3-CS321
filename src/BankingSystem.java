/*Author: Nicholas Bennett

BankingSystem Psuedocode

*/

public class BankingSystem
{
	boolean validateCreditCard(String ccType, String ccNumber, String ccExpiration)
	{
		//Card type check
		boolean verified = true;
		if (!(ccType.equalsIgnoreCase("Visa") || ccType.equalsIgnoreCase("MasterCard") || ccType.equalsIgnoreCase("American Express") || ccType.equalsIgnoreCase("Discover"))){
			throw new RuntimeException("Card Verification Error: 1");
		}

		//Expiration date check
		try
		{
			int month = Integer.parseInt(ccExpiration.substring(0, ccExpiration.indexOf('/'))); //Not needed, but just to be thorough
			int year = Integer.parseInt(ccExpiration.substring(ccExpiration.indexOf('/')+1));
			if(year < 2016){
				throw new RuntimeException("Card Verification Error: 2");
			}
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
		
	}		
}