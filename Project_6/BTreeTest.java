import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import rbtree.*;
import tester.Tester;

/**
 * the tests for BTree
 * 
 * @author Shiyu
 * @version 2013-11-1
 */

public class BTreeTest {

    /** example comparator */
    Comparator<String> c1 = new StringByLength();
    /** example comparator */
    Comparator<String> c2 = new StringByLex();
    
    // Leaf
    /** example Leaf with StrinByLength comparator */
    RBTree                leaf1;
    /** example Leaf with StrinByLex comparator */
    RBTree                leaf2;

    // Node
    /** example Node with StrinByLength comparator */
    RBTree                node1;
    /** example Node with StrinByLength comparator */
    RBTree                node2;
    /** example Node with StrinByLength comparator */
    RBTree                node3;
    /** example Node with StrinByLength comparator */
    RBTree                node4;
    /** example Node with StrinByLength comparator */
    RBTree                node5;

    /** example Node with StrinByLex comparator */
    RBTree                node01;
    /** example Node with StrinByLex comparator */
    RBTree                node02;
    /** example Node with StrinByLex comparator */
    RBTree                node03;
    /** example Node with StrinByLex comparator */
    RBTree                node04;
    /** example Node with StrinByLex comparator */
    RBTree                node05;

    /** example Node with StrinByLength comparator */
    RBTree                node001;

    // BTree
    /** example BTree */
    BTree              bl1;
    /** example BTree */
    BTree              bl2;
    /** example BTree */
    BTree              bn1;
    /** example BTree */
    BTree              bn2;
    /** example BTree */
    BTree              bn3;
    /** example BTree */
    BTree              bn4;

    /** example BTree */
    BTree              bn5;
    /** example BTree */
    BTree              bn01;
    /** example BTree */
    BTree              bn02;
    /** example BTree */
    BTree              bn03;
    /** example BTree */
    BTree              bn04;
    /** example BTree */
    BTree              bn05;
    /** example BTree */
    BTree              bn001;

    /**
     * reset the Leaf/Node/ArrayList
     */
    public void reset() {
        // Leaf
        leaf1 = new Leaf(c1);
        leaf2 = new Leaf(c2);

        // Node
        node1 = new Node("yyyy", 
                new Node("xx", leaf1, leaf1, c1, "black"),
                new Node("zzzzzz", leaf1, leaf1, c1, "black"), c1, "red");
        node2 = RBTree.node("zzzzzz", RBTree.node("yyyy",
                RBTree.node("xx", leaf1, leaf1, c1, "red"), leaf1, c1, "red"),
                leaf1, c1, "black");
        node3 = RBTree.node("zzzzzz", RBTree.node("xx", leaf1,
                RBTree.node("yyyy",
                        leaf1, leaf1, c1, "red"), c1, "red"), leaf1,
                c1, "black");
        node4 = RBTree.node("xx", leaf1, RBTree.node("zzzzzz",
                RBTree.node("yyyy",
                        leaf1, leaf1, c1, "red"), leaf1, c1, "red"),
                c1, "black");
        node5 = RBTree
                .node("xx", leaf1,
                        RBTree.node("yyyy", leaf1,
                                RBTree.node("zzzzzz", leaf1, leaf1, c1, "red"),
                                c1, "red"), c1, "black");
        node001 = RBTree.node("yyyy",
                RBTree.node("xx", leaf1, leaf1, c1, "black"),
                RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1, "red");
        node01 = RBTree.node("d", RBTree.node("b", leaf2, leaf2, c2, "black"),
                RBTree.node("f", leaf2, leaf2, c2, "black"), c2, "red");
        node02 = RBTree.node("f", RBTree.node("d",
                RBTree.node("b", leaf2, leaf2, c2, "red"), leaf2, c2, "red"),
                leaf2, c2, "black");
        node03 = RBTree.node("f", RBTree.node("b", leaf2,
                RBTree.node("d",
                        leaf2, leaf2, c2, "red"), c2, "red"), leaf2, c2,
                "black");
        node04 = RBTree.node("b", leaf2, RBTree.node("f",
                RBTree.node("d",
                        leaf2, leaf2, c2, "red"), leaf2, c2, "red"), c2,
                "black");
        node05 = RBTree
                .node("b", leaf2, RBTree.node("d", leaf2,
                        RBTree.node("f",
                                leaf2, leaf2, c2, "red"), c2, "red"), c2,
                        "black");

        // BTree
        bl1 = new BTree(leaf1);
        bl2 = new BTree(leaf2);
        bn1 = new BTree(node1);
        bn2 = new BTree(node2);
        bn3 = new BTree(node3);
        bn4 = new BTree(node4);
        bn5 = new BTree(node5);
        bn01 = new BTree(node01);
        bn02 = new BTree(node02);
        bn03 = new BTree(node03);
        bn04 = new BTree(node04);
        bn05 = new BTree(node05);
        bn001 = new BTree(node001);

    }
    /**
     * testing all methods in BTree 
     * @param t - tester
     */
    public void testBTree(Tester t) {
        // binTree
        reset();
        t.checkExpect(BTree.binTree(c1), bl1);
        t.checkExpect(BTree.binTree(c2), bl2);

        // toString
        t.checkExpect(bl1.toString(), "");
        t.checkExpect(bn1.toString(), "xx, yyyy, zzzzzz");
        t.checkExpect(bn2.toString(), "xx, yyyy, zzzzzz");
        t.checkExpect(bn3.toString(), "xx, yyyy, zzzzzz");
        t.checkExpect(bn4.toString(), "xx, yyyy, zzzzzz");
        t.checkExpect(bn5.toString(), "xx, yyyy, zzzzzz");
        t.checkExpect(bn01.toString(), "b, d, f");
        t.checkExpect(bn02.toString(), "b, d, f");
        t.checkExpect(bn03.toString(), "b, d, f");
        t.checkExpect(bn04.toString(), "b, d, f");
        t.checkExpect(bn05.toString(), "b, d, f");

        // equals
        t.checkExpect(bl1.equals(bl1), true);
        t.checkExpect(bl1.equals(bl2), true);
        t.checkExpect(bl1.equals(bn1), false);
        t.checkExpect(bn1.equals(bl1), false);
        t.checkExpect(bn1.equals(bn1), true);
        t.checkExpect(bn1.equals(bn2), false);
        t.checkExpect(bn1.equals(bn01), false);
        t.checkExpect(bn1.equals(bn001), true);
        t.checkExpect(bl1.equals("1"), false);

        // hashCode
        t.checkExpect(bl1.hashCode(), 123);
        t.checkExpect(bl2.hashCode(), 123);
        t.checkExpect(bn1.hashCode(), -494305925);
        t.checkExpect(bn2.hashCode(), -588012019);
        t.checkExpect(bn01.hashCode(), 187751335);
        t.checkExpect(bn02.hashCode(), 94045241);
        t.checkExpect(bn001.hashCode(), -494305925);
        

        // contains
        t.checkExpect(bl1.contains("a"), false);
        t.checkExpect(bl2.contains("a"), false);
        t.checkExpect(bn1.contains("a"), false);
        t.checkExpect(bn01.contains("a"), false);
        t.checkExpect(bn1.contains("xx"), true);
        t.checkExpect(bn1.contains("yyyy"), true);
        t.checkExpect(bn1.contains("zzzzzz"), true);
        t.checkExpect(bn01.contains("b"), true);
        t.checkExpect(bn01.contains("d"), true);
        t.checkExpect(bn01.contains("f"), true);

        // repOK
        t.checkExpect(bl1.repOK(), true);
        t.checkExpect(bl2.repOK(), true);
        t.checkExpect(bn1.repOK(), false);
        t.checkExpect(bn01.repOK(), false);
        t.checkExpect(bn2.repOK(), false);
        t.checkExpect(bn3.repOK(), false);
        t.checkExpect(bn4.repOK(), false);
        t.checkExpect(bn5.repOK(), false);
        t.checkExpect(bn02.repOK(), false);
        t.checkExpect(bn03.repOK(), false);
        t.checkExpect(bn04.repOK(), false);
        t.checkExpect(bn05.repOK(), false);
        t.checkExpect(new BTree(node1.blackT()).repOK(), true);
        t.checkExpect(new BTree(node01.blackT()).repOK(), true);

        // hasNext/Next
        t.checkExpect(bl1.iterator().hasNext(), false);
        t.checkExpect(bl2.iterator().hasNext(), false);
        t.checkExpect(bn1.iterator().hasNext(), true);
        t.checkExpect(bn2.iterator().hasNext(), true);
        t.checkExpect(bn01.iterator().hasNext(), true);

        t.checkException(new NoSuchElementException("next when no hasNext"),
                bl1.iterator(), "next");
        t.checkException(new NoSuchElementException("next when no hasNext"),
                bl2.iterator(), "next");
        Iterator<String> it = bn1.iterator();
        t.checkExpect(it.hasNext(), true);
        t.checkExpect(it.next(), "xx");
        t.checkExpect(it.next(), "yyyy");
        t.checkExpect(it.next(), "zzzzzz");
        t.checkExpect(it.hasNext(), false);
        
        bn01.bad = true;
        Iterator<String> it2 = bn01.iterator();
        t.checkException(new ConcurrentModificationException(
                "next on a bad iterator"),
                it2, "next");
        bn01.bad = false;
        
        t.checkExpect(new BTree(null).iterator().hasNext(), false);
        
        
        //remove
        t.checkException(new UnsupportedOperationException("remove"),
                bn1.iterator(), "remove");

        // add
        bl1.add("x");
        bl2.add("x");
        t.checkExpect(bl1, 
                new BTree(RBTree.node("x", leaf1, leaf1, c1, "red")));
        t.checkExpect(bl2, 
                new BTree(RBTree.node("x", leaf2, leaf2, c2, "red")));
        reset();
        bn1.add("xx");
        t.checkExpect(
                bn1,
                new BTree(RBTree.node("yyyy",
                        RBTree.node("xx", leaf1, leaf1, c1, "black"),
                        RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1,
                        "red")));
        bn1.add("yyyy");
        t.checkExpect(
                bn1,
                new BTree(RBTree.node("yyyy",
                        RBTree.node("xx", leaf1, leaf1, c1, "black"),
                        RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1,
                        "red")));
        bn1.add("zzzzzz");
        t.checkExpect(
                bn1,
                new BTree(RBTree.node("yyyy",
                        RBTree.node("xx", leaf1, leaf1, c1, "black"),
                        RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1,
                        "red")));
        bn1.add("aaaaaaa");
        t.checkExpect(
                bn1,
                new BTree(RBTree.node(
                        "yyyy", RBTree.node("xx", leaf1, leaf1, c1,
                        "black"), RBTree.node("zzzzzz", leaf1,
                        RBTree.node("aaaaaaa", leaf1, leaf1, c1, "red"), c1,
                        "black"), c1, "red")));
        reset();
        bn1.add("aaaaa");
        t.checkExpect(
                bn1,
                new BTree(RBTree.node(
                        "yyyy", RBTree.node("xx", leaf1, leaf1, c1,
                        "black"), RBTree.node("zzzzzz",
                        RBTree.node(
                                "aaaaa", leaf1, leaf1, c1, "red"), leaf1, c1,
                        "black"), c1, "red")));
        reset();
        bn1.add("aaa");
        t.checkExpect(
                bn1,
                new BTree(RBTree.node("yyyy", RBTree.node("xx", leaf1,
                        RBTree.node(
                                "aaa", leaf1, leaf1, c1, "red"), c1, "black"),
                        RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1,
                        "red")));
        reset();
        bn1.add("a");
        t.checkExpect(
                bn1,
                new BTree(RBTree.node("yyyy", RBTree.node("xx",
                        RBTree.node("a", leaf1, leaf1, c1, "red"), leaf1, c1,
                        "black"),
                        RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1,
                        "red")));
        reset();
        bn01.add("g");
        t.checkExpect(
                bn01,
                new BTree(RBTree.node("d", RBTree
                        .node("b", leaf2, leaf2, c2, "black"), RBTree.node("f",
                        leaf2, RBTree.node("g", leaf2, leaf2, c2, "red"), c2,
                        "black"), c2, "red")));
        reset();
        bn01.add("e");
        t.checkExpect(
                bn01,
                new BTree(RBTree.node("d", RBTree
                        .node("b", leaf2, leaf2, c2, "black"), RBTree.node("f",
                        RBTree.node("e", leaf2, leaf2, c2, "red"), leaf2, c2,
                        "black"), c2, "red")));
        reset();
        bn01.add("c");
        t.checkExpect(
                bn01,
                new BTree(RBTree.node("d", RBTree.node("b", leaf2,
                        RBTree.node("c", leaf2, leaf2, c2, "red"), c2, "black"),
                        RBTree.node(
                                "f", leaf2, leaf2, c2, "black"), c2, "red")));
        reset();
        bn01.add("a");
        t.checkExpect(
                bn01,
                new BTree(RBTree.node("d", RBTree.node("b",
                        RBTree.node("a", leaf2, leaf2, c2, "red"), leaf2, c2,
                        "black"), RBTree.node(
                                "f", leaf2, leaf2, c2, "black"), c2,
                        "red")));
        reset();
        bn2.add("xx");
        t.checkExpect(bn2, bn1);
        reset();
        bn02.add("b");
        t.checkExpect(bn02, bn01);
        reset();
        bn2.add("aaaaaaa");
        t.checkExpect(
                bn2,
                new BTree(RBTree.node(
                        "yyyy", RBTree.node("xx", leaf1, leaf1, c1,
                        "black"), RBTree.node("zzzzzz", leaf1,
                        RBTree.node("aaaaaaa", leaf1, leaf1, c1, "red"), c1,
                        "black"), c1, "red")));
        reset();
        t.checkExpect(bl1.bad, false);
        bl1.active = 0;
        bl1.add("x");
        t.checkExpect(bl1, 
                new BTree(RBTree.node("x", leaf1, leaf1, c1, "red")));
        reset();
        t.checkExpect(bl1.bad, false);
        bl1.active = 1;
        t.checkException(new ConcurrentModificationException(
                "add with active iterator"), bl1, "add", "it");
        bl1.active = 0;
        reset();
        
        // build(iter)
        bl1.build(bn1);
        t.checkExpect(bl1, new BTree(node1.blackT()));
        reset();
        bl2.build(bn02);
        t.checkExpect(bl2, new BTree(node01.blackT()));
        reset();
        bl1.build(bl1);
        t.checkExpect(bl1, bl1);
        reset();

        // build(iter, numStrings)
        bl1.build(bn1, 0);
        t.checkExpect(bl1, BTree.binTree(c1));
        reset();
        bl2.build(bn02, 0);
        t.checkExpect(bl2, BTree.binTree(c2));
        reset();
        bl1.build(bn1, -1);
        t.checkExpect(bl1, new BTree(node1.blackT()));
        reset();
        bl2.build(bn02, -1);
        t.checkExpect(bl2, new BTree(node01.blackT()));
        reset();
        bl1.build(bn1, 5);
        t.checkExpect(bl1, new BTree(node1.blackT()));
        reset();
        bl2.build(bn02, 5);
        t.checkExpect(bl2, new BTree(node01.blackT()));
        reset();

        bl1.build(bn1, 1);
        t.checkExpect(bl1, 
                new BTree(RBTree.node("xx", leaf1, leaf1, c1, "black")));
        reset();
        bl2.build(bn02, 1);
        t.checkExpect(bl2, 
                new BTree(RBTree.node("b", leaf2, leaf2, c2, "black")));
        reset();
        
        bl1.build(bl1, 10);
        t.checkExpect(bl1, bl1);
        reset();
        
        //compare
        t.checkExpect(c1.compare("xx", "xxx"), -1);
        t.checkExpect(c1.compare("xxx", "xxx"), 0);
        t.checkExpect(c1.compare("xxx", "xx"), 1);
        t.checkExpect(c2.compare("a", "b"), -1);
        t.checkExpect(c2.compare("a", "a"), 0);
        t.checkExpect(c2.compare("b", "a"), 1);
    }

}
