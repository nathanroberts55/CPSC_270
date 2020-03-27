/**
 * 
 */

/**
 * @author Nathan Roberts
 * @version October 7, 2017
 *
 */
public class LinkedLisp implements LispADT {
    private Lisp head;
    private Lisp tail;
    private Lisp curr;
    private int size;

    /**
     * Constructor
     */
    public LinkedLisp() {
        clear();
    }

    /**
     * Clears/Creates the List
     */
    public void clear() {
        tail = new Lisp(null); // Create tail lisp
        curr = tail;
        head = new Lisp(tail); // Create head lisp
        size = 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see LispADT#add(java.lang.Object)
     */
    @Override
    public LispADT add(Object c) {
        curr.setNext(new Lisp(curr.element(), curr.next()));
        curr.setElement(c);
        if (tail == curr) {
            tail = curr.next();
        }
        size++;
        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see LispADT#curPos()
     */
    @Override
    public Integer curPos() {
        Lisp temp = head.next();
        int i;
        for (i = 0; curr != temp; i++) {
            temp = temp.next();
        }
        return i;
    }

    /*
     * (non-Javadoc)
     * 
     * @see LispADT#get()
     */
    @Override
    public Object get() throws RuntimeException {
        if (curr == tail) {
            throw new RuntimeException();
        }
        return curr.element();
    }

    /*
     * (non-Javadoc)
     * 
     * @see LispADT#moveTo(java.lang.Integer)
     */
    @Override
    public LispADT moveTo(Integer p) {
        if ((p < 0) || (p > size)) {
            return this;
        }
        curr = head.next();
        for (int i = 0; i < p; i++) {
            curr = curr.next();
        }
        return this;

    }

    /*
     * (non-Javadoc)
     * 
     * @see LispADT#next()
     */
    @Override
    public LispADT next() {
        if (curr != tail) {
            curr = curr.next();
        }
        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see LispADT#prev()
     */
    @Override
    public LispADT prev() {
        if (head.next() == curr) {
            return this;
        }
        Lisp temp = head;

        while (temp.next() != curr) {
            temp = temp.next();
        }

        curr = temp;

        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see LispADT#remove()
     */
    @Override
    public LispADT remove() {
        if (curr == tail) {
            return this;
        }
        curr.setElement(curr.next().element());
        if (curr.next() == tail) {
            tail = curr;
        }
        curr.setNext(curr.next().next());
        size--;

        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see LispADT#size()
     */
    @Override
    public Integer size() {
        return size;
    }

    /**
     * Checks if the string of two LinkedLisp are the same
     * 
     * @param o
     *            the LinkedLisp being passed in for comparison
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        return this.toString().equals(o.toString());

    }

    /**
     * Converts a LinkedLisp to a String
     */
    @Override
    public String toString() {
        String result = "<";
        Lisp temp = head;

        while (temp.next() != null) {
            if (size == 0) {
                result += " | ";
                break;
            }
            else if (temp == head) {
                if (temp.next() == curr && curr.next() == tail) {
                    result += " | " + temp.next().element() + " ";
                }
                else if (temp.next().next() == tail && curr == tail) {
                    result += " " + temp.next().element() + " | ";
                }

                else if (temp.next() == curr) {
                    result += " | " + temp.next().element();
                }

                else {
                    result += " " + temp.next().element();
                }
                temp = temp.next().next();
            }
            else if (temp.next() != tail) {
                if (temp == curr) {
                    result += " | " + temp.element();
                }
                else {
                    result += " , " + temp.element();
                }
                temp = temp.next();
            }
            else {
                if (temp == curr) {
                    result += " | " + temp.element() + " ";
                }
                else if (temp.next() == curr) {
                    result += " , " + temp.element() + " | ";
                }
                else {
                    result += " , " + temp.element() + " ";
                }
                temp = temp.next();
            }

        }

        result += ">";
        return result;
    }

}
