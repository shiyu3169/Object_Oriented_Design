import java.util.Comparator;

/**
 * comparator compare by integer used to sort BTree
 * 
 * @author Shiyu
 * @version 2013-7-10
 */
public class IntegerComparator implements Comparator<Integer> {
    /**
     * compare two Integer, given negative when first is smaller
     * than second
     * 
     * @author Shiyu
     * @version 2013-10-7
     * @param s1
     *            -- the first integer
     * @param s2
     *            -- the second integer
     * @return the integer give negative when first is smaller, other is
     *         positive
     */
    public int compare(Integer s1, Integer s2) {
        return s1 - s2;
    }
}
