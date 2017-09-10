import java.util.Comparator;
import java.util.Iterator;

import rbtree.RBTree;
import tester.Tester;

/**Shiyu Wang
 * shiyu@ccs.neu.edu
 * 
 */

/**
 * @author Shiyu
 * @version 2013-10-10 the examples and tests for BTree
 */
public class Time {
    /** the example comparator of StringByLex */
    Comparator<String> c1  = new StringByLex();
    /** the example comparator of StringReverseByLex */
    Comparator<String> c2  = new StringReverseByLex();
    /** the example comparator of StringWithOutPrefixByLex */
    Comparator<String> c3  = new StringWithOutPrefixByLex();

    /** the example Leaf which has comparator as c1 defined above */
    RBTree<String>                 bt1 = RBTree.leaf(c1);
    /** the example Leaf which has comparator as c2 defined above */
    RBTree<String>                 bt2 = RBTree.leaf(c2);
    /** the example Leaf which has comparator as c3 defined above */
    RBTree<String>                 bt3 = RBTree.leaf(c3);

    /** the example BTree with BT bt1 defined above */
    BTree<String>              b1  = new BTree<String>(bt1);
    /** the example BTree with BT bt2 defined above */
    BTree<String>              b2  = new BTree<String>(bt2);
    /** the example BTree with BT bt3 defined above */
    BTree<String>              b3  = new BTree<String>(bt3);
    
    /**
     * reset the used BTree and BT
     * 
     */
    public void reset() {
        bt1 = RBTree.leaf(c1);
        bt2 = RBTree.leaf(c2);
        bt3 = RBTree.leaf(c3);
        b1 = new BTree<String>(bt1);
        b2 = new BTree<String>(bt2);
        b3 = new BTree<String>(bt3);
    }
    
    /**
     * checks the time for build, contain and iterator, print out the time we
     * use.
     * @param <T>
     * 
     * @param s
     *            - the file we are using
     * @param n
     *            - the number of words we are using to build tree
     * @param b
     *            - the BTree we apply with the required BT of comparator
     */
    
    public void time(BTree<String> b, String s, int n) {
        /** the collection of the txt file */
        StringIterator sit = new StringIterator(s);
        /** the time before the build */
        long begin = System.currentTimeMillis();
        /** build the BTree */
        b.build(sit, n);
        /** the time after build method */
        long end = System.currentTimeMillis();
        /** the iterator of the BTree */
        Iterator<String> it = b.iterator();
        /** count the size iterated */
        int size = 0;
        /** the time before the "iterator" method */
        long begin2 = System.currentTimeMillis();

        /** while loops for iterator over */
        while (it.hasNext()) {
            it.next();
            size++;
        }

        /** the time after the "iterator" method */
        long end2 = System.currentTimeMillis();
        /** the collection of the contains.txt file */
        StringIterator cit = new StringIterator("contains.txt");
        /** the time before the contain method */
        long begin3 = System.currentTimeMillis();
        /** the contain method for 100 words in contains.txt */
        for (String w : cit) {
            b.contains(w);
        }
        /** the time after contain method */
        long end3 = System.currentTimeMillis();
        /** print the required statements */
        System.out.println(b.rbt.comp + "\t" + s

            + "\t" + n + "\t" + size + "\t"

            + (end - begin) + "\t" + (end2 - begin2)

            + "\t" + (end3 - begin3));

    }
    /**
     * checks the time of classic file for build,
     *  contain and iterator, print out the time we
     * use.
     * @param <T>
     * 
     * @param s
     *            - the file we are using
     * @param b
     *            - the BTree we apply with the required BT of comparator
     */
    public void cTime(BTree<String> b, String s) {
        /** the collection of the txt file */
        StringIterator sit = new StringIterator(s);
        /** the time before the build */
        long begin = System.currentTimeMillis();
        /** build the BTree */
        b.build(sit);
        /** the time after build method */
        long end = System.currentTimeMillis();
        /** the iterator of the BTree */
        Iterator<String> it = b.iterator();
        /** count the size iterated */
        int size = 0;
        /** the time before the "iterator" method */
        long begin2 = System.currentTimeMillis();
        /** the iterator method */
        while (it.hasNext()) {
            it.next();
            size++;
        }
        /** the time after the "iterator" method */
        long end2 = System.currentTimeMillis();
        /** the collection of the contains.txt file */
        StringIterator cit = new StringIterator("contains.txt");
        /** the time before the contain method */
        long begin3 = System.currentTimeMillis();
        /** the contain method for 100 words in contains.txt */
        for (String w : cit) {
            b.contains(w);
        }
        /** the time after contain method */
        long end3 = System.currentTimeMillis();
        /** print the required statements */
        System.out.println(b.rbt.comp + "\t" + s

            + "\t" + size + "\t"

            + (end - begin) + "\t" + (end2 - begin2)

            + "\t" + (end3 - begin3));

    }

    /**
     * testing on list of words
     * 
     * @param t
     *            - Tester
     */
    public void testTime(Tester t) {
        time(b1, "lexicographically_ordered.txt", 2000);
        reset();
        time(b1, "lexicographically_ordered.txt", 4000);
        reset();
        time(b1, "lexicographically_ordered.txt", 8000);
        reset();
        time(b1, "lexicographically_ordered.txt", 16000);
        reset();
        time(b1, "lexicographically_ordered.txt", 20000);
        reset();
        time(b1, "lexicographically_ordered.txt", 24000);
        reset();

        time(b2, "lexicographically_ordered.txt", 2000);
        reset();
        time(b2, "lexicographically_ordered.txt", 4000);
        reset();
        time(b2, "lexicographically_ordered.txt", 8000);
        reset();
        time(b2, "lexicographically_ordered.txt", 16000);
        reset();
        time(b2, "lexicographically_ordered.txt", 20000);
        reset();
        time(b2, "lexicographically_ordered.txt", 24000);
        reset();

        time(b3, "lexicographically_ordered.txt", 2000);
        reset();
        time(b3, "lexicographically_ordered.txt", 4000);
        reset();
        time(b3, "lexicographically_ordered.txt", 8000);
        reset();
        time(b3, "lexicographically_ordered.txt", 16000);
        reset();
        time(b3, "lexicographically_ordered.txt", 20000);
        reset();
        time(b3, "lexicographically_ordered.txt", 24000);
        reset();

        time(b1, "reverse_ordered.txt", 2000);
        reset();
        time(b1, "reverse_ordered.txt", 4000);
        reset();
        time(b1, "reverse_ordered.txt", 8000);
        reset();
        time(b1, "reverse_ordered.txt", 16000);
        reset();
        time(b1, "reverse_ordered.txt", 20000);
        reset();
        time(b1, "reverse_ordered.txt", 24000);
        reset();

        time(b2, "reverse_ordered.txt", 2000);
        reset();
        time(b2, "reverse_ordered.txt", 4000);
        reset();
        time(b2, "reverse_ordered.txt", 8000);
        reset();
        time(b2, "reverse_ordered.txt", 16000);
        reset();
        time(b2, "reverse_ordered.txt", 20000);
        reset();
        time(b2, "reverse_ordered.txt", 24000);
        reset();

        time(b3, "reverse_ordered.txt", 2000);
        reset();
        time(b3, "reverse_ordered.txt", 4000);
        reset();
        time(b3, "reverse_ordered.txt", 8000);
        reset();
        time(b3, "reverse_ordered.txt", 16000);
        reset();
        time(b3, "reverse_ordered.txt", 20000);
        reset();
        time(b3, "reverse_ordered.txt", 24000);
        reset();

        time(b1, "prefix_ordered.txt", 2000);
        reset();
        time(b1, "prefix_ordered.txt", 4000);
        reset();
        time(b1, "prefix_ordered.txt", 8000);
        reset();
        time(b1, "prefix_ordered.txt", 16000);
        reset();
        time(b1, "prefix_ordered.txt", 20000);
        reset();
        time(b1, "prefix_ordered.txt", 24000);
        reset();

        time(b2, "prefix_ordered.txt", 2000);
        reset();
        time(b2, "prefix_ordered.txt", 4000);
        reset();
        time(b2, "prefix_ordered.txt", 8000);
        reset();
        time(b2, "prefix_ordered.txt", 16000);
        reset();
        time(b2, "prefix_ordered.txt", 20000);
        reset();
        time(b2, "prefix_ordered.txt", 24000);
        reset();

        time(b3, "prefix_ordered.txt", 2000);
        reset();
        time(b3, "prefix_ordered.txt", 4000);
        reset();
        time(b3, "prefix_ordered.txt", 8000);
        reset();
        time(b3, "prefix_ordered.txt", 16000);
        reset();
        time(b3, "prefix_ordered.txt", 20000);
        reset();
        time(b3, "prefix_ordered.txt", 24000);
        reset();

        time(b1, "random_order.txt", 2000);
        reset();
        time(b1, "random_order.txt", 4000);
        reset();
        time(b1, "random_order.txt", 8000);
        reset();
        time(b1, "random_order.txt", 16000);
        reset();
        time(b1, "random_order.txt", 20000);
        reset();
        time(b1, "random_order.txt", 24000);
        reset();

        time(b2, "random_order.txt", 2000);
        reset();
        time(b2, "random_order.txt", 4000);
        reset();
        time(b2, "random_order.txt", 8000);
        reset();
        time(b2, "random_order.txt", 16000);
        reset();
        time(b2, "random_order.txt", 20000);
        reset();
        time(b2, "random_order.txt", 24000);
        reset();

        time(b3, "random_order.txt", 2000);
        reset();
        time(b3, "random_order.txt", 4000);
        reset();
        time(b3, "random_order.txt", 8000);
        reset();
        time(b3, "random_order.txt", 16000);
        reset();
        time(b3, "random_order.txt", 20000);
        reset();
        time(b3, "random_order.txt", 24000);
        reset();

    }

    /**
     * Testing on classical literature:
     * 
     * @param t
     *            - tester
     */
    public void testCtime(Tester t) {
        cTime(b1, "iliad.txt");
        reset();
        cTime(b2, "iliad.txt");
        reset();
        cTime(b3, "iliad.txt");
        reset();

        cTime(b1, "hippooath_DUPLICATES.txt");
        reset();
        cTime(b2, "hippooath_DUPLICATES.txt");
        reset();
        cTime(b3, "hippooath_DUPLICATES.txt");
        reset();
    }
}