import java.util.*;

/**
 * rep invariants is :
 * BTree.bt != null &&
 * all elements of BTree.bt are Strings &&
 * there are no duplicates in BTree.bt
 */

/**abstraction function:
 * AF(Leaf(Comparator<String> comp)) = {comp}
 * AF(Node(String data, BT left, BT right, Comparator<String> comp)) 
 * = {data, left, right, comp}
 */

/**
 * 
 * @author Shiyu
 * @version 2013-10-07
 * 
 *          The class that represent the BTree implements Iterable<String>
 */
public class BTree implements Iterable<String> {

    /** the field BT represent a binaryTree in BTree */
    BT              bt;
    /** the number of currently active iterators */
    private int     active = 0;
    /** abandon all hope */
    private boolean bad    = false;

    /**
     * constructor
     * 
     * @param bt
     *            the binaryTree
     */
    BTree(BT bt) {
        this.bt = bt;
    }

    /**
     * Factory method to generate an empty binary search tree with the given
     * <code>Comparator</code>
     * 
     * @author Shiyu
     * @version 2013-10-8
     * 
     * @param comp
     *            the given <code>Comparator</code>
     * @return new empty binary search tree that uses the given
     *         <code>Comparator</code> for ordering
     */
    public static BTree binTree(Comparator<String> comp) {
        return new BTree(new Leaf(comp));
    }

    /**
     * Modifies: this binary search tree by inserting the <code>String</code>s
     * from the given <code>Iterable</code> collection The tree will not have
     * any duplicates - if an item to be added equals an item that is already in
     * the tree, it will not be added.
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @param iter
     *            the given <code>Iterable</code> collection
     */
    public void build(Iterable<String> iter) {
        for (String it : iter) {
            this.add(it);
        }
    }

    /**
     * Modifies: this binary search tree by inserting the first numStrings
     * <code>String</code>s from the given <code>Iterable</code> collection The
     * tree will not have any duplicates - if an item to be added equals an item
     * that is already in the tree, it will not be added.
     * 
     * @param iter
     *            the given <code>Iterable</code> collection
     * @param numStrings
     *            number of <code>String</code>s to iterate through and add to
     *            BTree If numStrings is negative or larger than the number of
     *            <code>String</code>s in iter then all <code>String</code>s in
     *            iter should be inserted into the tree
     */
    public void build(Iterable<String> iter, int numStrings) {
        for (String it : iter) {
            if (numStrings != 0) {
                this.add(it);
                numStrings--;
            }
        }
    }

    /**
     * Insert the String in to the BTree
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @param it
     *            - the adding String
     */
    private void add(String it) {
        if (active == 0) {
            this.bt = this.bt.add(it);
        } 
        else {
            this.bad = true;
            throw new ConcurrentModificationException(
                    "add with active iterator");
        }
    }

    /**
     * Effect: Produces a <code>String</code> that consists of all
     * <code>String</code>s in this tree separated by comma and a space,
     * generated in the order defined by this tree's <code>Comparator</code>. So
     * for a tree with <code>Strings</code> "hello" "bye" and "aloha" ordered
     * lexicographically, the result would be "aloha, bye, hello"
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @return Update the BTree to String
     */
    public String toString() {
        if (bt.isLeaf()) {
            return "";
        } 
        else {
            String s = "";
            ArrayList<String> blist = bt.buildList();
            for (int i = 0; i < blist.size() - 1; i++) {
                s = s + blist.get(i) + ", ";
            }
            s = s + blist.get(blist.size() - 1);
            return s;
        }

    }

    /**
     * repOk check everything is valid
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @return boolean checking everything is valid
     */
    public boolean repOk() {
        if (bt == null) {
            return false;
        }
        for (int i = 0; i < bt.buildList().size(); i++) {
            Object x = bt.buildList().get(i);
            if (!(x instanceof String)) {
                return false;
            }
            for (int j = i + 1; j < bt.buildList().size(); j++) {
                if (x.equals(bt.buildList().get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Effect: Produces false if o is not an instance of BTree. Produces true if
     * this tree and the given BTree contain the same <code>String</code>s and
     * are ordered by the same <code>Comparator</code>. So if the first tree was
     * built with Strings "hello" "bye" and "aloha" ordered lexicographically,
     * and the second tree was built with <code>String</code>s "aloha" "hello"
     * and "bye" and ordered lexicographically, the result would be true.
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @return check if the given object is the same as the BTree
     * @param o
     *            the object to compare with this
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof BTree) {
            return ((BTree) o).bt.equals(this.bt);
        } 
        else {
            return false;
        }
    }

    /**
     * Effect: Produces an integer that is compatible with the implemented
     * equals method and is likely to be different for objects that are not
     * equal.
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @return Give the hashCode of the BTree
     */
    public int hashCode() {
        return bt.hashCode();
    }

    /**
     * @author Shiyu
     * @version 2013-10-8
     * @return the iterator of BTree
     */
    public Iterator<String> iterator() {
        return new BTreeIterator();
    }

    /**
     * Effect: Checks to see if this BTree contains s
     * 
     * @param s
     *            <code>String</code> to look for in this
     * @return whether this contains s
     * @author Shiyu
     * @version 2013-10-10
     */

    public boolean contains(String s) {
        return bt.contains(s);
    }

    /**
     * Inner class represents the iterator of BTree that implements the
     * <code>Iterator</code> interface
     * 
     * @author Shiyu
     * @version 2013-10-8
     */
    public class BTreeIterator implements Iterator<String> {
        /** the index of current BTree */
        private int current;

        /** constructor saves the BTree to iterate over */
        BTreeIterator() {
            this.current = 0;
            if (this.hasNext()) {
                active = active + 1;
            }
        }

        /**
         * Can we generate the next element? For safety we test for null as well
         * 
         * @author Shiyu
         * @version 2013-10-7
         * @return true if at least one element in the <code>ArrayList</code>
         *         has not been generated
         */
        public boolean hasNext() {
            return bt != null && current < bt.buildList().size();
        }

        /**
         * If possible, generate the next element and advance the current index
         * Throw <code>NoSuchElementException</code> if no element can be
         * generated. Throw <code>ConcurrentModificationException</code> if some
         * other invocation has thrown this exception already.
         * 
         * @author Shiyu
         * @version 2013-10-7
         * @return the next element of BTree</code>
         */
        public String next() {
            if (bad) {
                throw new ConcurrentModificationException(
                        "next on a bad iterator");
            }
            if (!this.hasNext()) {
                throw new NoSuchElementException("next when no hasNext");
            }
            String result = bt.buildList().get(current); // get the value to
                                                         // return
            current = current + 1; // update the current
            if (!this.hasNext()) {
                // decrease the number of active iterators if reach end
                active = active - 1;
            }
            return result;
        }

        /**
         * Modifies: do nothing (should throw NotImplementedException)
         * 
         * @author Shiyu
         * @version 2013-7-10
         */
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

    }
}

/**
 * the class that represents the binaryTree
 * 
 * @author Shiyu
 * @version 2013-10-8
 * 
 */
abstract class BT {

    /** comparator use to see the way the binarayTree sorted */
    Comparator<String> comp;

    /**
     * constructor
     * 
     * @param comp
     *            the comparator shows the way sorted BT
     */
    BT(Comparator<String> comp) {
        this.comp = comp;
    }

    /**
     * check the Bt is leaf or not
     * 
     * @author Shiyu
     * @return Check if the tree is a leaf
     */
    public abstract boolean isLeaf();

    /**
     * add the giving String into BT
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @param it
     *            the adding String
     * @return add the String in the BinaryTree
     * */
    public abstract BT add(String it);

    /**
     * Effect: Produces false if b is not an instance of BT. Produces true if
     * this BT and the given BT contain the same <code>String</code>s and are
     * ordered by the same <code>Comparator</code>. So if the first tree was
     * built with Strings "hello" "bye" and "aloha" ordered lexicographically,
     * and the second tree was built with <code>String</code>s "aloha" "hello"
     * and "bye" and ordered lexicographically, the result would be true.
     * 
     * @author Shiyu
     * @version 2013-10-7
     * @param b
     *            the object to compare with this
     * @return the boolean check if they are equal.
     */
    public abstract boolean equals(Object b);

    /**
     * Effect: Produces an integer that is compatible with the implemented
     * equals method and is likely to be different for objects that are not
     * equal.
     * 
     * @author Shiyu
     * @version 2013-10-7
     * @return the hashCode of BTree
     */
    public abstract int hashCode();

    /**
     * effect: build a arrayList with the tree's order
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @return the arrayList version of Btree.
     */
    public abstract ArrayList<String> buildList();

    /**
     * Effect: Checks to see if this BTree contains s
     * 
     * @param s
     *            <code>String</code> to look for in this
     * @return whether this contains s
     * @author Shiyu
     * @version 2013-10-10
     */

    public abstract boolean contains(String s);
}

/**
 * represent a leaf which is empty binaryTree
 * 
 * @author Shiyu
 * @version 2013-10-8
 */
class Leaf extends BT {

    /**
     * contractor
     * 
     * @param comp
     *            - the comparator shows the way that sorted BT
     */
    Leaf(Comparator<String> comp) {
        super(comp);
    }

    /**
     * check the BT is leaf or not
     * 
     * @author Shiyu
     * @return Check if the tree is a leaf
     */
    public boolean isLeaf() {
        return true;
    }

    /**
     * add the giving String into BT
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @param it
     *            the adding String
     * @return add the String in the BinaryTree
     * */
    public BT add(String it) {
        return new Node(it, this, this, comp);
    }

    /**
     * Effect: Produces false if b is not an instance of BT. Produces true if
     * this BT and the given BT contain the same <code>String</code>s and are
     * ordered by the same <code>Comparator</code>. So if the first tree was
     * built with Strings "hello" "bye" and "aloha" ordered lexicographically,
     * and the second tree was built with <code>String</code>s "aloha" "hello"
     * and "bye" and ordered lexicographically, the result would be true.
     * 
     * @author Shiyu
     * @version 2013-10-7
     * @param b
     *            the object to compare with this
     * @return the boolean check if they are equal.
     */
    public boolean equals(Object b) {
        if (b == null) {
            return false;
        }
        if (b instanceof Leaf) {
            return ((Leaf) b).isLeaf() && ((Leaf) b).comp.equals(this.comp);
        } 
        else {
            return false;
        }

    }

    /**
     * Effect: Produces an integer that is compatible with the implemented
     * equals method and is likely to be different for objects that are not
     * equal.
     * 
     * @author Shiyu
     * @version 2013-10-7
     * @return the hashCode of BTree
     */
    public int hashCode() {
        return this.comp.hashCode() + 123;
    }

    /**
     * build the arrayList of the Leaf
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @return the arrayList version of Leaf
     */
    public ArrayList<String> buildList() {
        return new ArrayList<String>();
    }

    /**
     * Effect: Checks to see if this BTree contains s
     * 
     * @param s
     *            <code>String</code> to look for in this
     * @return whether this contains s
     * @author Shiyu
     * @version 2013-10-10
     */

    public boolean contains(String s) {
        return false;
    }

}

/**
 * the class Node that represents the non-empty binaryTree
 * 
 * @author Shiyu
 * @version 2013-10-8
 */
class Node extends BT {

    /** the String of this node */
    public String data;
    /** left child of this Node */
    public BT     left;
    /** right child of this Node */
    public BT     right;

    /**
     * constructor for Node
     * 
     * @param data
     *            - the string of this Node
     * @param left
     *            - the left child of this Node
     * @param right
     *            the right Child of this Node
     * @param comp
     *            - the comparator of this Node
     */
    Node(String data, BT left, BT right, Comparator<String> comp) {
        super(comp);
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * check the BT is leaf or not
     * 
     * @author Shiyu
     * @return Check if the tree is a leaf
     */
    public boolean isLeaf() {
        return false;
    }

    /**
     * add the giving String into BT
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @param it
     *            the adding String
     * @return add the String in the BinaryTree
     * */
    public BT add(String it) {
        if (comp.compare(this.data, it) < 0) {
            return new Node(this.data, left.add(it), this.right, comp);
        }
        if (comp.compare(this.data, it) > 0) {
            return new Node(this.data, this.left, right.add(it), comp);
        } 
        else {
            return this;
        }
    }

    /**
     * Effect: Produces false if b is not an instance of BT. Produces true if
     * this BT and the given BT contain the same <code>String</code>s and are
     * ordered by the same <code>Comparator</code>. So if the first tree was
     * built with Strings "hello" "bye" and "aloha" ordered lexicographically,
     * and the second tree was built with <code>String</code>s "aloha" "hello"
     * and "bye" and ordered lexicographically, the result would be true.
     * 
     * @author Shiyu
     * @version 2013-10-7
     * @param b
     *            the object to compare with this
     * @return the boolean check if they are equal.
     */
    public boolean equals(Object b) {
        if (b == null) {
            return false;
        }
        if (b instanceof Node) {
            return (!((Node) b).isLeaf()) && ((Node) b).comp.equals(this.comp)
                    && ((Node) b).data.equals(this.data)
                    && ((Node) b).left.equals(this.left)
                    && ((Node) b).right.equals(this.right);
        } 
        else {
            return false;
        }

    }

    /**
     * Effect: Produces an integer that is compatible with the implemented
     * equals method and is likely to be different for objects that are not
     * equal.
     * 
     * @author Shiyu
     * @version 2013-10-7
     * @return the hashCode of BTree
     */
    public int hashCode() {
        return this.left.hashCode() + this.data.hashCode()
                + this.right.hashCode() + this.comp.hashCode();
    }

    /**
     * transfer Node into arrayList
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @return the arrayList version of Node
     */
    public ArrayList<String> buildList() {
        ArrayList<String> alist = new ArrayList<String>();
        alist.add(this.data);
        alist.addAll(this.left.buildList());
        alist.addAll(this.right.buildList());
        Collections.sort(alist, comp);
        return alist;
    }

    /**
     * Effect: Checks to see if this BTree contains s
     * 
     * @param s
     *            <code>String</code> to look for in this
     * @return whether this contains s
     * @author Shiyu
     * @version 2013-10-10
     */

    public boolean contains(String s) {
        return s.equals(this.data) || this.left.contains(s)
                || this.right.contains(s);

    }

}

/**
 * comparator compare by String's length used to sort BTree
 * 
 * @author Shiyu
 * @version 2013-7-10
 */
class StringByLength implements Comparator<String> {

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

/**
 * comparator compare by string's lex used to sort BTree
 * 
 * @author Shiyu
 * @version 2013-7-10
 */
class StringByLex implements Comparator<String> {
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
