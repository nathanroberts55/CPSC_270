import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Nathan Roberts
 * @version Nov. 27th, 2017
 *
 */
public class BinSearchTreeADTTest {

    /**
     * Test method for {@link BinSearchTreeADT#add(java.lang.Character)}.
     */
    @Test
    public void addToAnEmptyTree() {
        BinSearchTreeImp n = new BinSearchTreeImp();
        n.add('a');
        n.add('b');
        n.add('c');
        assertEquals("abc", n.toString());
    }

    /**
     * Test method for {@link BinSearchTreeADT#add(java.lang.Character)}.
     */
    @Test
    public void addInReverseOrder() {
        BinSearchTreeImp n = new BinSearchTreeImp();
        n.add('c');
        n.add('b');
        n.add('a');
        assertEquals("cba", n.toString());
    }

    /**
     * Test method for {@link BinSearchTreeADT#add(java.lang.Character)}.
     */
    @Test
    public void addWontTheSameValueTwice() {
        BinSearchTreeImp n = new BinSearchTreeImp();
        n.add('c');
        n.add('b');
        n.add('a');
        n.add('b');
        assertEquals("cba", n.toString());
    }

    /**
     * Test method for {@link BinSearchTreeADT#add(java.lang.Character)}.
     */
    @Test
    public void addToAPopulatedTree() {
        BinSearchTreeImp n = new BinSearchTreeImp();
        n.mkFull();
        n.add('h');
        n.add('i');
        assertEquals("dbacfeghi", n.toString());
    }

    /**
     * Test method for {@link BinSearchTreeADT#countOf(java.lang.Character)}.
     */
    @Test
    public void countOfTheLeftSideOfMkFull() {
        BinSearchTreeImp n = new BinSearchTreeImp();
        n.mkFull();
        Integer m = new Integer(3);
        assertEquals(m, n.countOf('d'));
    }

    /**
     * Test method for {@link BinSearchTreeADT#countOf(java.lang.Character)}.
     */
    @Test
    public void countOfANullValue() {
        BinSearchTreeImp n = new BinSearchTreeImp();
        n.mkFull();
        Integer m = new Integer(0);
        assertEquals(m, n.countOf(null));
    }

    /**
     * Test method for {@link BinSearchTreeADT#height()}.
     */
    @Test
    public void findTreeOfHeightThree() {
        BinSearchTreeImp n = new BinSearchTreeImp();
        n.mkFull();
        Integer m = new Integer(3);
        assertEquals(m, n.height());
    }

    /**
     * Test method for {@link BinSearchTreeADT#height()}.
     */
    @Test
    public void findHeightOfLoopsidedTree() {
        BinSearchTreeImp n = new BinSearchTreeImp();
        n.add('c');
        n.add('b');
        n.add('a');
        n.add('d');
        Integer m = new Integer(3);
        assertEquals(m, n.height());
    }

    /**
     * Test method for {@link BinSearchTreeADT#mkFull()}.
     */
    @Test
    public void creatingATreeUsingMkTree() {
        BinSearchTreeImp n = new BinSearchTreeImp();
        n.mkFull();
        assertEquals("dbacfeg", n.toString());
    }

    /**
     * Test method for {@link BinSearchTreeADT#preorder()}.
     */
    @Test
    public void callPreorderOnFullTree() {
        BinSearchTreeImp n = new BinSearchTreeImp();
        n.mkFull();
        assertEquals("dbacfeg", n.preorder());
    }

    /**
     * Test method for {@link BinSearchTreeADT#preorder()}.
     */
    @Test
    public void callPreOrderOnSmallTree() {
        BinSearchTreeImp n = new BinSearchTreeImp();
        n.add('a');
        n.add('b');
        n.add('c');
        assertEquals("abc", n.preorder());
    }

    /**
     * Test method for {@link BinSearchTreeADT#remove(java.lang.Character)}.
     */
    @Test
    public void removeFromTheMiddleOfMkFullTree() {
        BinSearchTreeImp n = new BinSearchTreeImp();
        n.mkFull();
        n.remove('c');
        assertEquals("dbafeg", n.preorder());
    }

    /**
     * Test method for {@link BinSearchTreeADT#remove(java.lang.Character)}.
     */
    @Test
    public void removeFromTheTopOfMkFullTree() {
        BinSearchTreeImp n = new BinSearchTreeImp();
        n.mkFull();
        n.remove('d');
        assertEquals("cbafeg", n.preorder());
    }

    /**
     * Test method for {@link BinSearchTreeADT#toString()}.
     */
    @Test
    public void callingToStringOnMkTree() {
        BinSearchTreeImp n = new BinSearchTreeImp();
        n.mkFull();
        assertEquals("dbacfeg", n.toString());
    }

    /**
     * Test method for {@link BinSearchTreeADT#toString()}.
     */
    @Test
    public void callingToStringOnASmallTree() {
        BinSearchTreeImp n = new BinSearchTreeImp();
        n.add('a');
        n.add('b');
        n.add('c');
        assertEquals("abc", n.toString());
    }

}
