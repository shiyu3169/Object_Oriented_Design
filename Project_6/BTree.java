/**
 * Shiyu Wang
 * shiyu@ccs.neu.edu
 * I can't make anything not public since 
 * we want to test every method with white-box,
 * for black-box test, we can private add(String it), which we don't need test,
 * and private active.
 * we private bad(if we don't cover all cases of next)
 */
import java.util.*;
import rbtree.*;

/**
 * rep invariants is :
 * BTree.rbt != null &&
 * all elements of BTree.rbt are Strings &&
 * there are no duplicates in BTree.rbt &&
 * every node is either red or black &&
 * for each node, all simple path from the node to descendant leaves
 * contains same number of black nodes &&
 * if the node is red, then both its children are black;
 * 
 */

/**abstraction function:
 * AF(Leaf(Comparator<String> comp)) = {comp}
 * AF(Node(String data, RBT left, RBT right,
 *  Comparator<String> comp, String color)) 
 * = {data, left, right, comp, color}
 */

/**
 * 
 * @author Shiyu
 * @version 2013-10-31
 * 
 *          The class that represent the BTree implements Iterable<String>
 */
public class BTree implements Iterable<String> {

    /** the field BT represent a red-black tree in BTree */
    RBTree             rbt;
    /** the number of currently active iterators */
    int     active = 0;
    /** abandon all hope */
    boolean bad    = false;

    /**
     * constructor
     * 
     * @param rbt
     *            the red-black tree
     */
    BTree(RBTree rbt) {
        this.rbt = rbt;
    }

    /**
     * Factory method to generate an empty binary search tree with the given
     * <code>Comparator</code>
     * 
     * @author Shiyu
     * @version 2013-10-31
     * 
     * @param comp
     *            the given <code>Comparator</code>
     * @return new empty red-black tree that uses the given
     *         <code>Comparator</code> for ordering
     */
    public static BTree binTree(Comparator<String> comp) {
        return new BTree(RBTree.leaf(comp));
    }

    /**
     * Modifies: this red-black tree by inserting the <code>String</code>s from
     * the given <code>Iterable</code> collection The tree will not have any
     * duplicates - if an item to be added equals an item that is already in the
     * tree, it will not be added.
     * 
     * @author Shiyu
     * @version 2013-10-31
     * @param iter
     *            the given <code>Iterable</code> collection
     */
    public void build(Iterable<String> iter) {
        for (String it : iter) {
            this.add(it);
        }
        if (rbt instanceof Node) {
            this.rbt = this.rbt.blackT();
        }
    }

    /**
     * Modifies: this red-black-tree by inserting the first numStrings
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
        if (rbt instanceof Node) {
            this.rbt = this.rbt.blackT();
        }
    }

    /**
     * Insert the String in to the BTree
     * 
     * @author Shiyu
     * @version 2013-10-31
     * @param it
     *            - the adding String
     */
    public void add(String it) {
        if (active == 0) {
            this.rbt = this.rbt.add(it);
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
     * @version 2013-10-31
     * @return Update the BTree to String
     */
    public String toString() {
        if (rbt.isLeaf()) {
            return "";
        } 
        else {
            String s = "";
            ArrayList<String> blist = rbt.buildList();
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
     * @version 2013-10-31
     * @return boolean checking everything is valid
     */
    public boolean repOK() {
        if (rbt instanceof Node) {
            return rbt.getColor().equals("black") && rbt.repOK();
        } 
        else {
            return rbt.repOK();
        }
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
     * @version 2013-10-31
     * @return check if the given object is the same as the BTree
     * @param o
     *            the object to compare with this
     */
    public boolean equals(Object o) {
        if (!(o instanceof BTree)) {
            return false;
        } 
        else {
            BTree b = ((BTree) o);
            return this.rbt.equals(b.rbt);
        }
    }

    /**
     * Effect: Produces an integer that is compatible with the implemented
     * equals method and is likely to be different for objects that are not
     * equal.
     * 
     * @author Shiyu
     * @version 2013-10-31
     * @return Give the hashCode of the BTree
     */
    public int hashCode() {
        return rbt.hashCode();
    }

    /**
     * @author Shiyu
     * @version 2013-10-31
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
     * @version 2013-10-31
     */

    public boolean contains(String s) {
        return rbt.contains(s);
    }

    /**
     * Inner class represents the iterator of BTree that implements the
     * <code>Iterator</code> interface
     * 
     * @author Shiyu
     * @version 2013-10-31
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
         * @version 2013-10-31
         * @return true if at least one element in the <code>ArrayList</code>
         *         has not been generated
         */
        public boolean hasNext() {
            return rbt != null && current < rbt.buildList().size();
        }

        /**
         * If possible, generate the next element and advance the current index
         * Throw <code>NoSuchElementException</code> if no element can be
         * generated. Throw <code>ConcurrentModificationException</code> if some
         * other invocation has thrown this exception already.
         * 
         * @author Shiyu
         * @version 2013-10-31
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
            String result = rbt.buildList().get(current); // get the value to
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
         * @version 2013-10-31
         */
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

    }
}
