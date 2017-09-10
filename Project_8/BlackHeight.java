

import java.util.Comparator;

import rbtree.RBTree;
import rbtree.RBTreeVisitor;

/**
 * visitor class of BlackHeight
 * @author shiyu
 * @version 2013-11-10
 * @param <T> the type of data stored in the RBTree
 */
public class BlackHeight<T> implements RBTreeVisitor<T, Integer> {
    
    /**
     * The method for the empty tree
     * @param comp the Comparator for the whole tree
     * @return the PathLength for leaf
     */
    public Integer visitLeaf(Comparator<T> comp) {
        return 0;
    }
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
    public Integer visitNode(Comparator<T> comp, String color, T data,
            RBTree<T> left, RBTree<T> right) {
        if (color.equals("black")) {
            return 1 + Math.max(left.accept(this), right.accept(this));
        }
        
        else {
            return 0 + Math.max(left.accept(this), right.accept(this));
        }
    }
    
}
