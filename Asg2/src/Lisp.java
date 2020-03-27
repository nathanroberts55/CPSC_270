/**
 * 
 */

/**
 * @author Nathan Roberts
 * @version October 7, 2017
 */
class Lisp {

    private Object e;
    private Lisp n;

    /**
     * Sets the value and the address to the next Lisp
     * 
     * @param it
     *            it value being passed in
     * @param inn
     *            inn address to the next Lisp
     */
    public Lisp(Object it, Lisp inn) {
        e = it;
        n = inn;
    }

    /**
     * For creating a Lisp, sets value to null and adds address of the next
     * Lisp.
     * 
     * @param inn
     *            the address of the next line
     */
    public Lisp(Lisp inn) {
        e = null;
        n = inn;
    }

    /**
     * Returns the value of the Lisp
     * 
     * @return e
     */

    public Object element() {
        return e;
    }

    /**
     * Sets the value of the Lisp
     * 
     * @param it
     *            value of object passing in
     * @return e
     */

    public Object setElement(Object it) {
        e = it;
        return e;
    }

    /**
     * Returns the value of the next Lisp
     * 
     * @return n
     */
    public Lisp next() {
        return n;
    }

    /**
     * Sets the address of the next Lisp the the n of current Lisp
     * 
     * @param inn
     *            the address of the next Lisp
     * @return n
     */
    public Lisp setNext(Lisp inn) {
        n = inn;
        return n;
    }

}
