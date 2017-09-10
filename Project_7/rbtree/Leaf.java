package rbtree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * represent a leaf which is empty binaryTree
 * 
 * @author Shiyu
 * @param <T> the type of data for this RBTree
 * @version 2013-10-8
 */
public class Leaf<T> extends RBTree<T> {

    /**
     * contractor
     * 
     * @param comp
     *            - the comparator shows the way that sorted BT
     */
    public Leaf(Comparator<T> comp) {
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
     *            the adding object
     * @return add the String in the BinaryTree
     * */
    public RBTree<T> add(T it) {
        return new Node<T>(it, this, this, comp, "red");
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
        return 123;
    }

    /**
     * build the arrayList of the Leaf
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @return the arrayList version of Leaf
     */
    public ArrayList<T> buildList() {
        return new ArrayList<T>();
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

    public boolean contains(T s) {
        return false;
    }

    /**
     * balancing the tree with the Red-Black tree's rule
     * 
     * @return balanced tree
     */
    public RBTree<T> balance() {
        return this;
    }

    /**
     * getting the data of RBT
     * 
     * @return the data of the RBT
     */
    public T getData() {
        throw new NoSuchElementException("no data for a leaf");
    }

    /**
     * getting the left of RBT
     * 
     * @return the left child of RBT
     */
    public RBTree<T> getLeft() {
        throw new NoSuchElementException("no left child for a leaf");
    }

    /**
     * getting the right of RBT
     * 
     * @return the right child of RBT
     */
    public RBTree<T> getRight() {
        throw new NoSuchElementException("no right child for a leaf");
    }

    /**
     * getting the color of RBT
     * 
     * @return the color of this RBT
     */
    public String getColor() {
        throw new NoSuchElementException("no color for a leaf");
    }

    /**
     * making the RBT into black color
     * 
     * @return the RBT changed into black color
     */
    public RBTree<T> blackT() {
        throw new RuntimeException("this is a leaf");
    }

    /**
     * repOk check everything is valid
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @return boolean checking everything is valid
     */
    public boolean repOK() {
        return true;
    }

    /**
     * check if there is  duplicates of this RBT
     * 
     * @return true if there is a duplicates 
     */
    public boolean hasDup() {
        return false;
    }

    /**
     * count the number of black nodes in the max path
     * 
     * @return the number of black nodes in the max path
     */
    public int maxBlack() {
        return 0;
    }

    /**
     * count the number of black nodes in the min path
     * 
     * @return the number of black nodes in the min path
     */
    public int minBlack() {
        return 0;
    }
    
    /**
     * accept the visitor that produces the result of the type R
     * @param rv - the visitor
     * @param <R> the type of output
     * @return the result of the type R
     */
    public <R> R accept(RBTreeVisitor<T, R> rv) {
        return rv.visitLeaf(comp);
    }
    
    /**
     * effect: build a arrayList of color with the tree's order
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @return the arrayList of color of Btree.
     */
    public ArrayList<String> buildList2() {
        return new ArrayList<String>();
    }
}