package rbtree;

import java.util.Comparator;

/**
 * A visitor for RBTree
 * @author Shiyu
 * @version 2013-11-10
 * @param <T> the type of data stored in the RBTree
 * @param <R> the type of data produced by the visitor methods
 */
public interface RBTreeVisitor<T, R> {
    /**
     * The method for the empty tree
     * @param comp the Comparator for the whole tree
     * @return some value of the type R
     */
    public R visitLeaf(Comparator<T> comp);
    
    /**
     * The method for the node of the tree
     * @param comp the Comparator for the whole tree
     * @param color the color of the node, which should be "RED"
     *        or "BLACK"
     * @param data the label/value for the node
     * @param left the left subtree of the node
     * @param right the right subtree of the node
     * @return some value of the type R
     */
    public R visitNode(Comparator<T> comp, String color, T data, 
                     RBTree<T> left, RBTree<T> right);
}













