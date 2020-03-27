/**
 * @author Nathan Roberts
 * @version 2017-01-25
 *
 */
public class RecursiveParser implements ParserADT {

    /*
     * (non-Javadoc)
     * 
     * @see ParserADT#factorial(java.lang.Integer)
     */
    @Override
    public Integer factorial(Integer n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see ParserADT#isPalindrome(java.lang.String)
     */
    @Override
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
        else {
            return false;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see ParserADT#isParamList(java.lang.String)
     */
    @Override
    public boolean isParamList(String p) {
        char c = 0;
        if (p.length() == 1 && Character.isDigit(p.charAt(0))) {
            return false;
        }
        if (p.length() == 1 && Character.isLetter(p.charAt(0))) {
            return true;
        }
        if (Character.isLetter(p.charAt(c))
                || Character.isDigit(p.charAt(c))) {
            return (isParamList(p.substring(0, p.length() - 1)));
        }
        return false;
        // if (p.length() == 0 || Character.isLetter(p.charAt(0))) {
        // return true;
        // }
        // if (Character.isLetter(p.charAt(0))
        // && Character.isLetter(p.charAt(p.length() - 1))) {
        // return isParamList(p.substring(1, p.length() - 1));
        // }
        // else {
        // return false;
        // }

    }

    /*
     * (non-Javadoc)
     * 
     * @see ParserADT#power(java.lang.Double, java.lang.Integer)
     */
    @Override
    public Double power(Double b, Integer x) throws IllegalArgumentException {
        if (x < 0) {
            throw new IllegalArgumentException();
        }
        if (x == 0) {
            return (double) 1;
        }
        else {
            return b * power(b, x - 1);
        }
    }

}
