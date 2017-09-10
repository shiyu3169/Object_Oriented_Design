import java.util.Comparator;

/**
 * comparator compare by String's length used to sort BTree
 * 
 * @author Shiyu
 * @version 2013-7-10
 */
public class StringByLength implements Comparator<String> {

    /**
     * compare two string by their length, given negative when first is shorter
     * than second
     * 
     * @author Shiyu
     * @version 2013-10-7
     * @param s1
     *            -- the first string
     * @param s2
     *            -- the second string
     * @return the integer give negative when first is shorter, other is
     *         positive
     */
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}