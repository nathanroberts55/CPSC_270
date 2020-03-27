import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Nathan Roberts
 * @version 1/24/2017
 *
 */
public class RecursiveParserTest extends RecursiveParser {

    /**
     * Test to see if the method produces the number expected from the factorial
     * method.
     */
    @Test
    public void factorialNumber5() {
        RecursiveParser rp = new RecursiveParser();
        int expected = 120;
        int actual = rp.factorial(5);
        assertEquals(expected, actual);
    }

    /**
     * Test to see if the method produces the expected output from the factorial
     * method.
     */
    @Test(expected = IllegalArgumentException.class)
    public void factorialIllegalArgument() {
        RecursiveParser rp = new RecursiveParser();

        int x = -1;

        assertNotNull(x);

        rp.factorial(x);
    }

    /**
     * Test to see if the method produces the expected output from the factorial
     * method.
     */
    @Test(expected = IllegalArgumentException.class)
    public void powerIllegalArgument() {
        RecursiveParser rp = new RecursiveParser();

        double x = 5;
        int y = -1;

        assertNotNull(x);
        assertNotNull(y);

        rp.power(x, y);
    }

    /**
     * Test to check if the method produces the number expected from the power
     * method. Finding 3 raised to the 3rd power
     */
    @Test
    public void powerOfThree() {
        RecursiveParser rp = new RecursiveParser();
        Double expected = (double) 27;
        Double actual = rp.power((double) 3, (Integer) 3);

        assertEquals(expected, actual);
    }

    /**
     * Test to check if the method produces the number expected from the power
     * method. Finding 4 raised to the 3rd power
     */
    @Test
    public void powerOfFour() {
        RecursiveParser rp = new RecursiveParser();
        Double expected = (double) 64;
        Double actual = rp.power((double) 4, (Integer) 3);

        assertEquals(expected, actual);
    }

    /**
     * Testing to see if method recognizes palindrome.
     */
    @Test
    public void isAPalindromeTest() {
        RecursiveParser rp = new RecursiveParser();
        String s = "racecar";

        assertTrue(rp.isPalindrome(s));
    }

    /**
     * Testing to see if method recognizes a one letter palindrome.
     */
    @Test
    public void oneLetterPalindrome() {
        RecursiveParser rp = new RecursiveParser();
        String s = "N";

        assertTrue(rp.isPalindrome(s));
    }

    /**
     * Testing to see if method recognizes null is a palindrome.
     */
    @Test
    public void emptyPalindrome() {
        RecursiveParser rp = new RecursiveParser();
        String s = "";

        assertTrue(rp.isPalindrome(s));
    }

    /**
     * Testing to see if the method recognizes this is NOT a palindrome.
     */
    @Test
    public void isNotAPalimdromeTest() {
        RecursiveParser rp = new RecursiveParser();
        String s = "nathan";

        assertFalse(rp.isPalindrome(s));
    }

    // /**
    // * Testing to see if the method recognizes this is NOT a palindrome.
    // */
    // @Test
    // public void complexParamListTest() {
    // RecursiveParser rp = new RecursiveParser();
    // String s = "Cp4";
    //
    // assertFalse(rp.isParamList(s));
    // }

    /**
     * Testing to see if the method recognizes this is a list of parameters.
     */
    @Test
    public void isParamListCheck() {
        RecursiveParser rp = new RecursiveParser();
        String s = "AcH";

        assertTrue(rp.isParamList(s));
    }

    /**
     * Testing to see if the method recognizes this is a list of parameters.
     */
    @Test
    public void isParamUsingNonLetterOrNumber() {
        RecursiveParser rp = new RecursiveParser();
        String s = "..$..";

        assertFalse(rp.isParamList(s));
    }

    /**
     * Testing to see if the method recognizes this is a NOT a list of
     * parameters.
     */
    @Test
    public void isNOTParamListCheck() {
        RecursiveParser rp = new RecursiveParser();
        String s = "524";

        assertFalse(rp.isParamList(s));
    }

    /**
     * Testing to see if the method recognizes this is a list of parameters.
     */
    @Test
    public void singleLetterParamCheck() {
        RecursiveParser rp = new RecursiveParser();
        String s = "K";

        assertTrue(rp.isParamList(s));
    }

    /**
     * Testing to see if the method recognizes this is a list of parameters.
     */
    @Test
    public void singleNumberParamCheck() {
        RecursiveParser rp = new RecursiveParser();
        String s = "5";

        assertFalse(rp.isParamList(s));
    }
}
