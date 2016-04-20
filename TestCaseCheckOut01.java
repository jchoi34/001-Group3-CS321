import static org.junit.*;
import org.junit.Test;

/*
POSSIBLE CASES THAT WOULD CAUSE TROUBLE AT CHECKOUT:
- ZERO PEOPLE CHECKOUT
- PEOPLE CHECKOUT BUT ROOMS ARE NOT CLEARED
- CHECKOUT A REAL PERSON WITH A MISSPELLED NAME
- CHECKOUT AN IMAGINARY PERSON (IT WOULD BE A GOOD IDEA TO BE SURE THE GUEST IN QUESTION IS ACTUALLY STAYING AT THAT HOTEL)
** THE IDEA TO ENSURE THAT PRE AND POST CONDITIONS ARE TRUE AND THE CORRECT ROOM AVAILABILITY IS MAINTAINED
* If the method throws exceptions, check to see what triggers the exceptions correctly. Also test edge cases, what happens if it receives a 'null'.
* Does it correctly change the the state of the object that it operates on?
@author Angela Anniballi
*/

@Test
public void TestCheckOut()
{
// initialize test variables
CheckOut tester = new CheckOut();

// test assertions about guests and hotel rooms (maybe someone will input bad info)
assertEquals("Customer does not exist!", false, tester.validateUserInformation());
assertEquals("Customer does exist!", true, tester.validateUserInformation());

// perform checkout is a void function, therefore must test changes to values after the method is run
// need to verify if the check out action was performed
assertEquals("Customer checked out successfully!", STATUS_CHECKED_OUT, res.getStatus());
}

