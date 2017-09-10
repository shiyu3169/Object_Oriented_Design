package rbtree;
import java.util.Comparator;

/**
 * comparator compare by string's lex used to sort BTree
 * 
 * @author Shiyu
 * @version 2013-7-10
 */
public class MyStringByLex implements Comparator<String> {

    /**
     * compare two string by their lex, given negative when second is behind the
     * first
     * 
     * @author Shiyu
     * @version 2013-10-7
     * @param s1
     *            -- the first string
     * @param s2
     *            -- the second string
     * @return the integer give negative when second is behind the first
     */
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
    
    
}