package rbtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * the class Node that represents the non-empty binaryTree
 * 
 * @author Shiyu
 * @param <T> the type of data in this node
 * @version 2013-10-8
 */
public class Node<T> extends RBTree<T> {

    /** the String of this node */
    T data;
    /** left child of this Node */
    RBTree<T>    left;
    /** right child of this Node */
    RBTree<T>    right;
    /** the color of this Node */
    String color;

    /**
     * constructor for Node
     * 
     * @param data
     *            - the object of this Node
     * @param left
     *            - the left child of this Node
     * @param right
     *            the right Child of this Node
     * @param comp
     *            - the comparator of this Node
     * @param color
     *            - the color of this Npde, either red/black
     */
    public Node(T data, RBTree<T> left, RBTree<T> right,
            Comparator<T> comp, String color) {
        super(comp);
        this.data = data;
        this.left = left;
        this.right = right;
        this.color = color;
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
    public RBTree<T> add(T it) {
        if (comp.compare(this.data, it) > 0) {
            return new Node<T>(this.data, left.add(it), this.right, comp, color)
                    .balance();
        }
        if (comp.compare(this.data, it) < 0) {
            return new Node<T>(this.data, this.left, right.add(it), comp, color)
                    .balance();
        } 
        else {
            return this.balance();
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
                + this.right.hashCode() + this.color.hashCode();
    }

    /**
     * transfer Node into arrayList
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @return the arrayList version of Node
     */
    public ArrayList<T> buildList() {
        ArrayList<T> alist = new ArrayList<T>();
        alist.add(this.data);
        alist.addAll(this.left.buildList());
        alist.addAll(this.right.buildList());
        Collections.sort(alist, comp);
        return alist;
    }
    
    /**
     * effect: build a arrayList of color with the tree's order
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @return the arrayList of color of Btree.
     */
    public ArrayList<String> buildList2() {
        ArrayList<String> alist = new ArrayList<String>();
        alist.add(this.color);
        alist.addAll(this.left.buildList2());
        alist.addAll(this.right.buildList2());
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

    public boolean contains(T s) {
        if (comp.compare(data, s) < 0) {
            return this.right.contains(s);
        }
        if (comp.compare(data, s) > 0) {
            return this.left.contains(s);
        }
        else {
            return true;
        }
            
    }

    /**
     * balancing the tree with the Red-Black tree's rule
     * 
     * @return balanced tree
     */
    public RBTree<T> balance() {

        if ((!this.left.isLeaf()) && (!this.left.getLeft().isLeaf())
                && this.left.getColor().equals("red")
                && this.left.getLeft().getColor().equals("red")) {
            return new Node<T>(this.left.getData(), this.left.getLeft()
                    .blackT(), new Node<T>(this.data, this.left.getRight(),
                        this.right, comp, "black"), comp, "red");
        }

        if ((!this.left.isLeaf()) && (!this.left.getRight().isLeaf())
                && this.left.getColor().equals("red")
                && this.left.getRight().getColor().equals("red")) {
            return new Node<T>(this.left.getRight().getData(), new Node<T>(
                    this.left.getData(), this.left.getLeft(), this.left
                        .getRight().getLeft(), comp, "black"), new Node<T>(
                            this.data, 
                                this.left.getRight().getRight(), this.right,
                                    comp, "black"), comp, "red");
        }

        if ((!this.right.isLeaf()) && (!this.right.getLeft().isLeaf())
                && this.right.getColor().equals("red")
                && this.right.getLeft().getColor().equals("red")) {
            return new Node<T>(this.right.getLeft().getData(), new Node<T>(
                    this.data, this.left, this.right.getLeft().getLeft(), comp,
                        "black"),
                            new Node<T>(this.right.getData(),
                                this.right.getLeft()
                                    .getRight(),
                                        this.right.getRight(), comp, "black"),
                                            comp, "red");
        }

        if ((!this.right.isLeaf()) && (!this.right.getRight().isLeaf())
                && this.right.getColor().equals("red")
                && this.right.getRight().getColor().equals("red")) {
            return new Node<T>(this.right.getData(), new Node<T>(this.data,
                    this.left, this.right.getLeft(), comp, "black"), this.right
                        .getRight().blackT(), comp, "red");
        }

        else {
            return this;
        }

    }

    /**
     * getting the data of RBT
     * 
     * @return the data of the RBT
     */
    public T getData() {
        return this.data;
    }

    /**
     * getting the left of RBT
     * 
     * @return the left child of RBT
     */
    public RBTree<T> getLeft() {
        return this.left;
    }

    /**
     * getting the right of RBT
     * 
     * @return the right child of RBT
     */
    public RBTree<T> getRight() {
        return this.right;
    }

    /**
     * getting the color of RBT
     * 
     * @return the color of this RBT
     */
    public String getColor() {
        return this.color;
    }

    /**
     * making the RBT into black color
     * 
     * @return the RBT changed into black color
     */
    public RBTree<T> blackT() {
        return new Node<T>(
                this.data, this.left, this.right, this.comp, "black");
    }

    /**
     * repOk check everything is valid
     * 
     * @author Shiyu
     * @version 2013-10-8
     * @return boolean checking everything is valid
     */
    public boolean repOK() {
        // every node is either red or black
        if (!this.color.equals("red") && !this.color.equals("black")) {
            return false;
        }
        // there is no duplicate
        if (this.hasDup()) {
            return false;
        }
       //it is a balanced 
        if (!this.equals(this.balance())) {
            return false;
        }
        // for each node, all simple path from the node to descendant leaves
        // contains same number of black nodes
        if (this.maxBlack() != this.minBlack()) {
            return false;
        }
        // if the node is red, then both its children are black,
        if (this.color.equals("red") && !this.left.isLeaf()
                && !this.right.isLeaf()) {
            return this.left.getColor().equals("black")
                    && this.right.getColor().equals("black")
                    && this.left.repOK() && this.right.repOK();

        }
        // check it's child is repOK
        else {
            return this.left.repOK() && this.right.repOK();
        }

    }

    /**
     * check if there is no duplicates of this RBT
     * 
     * @return true if there is no duplicates
     */
    public boolean hasDup() {
        ArrayList<T> l = this.buildList();
        while (!l.isEmpty()) {
            if (l.contains(l.remove(0))) {
                return true;
            }
        }
        return false;
    }

    /**
     * count the number of black nodes in the max path
     * 
     * @return the number of black nodes in the max path
     */
    public int maxBlack() {
        if (this.color.equals("black")) {
            return 1 + Math.max(left.maxBlack(), right.maxBlack());
        } 
        else {
            return 0 + Math.max(left.maxBlack(), right.maxBlack());
        }
    }

    /**
     * count the number of black nodes in the min path
     * 
     * @return the number of black nodes in the min path
     */
    public int minBlack() {
        if (this.color.equals("black")) {
            return 1 + Math.min(left.minBlack(), right.minBlack());
        } 
        else {
            return 0 + Math.min(left.minBlack(), right.minBlack());
        }
    }
    
    /**
     * accept the visitor that produces the result of the type R
     * @param rv - the visitor
     * @param <R> the output type 
     * @return the result of the type R
     */
    public <R> R accept(RBTreeVisitor<T, R> rv) {
        return rv.visitNode(comp, color, data, left, right);
    }
}