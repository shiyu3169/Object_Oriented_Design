package rbtree;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * the class that represents the binaryTree
 * 
 * @author Shiyu
 * @param <T> the type of this RBTree
 * @version 2013-10-8
 * 
 */
public abstract class RBTree<T> {

    /** comparator use to see the way the binarayTree sorted */
    public Comparator<T> comp;

    /**
     * constructor
     * 
     * @param comp
     *            the comparator shows the way sorted BT
     */
    public RBTree(Comparator<T> comp) {
        this.comp = comp;
    }

    /**
     * basic creator of leaf
     * @param <T> the type of this RBTree
     * @param comp
     *            - the comparator of the RBT
     * @return - the new Leaf
     */
    public static <T> RBTree<T> leaf(Comparator<T> comp) {
        return new Leaf<T>(comp);
    }

    /**
     * basic creator of Node
     * @param <T> the type of this RBTree
     * @param data
     *            - the data string of the node
     * @param left
     *            - the left child of this node
     * @param right
     *            - the right child of this node
     * @param comp
     *            - the comparator of this RBT
     * @param color
     *            - the color of this node
     * @return - the new Node
     */
    public static <T> RBTree<T> node(T data, RBTree<T> left, RBTree<T> right,
            Comparator<T> comp, String color) {
        return new Node<T>(data, left, right, comp, color);
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
    public abstract RBTree<T> add(T it);

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
     * @param o
     *            the object to compare with this
     * @return the boolean check if they are equal.
     */
    public boolean equals(Object o) {
        if (!(o instanceof RBTree<?>)) {
            return false;
        }
        @SuppressWarnings("unchecked")
        RBTree<T> b =  (RBTree<T>) o;
        if (((RBTree<T>) b).buildList().size() != this.buildList().size()) {
            return false;
        } 
        if (((RBTree<T>) b).isLeaf()) {
            return this.isLeaf();
        }
        else {
            return  b.getData().equals(this.getData())
                    && b.getColor().equals(this.getColor())
                    && b.getLeft().equals(this.getLeft())
                    && b.getRight().equals(this.getRight());
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
    public abstract int hashCode();

    /**
     * effect: build a arrayList with the tree's order
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @return the arrayList version of Btree.
     */
    public abstract ArrayList<T> buildList();
    
    /**
     * Effect: Checks to see if this BTree contains s
     * 
     * @param s
     *            <code>String</code> to look for in this
     * @return whether this contains s
     * @author Shiyu
     * @version 2013-10-10
     */
    public abstract boolean contains(T s);

    /**
     * balancing the tree with Red-Black tree's rule
     * 
     * @return the balanced tree
     */
    public abstract RBTree<T> balance();

    /**
     * getting the data of RBT
     * 
     * @return the data of the RBT
     */
    public abstract T getData();

    /**
     * getting the left of RBT
     * 
     * @return the left child of RBT
     */
    public abstract RBTree<T> getLeft();

    /**
     * getting the right of RBT
     * 
     * @return the right child of RBT
     */
    public abstract RBTree<T> getRight();

    /**
     * getting the color of RBT
     * 
     * @return the color of this RBT
     */
    public abstract String getColor();

    /**
     * making the RBT into black color
     * 
     * @return the RBT changed into black color
     */
    public abstract RBTree<T> blackT();

    /**
     * repOk check everything is valid
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @return boolean checking everything is valid
     */
    public abstract boolean repOK();

    /**
     * check if there is no duplicates of this RBT
     * 
     * @return true if this is duplicates
     */
    public abstract boolean hasDup();

    /**
     * count the number of black nodes in the max path
     * 
     * @return the number of black nodes in the max path
     */
    public abstract int maxBlack();

    /**
     * count the number of black nodes in the min path
     * 
     * @return the number of black nodes in the min path
     */
    public abstract int minBlack();
    
    /**
     * accept the visitor that produces the result of the type R
     * @param rv - the visitor
     * @param <R> the output type
     * @return the result of the type R
     */
    public abstract <R> R accept(RBTreeVisitor<T, R> rv);
    
    /**
     * effect: build a arrayList of color with the tree's order
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @return the arrayList of color of Btree.
     */
    public abstract ArrayList<String> buildList2();
    
}