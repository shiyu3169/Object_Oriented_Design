

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import rbtree.RBTree;
import rbtree.RBTreeVisitor;

/**
 * visitor class of CountNodes
 * @author shiyu
 * @version 2013-11-10
 * @param <T> the type of data stored in the RBTree
 */
public class CountNodes<T> implements  RBTreeVisitor<T, ArrayList<Integer>> {
    /** the arryList used for counting nodes */
    ArrayList<Integer> alist = new ArrayList<Integer>(Arrays.asList(0, 0, 0));
    /**
     * The method for the empty tree
     * @param comp the Comparator for the whole tree
     * @return the PathLength for leaf
     */
    public ArrayList<Integer> visitLeaf(Comparator<T> comp) {
        return alist;
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
    public ArrayList<Integer> visitNode(Comparator<T> comp, String color,
            T data, RBTree<T> left, RBTree<T> right) {
        ArrayList<String> a = RBTree.node(
                data, left, right, comp, color).buildList2();
        int x = 0;
        alist.set(0, a.size());
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals("black")) {
                x++;
            }
        }
        alist.set(1, x);
        alist.set(2, a.size() - x);
        return alist;
    }
}