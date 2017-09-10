package rbtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * the class Node that represents the non-empty binaryTree
 * 
 * @author Shiyu
 * @version 2013-10-8
 */
public class Node extends RBTree {

    /** the String of this node */
    String data;
    /** left child of this Node */
    RBTree    left;
    /** right child of this Node */
    RBTree    right;
    /** the color of this Node */
    String color;

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
     * @param color
     *            - the color of this Npde, either red/black
     */
    public Node(String data, RBTree left, RBTree right,
            Comparator<String> comp, String color) {
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
    public RBTree add(String it) {
        if (comp.compare(this.data, it) > 0) {
            return new Node(this.data, left.add(it), this.right, comp, color)
                    .balance();
        }
        if (comp.compare(this.data, it) < 0) {
            return new Node(this.data, this.left, right.add(it), comp, color)
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

    /**
     * balancing the tree with the Red-Black tree's rule
     * 
     * @return balanced tree
     */
    public RBTree balance() {

        if ((!this.left.isLeaf()) 
                && (!this.left.getLeft().isLeaf())
                && this.left.getColor().equals("red")
                && this.left.getLeft().getColor().equals("red")) {
            return new Node(this.left.getData(), this.left.getLeft().blackT(),
                    new Node(this.data, this.left.getRight(), this.right, comp,
                            "black"), comp, "red");
        }

        if ((!this.left.isLeaf()) 
                && (!this.left.getRight().isLeaf())
                && this.left.getColor().equals("red")
                && this.left.getRight().getColor().equals("red")) {
            return new Node(this.left.getRight().getData(), new Node(
                    this.left.getData(), this.left.getLeft(), this.left
                            .getRight().getLeft(), comp, "black"), new Node(
                                this.data, this.left.getRight().getRight(), 
                                this.right,
                                comp, "black"), comp, "red");
        }

        if ((!this.right.isLeaf()) && (!this.right.getLeft().isLeaf())
                && this.right.getColor().equals("red")
                && this.right.getLeft().getColor().equals("red")) {
            return new Node(this.right.getLeft().getData(), new Node(this.data,
                    this.left, this.right.getLeft().getLeft(), comp, "black"),
                    new Node(this.right.getData(), this.right.getLeft()
                            .getRight(), this.right.getRight(), comp, "black"),
                    comp, "red");
        }

        if ((!this.right.isLeaf()) && (!this.right.getRight().isLeaf())
                && this.right.getColor().equals("red")
                && this.right.getRight().getColor().equals("red")) {
            return new Node(this.right.getData(), new Node(this.data,
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
    public String getData() {
        return this.data;
    }

    /**
     * getting the left of RBT
     * 
     * @return the left child of RBT
     */
    public RBTree getLeft() {
        return this.left;
    }

    /**
     * getting the right of RBT
     * 
     * @return the right child of RBT
     */
    public RBTree getRight() {
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
    public RBTree blackT() {
        return new Node(this.data, this.left, this.right, this.comp, "black");
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
        ArrayList<String> l = this.buildList();
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
}