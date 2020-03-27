import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Nathan Roberts
 * @version October 7, 2017
 *
 */
public class LispADTTest {

    /**
     * Test adding 1 element to the list
     */
    @Test
    public void addingOneElementToTheList() {
        LispADT l = new LinkedLisp();
        l.add("a");
        Integer length = new Integer(1);
        assertEquals(length, l.size());
    }

    /**
     * Test adding 4 element to the list
     */
    @Test
    public void addingFourItemToTheListIncreaseTheSizeByFour() {
        LispADT l = new LinkedLisp();
        l.add("a").add("a").add("a").add("a");
        Integer length = new Integer(4);
        assertEquals(length, l.size());
    }

    /**
     * Calls current position on the third element in a list
     */
    @Test
    public void callingCurPosOnTheThirdElement() {
        LispADT l = new LinkedLisp();
        l.add("a").add("a").add("a").add("a");
        l.next().next();
        Integer length = new Integer(2);
        assertEquals(length, l.curPos());
    }

    /**
     * Calls current position on the first element in a list
     */
    @Test
    public void callingCurPosOnTheFirstElement() {
        LispADT l = new LinkedLisp();
        l.add("a").add("a").add("a").add("a");
        Integer length = new Integer(0);
        assertEquals(length, l.curPos());
    }

    /**
     * Calls get on the first element of the list should return 0
     */
    @Test
    public void callingGetOnTheFirstElement() {
        LispADT l = new LinkedLisp();
        l.add("a").add("b").add("c").add("d");
        assertEquals("d", l.get());
    }

    /**
     * calls get on the third element on a list should return 2
     */
    @Test
    public void callingGetOnAnElementInsideTheList() {
        LispADT l = new LinkedLisp();
        l.add("a").add("b").add("c").add("d");
        l.next().next();
        assertEquals("b", l.get());
    }

    /**
     * calls get on an empty list, should throw exception
     */
    @Test(expected = RuntimeException.class)
    public void callingGetOnAnEmptyList() {
        LispADT l = new LinkedLisp();
        assertNotNull(l);
        l.get();
    }

    /**
     * moves current to the second spot, should return the value of the third
     * element
     */
    @Test
    public void movingTheCurrentToTheSecondElement() {
        LispADT l = new LinkedLisp();
        l.add("a").add("b").add("c").add("d");
        l.moveTo(2);
        assertEquals("b", l.get());
    }

    /**
     * moves current to the second spot, should return the value of the third
     * element
     */
    @Test
    public void movingTheCurrentToAnPosOutOfBounds() {
        LispADT l = new LinkedLisp();
        l.add("a").add("b").add("c").add("d");
        l.moveTo(6);
        assertEquals("< | d , c , b , a >", l.toString());
    }

    /**
     * Moves the current one spot using the next call once
     */
    @Test
    public void movingCurrentOneSpotUsingNext() {
        LispADT l = new LinkedLisp();
        l.add("a").add("b").add("c").add("d");
        l.next();
        assertEquals("c", l.get());
    }

    /**
     * Moves the current one spot using the next call once
     */
    @Test
    public void callingNextOnLastElementShouldNotMove() {
        LispADT l = new LinkedLisp();
        l.add("a").add("b");
        l.next().next().next();
        assertEquals("< b , a | >", l.toString());
    }

    /**
     * calling prev once to move the current back one postition
     */
    @Test
    public void prevToMoveFromThirdToSecondElement() {
        LispADT l = new LinkedLisp();
        l.add("a").add("b").add("c").add("d");
        l.next().next().next();
        l.prev();
        assertEquals("b", l.get());
    }

    /**
     * calling remove on the first element on the list
     */
    @Test
    public void removeFromTheFirstElementOnAList() {
        LispADT l = new LinkedLisp();
        l.add("d").add("c").add("b").add("a");
        l.remove();
        assertEquals("< | b , c , d >", l.toString());
    }

    /**
     * calling remove on an empty list
     */
    @Test
    public void removeFromAnEmptyList() {
        LispADT l = new LinkedLisp();
        l.remove();
        assertEquals("< | >", l.toString());
    }

    /**
     * Calls equals on two strings that are the same should return true
     */
    @Test
    public void equalsOnTwoOfTheSameLists() {
        LispADT l = new LinkedLisp();
        LispADT k = new LinkedLisp();
        l.add("d").add("c").add("b").add("a");
        k.add("d").add("c").add("b").add("a");
        assertTrue(l.equals(k));
    }

    /**
     * calls equals on two different list and should return false
     */
    @Test
    public void equalsOnTwoOfDifferentLists() {
        LispADT l = new LinkedLisp();
        LispADT k = new LinkedLisp();
        l.add("d").add("c").add("b").add("a");
        k.add("d").add("d").add("b").add("a");
        assertFalse(l.equals(k));
    }

    /**
     * calls equals on two different list and should return false
     */
    @Test
    public void equalsOnANullValue() {
        LispADT l = new LinkedLisp();
        LispADT k = null;
        l.add("d").add("c").add("b").add("a");
        assertFalse(l.equals(k));
    }

    /**
     * Calls toString on an empty list
     */
    @Test
    public void toStringOnAnEmptyList() {
        LispADT l = new LinkedLisp();
        String expected = "< | >";
        assertEquals(expected, l.toString());
    }

    /**
     * calls toString on a simple list
     */
    @Test
    public void toStringOnAListWithOneElementAndCurrentAtFront() {
        LispADT l = new LinkedLisp();
        l.add("c");
        String expected = "< | c >";
        assertEquals(expected, l.toString());
    }

    /**
     * calls toString on a simple list
     */
    @Test
    public void toStringOnAListWithOneElementAndCurrentAtBack() {
        LispADT l = new LinkedLisp();
        l.add("c");
        l.next();
        String expected = "< c | >";
        assertEquals(expected, l.toString());
    }

    /**
     * Calls toString on a list that is 3 in size
     */
    @Test
    public void toStringOnAListWithCurrentInTheFront() {
        LispADT l = new LinkedLisp();
        l.add("c");
        l.add("b");
        l.add("a");
        String expected = "< | a , b , c >";
        assertEquals(expected, l.toString());
    }

    /**
     * Calls toString on a list that is 3 in size
     */
    @Test
    public void toStringOnAListWithCurrentAtTheSecondSpot() {
        LispADT l = new LinkedLisp();
        l.add("c");
        l.add("b");
        l.add("a");
        l.next();
        String expected = "< a | b , c >";
        assertEquals(expected, l.toString());
    }

    /**
     * Calls toString on a list that is 3 in size
     */
    @Test
    public void toStringOnAListWithCurrentInTheMiddle() {
        LispADT l = new LinkedLisp();
        l.add("c");
        l.add("b");
        l.add("a");
        l.next();
        l.next();
        String expected = "< a , b | c >";
        assertEquals(expected, l.toString());
    }

    /**
     * Calls toString on a list that is 3 in size
     */
    @Test
    public void toStringOnAListWithCurrentInTheEnd() {
        LispADT l = new LinkedLisp();
        l.add("c");
        l.add("b");
        l.add("a");
        l.next();
        l.next();
        l.next();
        String expected = "< a , b , c | >";
        assertEquals(expected, l.toString());
    }

}
