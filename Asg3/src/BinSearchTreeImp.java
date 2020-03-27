/**
 * 
 */

/**
 * @author Nathan ROberts
 * @version Nov. 27th, 2017
 *
 */
public class BinSearchTreeImp implements BinSearchTreeADT {

    private Node root;

    /**
     * Binary Search Tree Constructor
     */
    public BinSearchTreeImp() {
        this.root = null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see BinSearchTreeADT#add(java.lang.Character)
     */
    @Override
    public BinSearchTreeADT add(Character c) {

        root = addHelper(root, c);
        return this;
    }

    /**
     * 
     * @param n
     *            the node to start at
     * @param c
     *            the character to be added
     * @return the address of the root node
     */

    private Node addHelper(Node n, Character c) {
        if (n == null) {
            root = new Node(c, null, null);
            return this.root;
        }
        else if (n.getVal().equals(c)) {
            return n;
        }
        else if (n.getVal().compareTo(c) > 0) {
            n.setleft(addHelper(n.left(), c));
        }
        else {
            n.setright(addHelper(n.right(), c));
        }
        return n;
    }

    /*
     * (non-Javadoc)
     * 
     * @see BinSearchTreeADT#countOf(java.lang.Character)
     */
    @Override
    public Integer countOf(Character c) {
        if (c == null) {
            return 0;
        }
        return countHelper(this.root, c);
    }

    /**
     * 
     * @param n
     *            starting node
     * @param c
     *            the values were finding the less than
     * @return the values of the nodes that are less than
     */
    private Integer countHelper(Node n, Character c) {

        if (n == null) {
            return 0;
        }
        else if (n.getVal() >= c) {
            return countHelper(n.left(), c);
        }
        else {
            return countHelper(n.left(), c) + countHelper(n.right(), c) + 1;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see BinSearchTreeADT#height()
     */
    @Override
    public Integer height() {

        return heightHelper(this.root);
    }

    /**
     * 
     * @param n
     *            the root node
     * @return the height of the tree
     */
    private Integer heightHelper(Node n) {
        if (n == null) {
            return 0;
        }

        int leftH = heightHelper(n.left());
        int rightH = heightHelper(n.right());

        if (leftH > rightH) {
            return leftH + 1;
        }
        else {
            return rightH + 1;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see BinSearchTreeADT#mkFull()
     */
    @Override
    public BinSearchTreeADT mkFull() {
        Node a = new Node('a', null, null);
        Node c = new Node('c', null, null);
        Node e = new Node('e', null, null);
        Node g = new Node('g', null, null);
        Node b = new Node('b', a, c);
        Node f = new Node('f', e, g);
        Node d = new Node('d', b, f);
        this.root = d;

        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see BinSearchTreeADT#preorder()
     */
    @Override
    public String preorder() {
        return preOrderHelper(this.root);
    }

    /**
     * 
     * Helper Method that prints the preorder traversal of the tree
     * 
     * @param n
     *            the root node
     */
    private String preOrderHelper(Node n) {
        String s = "";
        if (n != null) {
            return n.getVal() + preOrderHelper(n.left())
                    + preOrderHelper(n.right());

        }
        else {
            return s;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see BinSearchTreeADT#remove(java.lang.Character)
     */
    @Override
    public BinSearchTreeADT remove(Character c) {

        root = removeHelper(root, c);
        return this;
    }

    /**
     * 
     * @param n
     *            the head node
     * @param c
     *            the value to remove
     * @return
     */
    private Node removeHelper(Node n, Character c) {

        if (n == null) {
            return null;
        }
        else if (n.getVal() > c) {
            n.setleft(removeHelper(n.left(), c));
        }
        else if (n.getVal() < c) {
            n.setright(removeHelper(n.right(), c));
        }
        else { // item found
            if (n.right() == null) {
                return n.left();
            }
            else { // two kids
                Node max = getMax(n.left());
                n.setVal(max.getVal());
                n.setleft(removeHelper(n.left(), max.getVal()));
            }
        }
        return n;

    }

    /**
     * 
     * @param n
     *            the root node
     * @return the node with the highest value
     */
    private Node getMax(Node n) {
        if (n.right() != null) {
            return getMax(n.right());
        }
        return n;
    }

    /**
     * Method calls preOrder to print a preOrder traversal of the tree
     */
    @Override
    public String toString() {
        return this.preorder();
    }
}
