/**
 * 
 */

/**
 * @author Nathan Roberts
 * @version Nov. 27th, 2017
 *
 */
public class Node {
    private Character val;
    private Node left;
    private Node right;

    /**
     *
     * @param val
     *            the value stored
     * @param left
     *            the node to the left
     * @param right
     *            node to the right
     */
    public Node(Character val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * returns the value of the node
     * 
     * @return the value of the node
     */
    public Character getVal() {
        return val;
    }

    /**
     * sets the value of the node
     * 
     * @param val
     *            of the node
     */
    public void setVal(Character val) {
        this.val = val;
    }

    /**
     * returns the left node
     * 
     * @return the left node
     */
    public Node left() {
        return left;
    }

    /**
     * sets the value of the left node
     * 
     * @param lt
     *            the left node to be stored
     */
    public void setleft(Node lt) {
        this.left = lt;
    }

    /**
     * returns the right node
     * 
     * @return the right node
     */
    public Node right() {
        return right;
    }

    /**
     * set the left node
     * 
     * @param rt
     *            the node to the right
     */
    public void setright(Node rt) {
        this.right = rt;
    }

}
