package rbtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import tester.*;

/**
 * the example class for RBT and Leaf/Node
 * 
 * @author Shiyu
 * @version 2013-10-31
 * 
 */
public class RBTreeTest {


    // comparator
    /** example comparator */
    Comparator<String> c1 = new MyStringByLength();
    /** example comparator */
    Comparator<String> c2 = new MyStringByLex();
    /** example comparatpr */
    Comparator<Integer> c3 = new MyIntegerComparator();

    // Leaf
    /** example Leaf with StrinByLength comparator */
    RBTree<String> leaf1;
    /** example Leaf with StrinByLex comparator */
    RBTree<String> leaf2;
    /** example Leaf with StrinByLength comparator */
    RBTree<Integer> leaf3;

    // Node
    /** example Node with StrinByLength comparator */
    RBTree<String> node1;
    /** example Node with StrinByLength comparator */
    RBTree<String> node2;
    /** example Node with StrinByLength comparator */
    RBTree<String> node3;
    /** example Node with StrinByLength comparator */
    RBTree<String> node4;
    /** example Node with StrinByLength comparator */
    RBTree<String> node5;

    /** example Node with StrinByLex comparator */
    RBTree<String> node01;
    /** example Node with StrinByLex comparator */
    RBTree<String> node02;
    /** example Node with StrinByLex comparator */
    RBTree<String> node03;
    /** example Node with StrinByLex comparator */
    RBTree<String> node04;
    /** example Node with StrinByLex comparator */
    RBTree<String> node05;

    /** example Node with StrinByLength comparator */
    RBTree<String> node001;

    /** example Node with StrinByLength comparator */
    RBTree<String> node0;

    /** example Node with StrinByLength comparator */
    RBTree<String> node00;

    /** example Node with StrinByLex comparator */
    RBTree<Integer> nod01;
    /** example Node with StrinByLex comparator */
    RBTree<Integer> nod02;
    /** example Node with StrinByLex comparator */
    RBTree<Integer> nod03;
    /** example Node with StrinByLex comparator */
    RBTree<Integer> nod04;
    /** example Node with StrinByLex comparator */
    RBTree<Integer> nod05;

    /** example Node with StrinByLength comparator */
    RBTree<Integer> nod001;

    /** example Node with StrinByLength comparator */
    RBTree<Integer> nod0;

    /** example Node with StrinByLength comparator */
    RBTree<Integer> nod00;

    // ArrayList
    /** example ArrayList */
    ArrayList<String> alist1;
    /** example ArrayList */
    ArrayList<String> alist01;
    /** example ArrayList */
    ArrayList<Integer> list1;

    /**
     * reset the Leaf/Node/ArrayList
     */
    public void reset() {
        // Leaf
        leaf1 = RBTree.leaf(c1);
        leaf2 = RBTree.leaf(c2);
        leaf3 = RBTree.leaf(c3);

        // Node
        node1 = RBTree.node("yyyy",
                RBTree.node("xx", leaf1, leaf1, c1, "black"),
                RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1, "red");
        node2 = RBTree.node("zzzzzz", RBTree.node("yyyy",
                RBTree.node("xx", leaf1, leaf1, c1, "red"), leaf1, c1, "red"),
                leaf1, c1, "black");
        node3 = RBTree.node("zzzzzz", RBTree.node("xx", leaf1,
                RBTree.node("yyyy", leaf1, leaf1, c1, "red"), c1, "red"),
                leaf1, c1, "black");
        node4 = RBTree.node("xx", leaf1,
                RBTree.node("zzzzzz",
                        RBTree.node("yyyy", leaf1, leaf1, c1, "red"), leaf1,
                        c1, "red"), c1, "black");
        node5 = RBTree.node("xx", leaf1, RBTree.node("yyyy", leaf1,
                RBTree.node("zzzzzz", leaf1, leaf1, c1, "red"), c1, "red"), c1,
                "black");
        node001 = RBTree.node("yyyy",
                RBTree.node("xx", leaf1, leaf1, c1, "black"),
                RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1, "red");
        node01 = RBTree.node("d", RBTree.node("b", leaf2, leaf2, c2, "black"),
                RBTree.node("f", leaf2, leaf2, c2, "black"), c2, "red");
        node02 = RBTree.node("f", RBTree.node("d",
                RBTree.node("b", leaf2, leaf2, c2, "red"), leaf2, c2, "red"),
                leaf2, c2, "black");
        node03 = RBTree.node(
                "f",
                RBTree.node("b", leaf2,
                        RBTree.node("d", leaf2, leaf2, c2, "red"), c2, "red"),
                leaf2, c2, "black");
        node04 = RBTree.node("b", leaf2, RBTree.node("f",
                RBTree.node("d", leaf2, leaf2, c2, "red"), leaf2, c2, "red"),
                c2, "black");
        node05 = RBTree.node(
                "b",
                leaf2,
                RBTree.node("d", leaf2,
                        RBTree.node("f", leaf2, leaf2, c2, "red"), c2, "red"),
                c2, "black");

        node0 = RBTree.node("a", RBTree.node("b", leaf2, leaf2, c2, "red"),
                RBTree.node("c", leaf2, leaf2, c2, "red"), c2, "black");

        node00 = RBTree.node("a", leaf2, leaf2, c2, "red");

        nod001 = RBTree.node(2, RBTree.node(1, leaf3, leaf3, c3, "black"),
                RBTree.node(3, leaf3, leaf3, c3, "black"), c3, "red");
        nod01 = RBTree.node(4, RBTree.node(2, leaf3, leaf3, c3, "black"),
                RBTree.node(6, leaf3, leaf3, c3, "black"), c3, "red");
        nod02 = RBTree.node(6, RBTree.node(4,
                RBTree.node(2, leaf3, leaf3, c3, "red"), leaf3, c3, "red"),
                leaf3, c3, "black");
        nod03 = RBTree.node(6, RBTree.node(2, leaf3,
                RBTree.node(4, leaf3, leaf3, c3, "red"), c3, "red"), leaf3, c3,
                "black");
        nod04 = RBTree.node(2, leaf3, RBTree.node(6,
                RBTree.node(4, leaf3, leaf3, c3, "red"), leaf3, c3, "red"), c3,
                "black");
        nod05 = RBTree.node(2, leaf3, RBTree.node(4, leaf3,
                RBTree.node(6, leaf3, leaf3, c3, "red"), c3, "red"), c3,
                "black");

        nod0 = RBTree.node(1, RBTree.node(2, leaf3, leaf3, c3, "red"),
                RBTree.node(3, leaf3, leaf3, c3, "red"), c3, "black");

        nod00 = RBTree.node(1, leaf3, leaf3, c3, "red");

        // ArrayList
        alist1 = new ArrayList<String>();
        alist01 = new ArrayList<String>();
        list1 = new ArrayList<Integer>();
    }

    /**
     * initial the arrayList
     */
    public void initia() {
        alist1.add("xx");
        alist1.add("yyyy");
        alist1.add("zzzzzz");

        alist01.add("b");
        alist01.add("d");
        alist01.add("f");

        list1.add(2);
        list1.add(4);
        list1.add(6);
    }

    /**
     * test all the methods
     * 
     * @param t
     *            tester
     */
    public void testAll(Tester t) {

        // isLeaf
        reset();
        t.checkExpect(leaf1.isLeaf(), true);
        t.checkExpect(leaf2.isLeaf(), true);
        t.checkExpect(leaf3.isLeaf(), true);
        t.checkExpect(node1.isLeaf(), false);
        t.checkExpect(node2.isLeaf(), false);
        t.checkExpect(nod01.isLeaf(), false);
        t.checkExpect(nod02.isLeaf(), false);

        // add
        t.checkExpect(leaf1.add("x"), RBTree.node(
                "x", leaf1, leaf1, c1, "red"));
        t.checkExpect(leaf2.add("x"), RBTree.node(
                "x", leaf2, leaf2, c2, "red"));
        t.checkExpect(leaf3.add(1), RBTree.node(1, leaf3, leaf3, c3, "red"));

        t.checkExpect(node1.add("xx"), node1);
        t.checkExpect(node1.add("yyyy"), node1);
        t.checkExpect(node1.add("zzzzzz"), node1);
        t.checkExpect(node01.add("b"), node01);
        t.checkExpect(node01.add("d"), node01);
        t.checkExpect(node01.add("f"), node01);
        t.checkExpect(nod01.add(2), nod01);
        t.checkExpect(nod01.add(4), nod01);
        t.checkExpect(nod01.add(6), nod01);

        t.checkExpect(node1.add("aaaaaaa"), RBTree.node("yyyy", RBTree.node(
                "xx", leaf1, leaf1, c1, "black"), RBTree.node("zzzzzz", leaf1,
                RBTree.node("aaaaaaa", leaf1, leaf1, c1, "red"), c1, "black"),
                c1, "red"));
        t.checkExpect(node1.add("aaaaa"), RBTree.node("yyyy", RBTree.node("xx",
                leaf1, leaf1, c1, "black"), RBTree.node("zzzzzz",
                RBTree.node("aaaaa", leaf1, leaf1, c1, "red"), leaf1, c1,
                "black"), c1, "red"));
        t.checkExpect(node1.add("aaa"), RBTree.node("yyyy",
                RBTree.node("xx", leaf1,
                        RBTree.node("aaa", leaf1, leaf1, c1, "red"), c1,
                        "black"), RBTree.node("zzzzzz", leaf1, leaf1, c1,
                        "black"), c1, "red"));
        t.checkExpect(node1.add("a"), RBTree.node("yyyy", RBTree.node("xx",
                RBTree.node("a", leaf1, leaf1, c1, "red"), leaf1, c1, "black"),
                RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1, "red"));
        t.checkExpect(node01.add("g"),
                RBTree.node("d", RBTree.node("b", leaf2, leaf2, c2, "black"),
                        RBTree.node("f", leaf2,
                                RBTree.node("g", leaf2, leaf2, c2, "red"), c2,
                                "black"), c2, "red"));
        t.checkExpect(node01.add("e"), RBTree.node("d", RBTree.node("b", leaf2,
                leaf2, c2, "black"), RBTree.node("f",
                RBTree.node("e", leaf2, leaf2, c2, "red"), leaf2, c2, "black"),
                c2, "red"));
        t.checkExpect(node01.add("c"),
                RBTree.node("d",
                        RBTree.node("b", leaf2,
                                RBTree.node("c", leaf2, leaf2, c2, "red"), c2,
                                "black"), RBTree.node("f", leaf2, leaf2, c2,
                                "black"), c2, "red"));
        t.checkExpect(node01.add("a"), RBTree.node("d", RBTree.node("b",
                RBTree.node("a", leaf2, leaf2, c2, "red"), leaf2, c2, "black"),
                RBTree.node("f", leaf2, leaf2, c2, "black"), c2, "red"));

        t.checkExpect(nod01.add(7), RBTree.node(4, RBTree.node(2, leaf3, leaf3,
                c3, "black"), RBTree.node(6, leaf3,
                RBTree.node(7, leaf3, leaf3, c3, "red"), c3, "black"), c3,
                "red"));
        t.checkExpect(nod01.add(5), RBTree.node(4, RBTree.node(2, leaf3, leaf3,
                c3, "black"), RBTree.node(6,
                RBTree.node(5, leaf3, leaf3, c3, "red"), leaf3, c3, "black"),
                c3, "red"));
        t.checkExpect(nod01.add(3), RBTree.node(4, RBTree.node(2, leaf3,
                RBTree.node(3, leaf3, leaf3, c3, "red"), c3, "black"), RBTree
                .node(6, leaf3, leaf3, c3, "black"), c3, "red"));
        t.checkExpect(nod01.add(1), RBTree.node(4, RBTree.node(2,
                RBTree.node(1, leaf3, leaf3, c3, "red"), leaf3, c3, "black"),
                RBTree.node(6, leaf3, leaf3, c3, "black"), c3, "red"));

        // equals
        t.checkExpect(leaf1.equals(leaf1), true);
        t.checkExpect(leaf1.equals(leaf2), true);
        t.checkExpect(leaf1.equals(node1), false);
        t.checkExpect(leaf1.equals(node01), false);
        t.checkExpect(node1.equals(node1), true);
        t.checkExpect(node1.equals(node01), false);
        t.checkExpect(node1.equals(RBTree.node("yyyy",
                RBTree.node("xx", leaf1, leaf1, c1, "black"),
                RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c2, "red")),
                true);
        t.checkExpect(node1.equals(RBTree.node("yyyyy",
                RBTree.node("xx", leaf1, leaf1, c1, "black"),
                RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1, "red")),
                false);
        t.checkExpect(node1.equals(RBTree.node("yyyy",
                RBTree.node("xxx", leaf1, leaf1, c1, "black"),
                RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1, "red")),
                false);
        t.checkExpect(node1.equals(RBTree.node("yyyy",
                RBTree.node("xx", leaf1, leaf1, c1, "black"),
                RBTree.node("zzzzzzz", leaf1, leaf1, c1, "black"), c1, "red")),
                false);
        t.checkExpect(
                node1.equals(RBTree.node("yyyy",
                        RBTree.node("xx", leaf1, leaf1, c1, "black"),
                        RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1,
                        "black")), false);
        t.checkExpect(node1.equals(leaf1), false);
        t.checkExpect(node1.equals(node2), false);
        t.checkExpect(node1.equals(node001), true);
        t.checkExpect(node01.equals(node0), false);
        t.checkExpect(node0.equals(node0), true);
        t.checkExpect(node00.equals("1"), false);

        // hashCode
        t.checkExpect(leaf1.hashCode(), 123);
        t.checkExpect(leaf2.hashCode(), 123);
        t.checkExpect(node1.hashCode(), -494305925);
        t.checkExpect(node2.hashCode(), -588012019);
        t.checkExpect(node01.hashCode(), 187751335);
        t.checkExpect(node02.hashCode(), 94045241);
        t.checkExpect(node001.hashCode(), -494305925);

        // buildList
        t.checkExpect(leaf1.buildList(), alist1);
        t.checkExpect(leaf2.buildList(), alist1);
        initia();
        t.checkExpect(node1.buildList(), alist1);
        t.checkExpect(node2.buildList(), alist1);
        t.checkExpect(node3.buildList(), alist1);
        t.checkExpect(node4.buildList(), alist1);
        t.checkExpect(node5.buildList(), alist1);
        t.checkExpect(node01.buildList(), alist01);
        t.checkExpect(node02.buildList(), alist01);
        t.checkExpect(node03.buildList(), alist01);
        t.checkExpect(node04.buildList(), alist01);
        t.checkExpect(node05.buildList(), alist01);

        // contains
        t.checkExpect(leaf1.contains("a"), false);
        t.checkExpect(leaf1.contains(""), false);
        t.checkExpect(leaf2.contains("a"), false);
        t.checkExpect(leaf2.contains(""), false);
        t.checkExpect(node1.contains("xx"), true);
        t.checkExpect(node1.contains("yyyy"), true);
        t.checkExpect(node1.contains("zzzzzz"), true);
        t.checkExpect(node1.contains("a"), false);
        t.checkExpect(node01.contains("b"), true);
        t.checkExpect(node01.contains("d"), true);
        t.checkExpect(node01.contains("f"), true);
        t.checkExpect(node01.contains("a"), false);

        // balance
        t.checkExpect(leaf1.balance(), leaf1);
        t.checkExpect(leaf2.balance(), leaf2);
        t.checkExpect(node1.balance(), node1);
        t.checkExpect(node2.balance(), node1);
        t.checkExpect(node3.balance(), node1);
        t.checkExpect(node4.balance(), node1);
        t.checkExpect(node5.balance(), node1);
        t.checkExpect(node01.balance(), node01);
        t.checkExpect(node02.balance(), node01);
        t.checkExpect(node03.balance(), node01);
        t.checkExpect(node04.balance(), node01);
        t.checkExpect(node05.balance(), node01);
        t.checkExpect(node0.balance(), node0);
        t.checkExpect(RBTree.node("a", leaf1, leaf1, c1, "black").balance(),
                RBTree.node("a", leaf1, leaf1, c1, "black"));
        t.checkExpect(
                RBTree.node("1", RBTree.node("2", leaf2, leaf2, c2, "red"),
                        leaf2, c2, "red").balance(), RBTree.node("1",
                        RBTree.node("2", leaf2, leaf2, c2, "red"), leaf2, c2,
                        "red"));
        t.checkExpect(
                RBTree.node("1", leaf2,
                        RBTree.node("2", leaf2, leaf2, c2, "red"), c2, "red")
                        .balance(), RBTree.node("1", leaf2,
                        RBTree.node("2", leaf2, leaf2, c2, "red"), c2, "red"));
        // getData
        // Exception leaf1.getData()
        t.checkException(new NoSuchElementException("no data for a leaf"),
                leaf1, "getData");
        // Exception leaf2.getData()
        t.checkException(new NoSuchElementException("no data for a leaf"),
                leaf2, "getData");
        t.checkExpect(node1.getData(), "yyyy");
        t.checkExpect(node2.getData(), "zzzzzz");

        // getLeft
        // Exception leaf1.getLeft()
        t.checkException(
                new NoSuchElementException("no left child for a leaf"), leaf1,
                "getLeft");
        // Exception leaf2.getLeft()
        t.checkException(
                new NoSuchElementException("no left child for a leaf"), leaf2,
                "getLeft");
        t.checkExpect(node1.getLeft(),
                RBTree.node("xx", leaf1, leaf1, c1, "black"));
        t.checkExpect(node2.getLeft(), RBTree.node("yyyy",
                RBTree.node("xx", leaf1, leaf1, c1, "red"), leaf1, c1, "red"));
        t.checkExpect(node4.getLeft(), leaf1);
        // getRight
        // Exception leaf1.getRight()
        t.checkException(
                new NoSuchElementException("no right child for a leaf"), leaf1,
                "getRight");
        // Exception leaf2.getRight()
        t.checkException(
                new NoSuchElementException("no right child for a leaf"), leaf2,
                "getRight");
        t.checkExpect(node1.getRight(),
                RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"));
        t.checkExpect(node2.getRight(), leaf1);
        t.checkExpect(node4.getRight(), RBTree.node("zzzzzz",
                RBTree.node(
                        "yyyy", leaf1, leaf1, c1, "red"), leaf1, c1, "red"));

        // getColor
        // Exception leaf1.getColor()
        t.checkException(new NoSuchElementException("no color for a leaf"),
                leaf1, "getColor");
        // Exception leaf2.getColor()
        t.checkException(new NoSuchElementException("no color for a leaf"),
                leaf2, "getColor");
        t.checkExpect(node1.getColor(), "red");
        t.checkExpect(node2.getColor(), "black");

        // blackT
        // Exception leaf1.blackT()
        t.checkException(new RuntimeException("this is a leaf"), leaf1,
                "blackT");
        // Exception leaf2.blackT()
        t.checkException(new RuntimeException("this is a leaf"), leaf2,
                "blackT");
        t.checkExpect(node1.blackT(), RBTree.node("yyyy",
                RBTree.node("xx", leaf1, leaf1, c1, "black"),
                RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1, "black"));
        t.checkExpect(node2.blackT(), node2);

        // repOK
        t.checkExpect(leaf1.repOK(), true);
        t.checkExpect(leaf2.repOK(), true);
        t.checkExpect(
                RBTree.node("1", RBTree.node("2", leaf2, leaf2, c2, "black"),
                        leaf2, c2, "red").repOK(), false);
        t.checkExpect(RBTree.node(
                "1", leaf1, leaf1, c1, "blue").repOK(), false);
        t.checkExpect(
                RBTree.node("1", RBTree.node("1", leaf2, leaf2, c2, "red"),
                        leaf2, c2, "red").repOK(), false);
        t.checkExpect(node2.repOK(), false);
        t.checkExpect(
                RBTree.node("1", RBTree.node("2", leaf2, leaf2, c2, "black"),
                        leaf2, c2, "black").repOK(), false);
        t.checkExpect(
                RBTree.node("1", RBTree.node("2", leaf2, leaf2, c2, "black"),
                        RBTree.node("3", leaf2, leaf2, c2, "black"), c2, "red")
                        .repOK(), true);
        t.checkExpect(
                RBTree.node("1", RBTree.node("2", leaf2, leaf2, c2, "black"),
                        RBTree.node("3", leaf2, leaf2, c2, "red"), c2, "red")
                        .repOK(), false);
        t.checkExpect(
                RBTree.node("1", RBTree.node("2", leaf2, leaf2, c2, "red"),
                        RBTree.node("3", leaf2, leaf2, c2, "black"), c2, "red")
                        .repOK(), false);
        t.checkExpect(
                RBTree.node("1", RBTree.node("2", leaf2, leaf2, c2, "red"),
                        RBTree.node("3", leaf2, leaf2, c2, "red"), c2, "red")
                        .repOK(), false);
        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2",
                                RBTree.node("2", leaf2, leaf2, c2, "black"),
                                leaf2, c2, "black"),
                        RBTree.node("3", leaf2, leaf2, c2, "black"), c2, "red")
                        .repOK(), false);
        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2", leaf2, leaf2, c2, "black"),
                        RBTree.node("3", leaf2,
                                RBTree.node("2", leaf2, leaf2, c2, "black"),
                                c2, "black"), c2, "red").repOK(), false);
        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2",
                                RBTree.node("5", leaf2, leaf2, c2, "red"),
                                leaf2, c2, "black"),
                        RBTree.node("3", leaf2, leaf2, c2, "black"), c2, "red")
                        .repOK(), true);
        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2", leaf2, leaf2, c2, "black"),
                        RBTree.node("3", leaf2,
                                RBTree.node("5", leaf2, leaf2, c2, "red"), c2,
                                "black"), c2, "red").repOK(), true);
        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2", leaf2, leaf2, c2, "black"),
                        RBTree.node("3", leaf2,
                                RBTree.node("5", leaf2, leaf2, c2, "red"), c2,
                                "black"), c2, "black").repOK(), true);

        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2",
                                RBTree.node("9", leaf2, leaf2, c2, "red"),
                                leaf2, c2, "black"),
                        RBTree.node("3", leaf2,
                                RBTree.node("5", leaf2, leaf2, c2, "red"), c2,
                                "black"), c2, "black").repOK(), true);

        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2",
                                RBTree.node("9", leaf2, leaf2, c2, "r"), leaf2,
                                c2, "black"),
                        RBTree.node("3", leaf2,
                                RBTree.node("5", leaf2, leaf2, c2, "r"), c2,
                                "black"), c2, "black").repOK(), false);

        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2",
                                RBTree.node("9", leaf2, leaf2, c2, "r"), leaf2,
                                c2, "black"),
                        RBTree.node("3", leaf2,
                                RBTree.node("5", leaf2, leaf2, c2, "red"), c2,
                                "black"), c2, "black").repOK(), false);

        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2",
                                RBTree.node("9", leaf2, leaf2, c2, "red"),
                                leaf2, c2, "black"),
                        RBTree.node("3", leaf2,
                                RBTree.node("5", leaf2, leaf2, c2, "r"), c2,
                                "black"), c2, "black").repOK(), false);

        // hasDup
        t.checkExpect(leaf1.hasDup(), false);
        t.checkExpect(leaf2.hasDup(), false);
        t.checkExpect(RBTree.node("r", leaf1, leaf1, c1, "r").hasDup(), false);
        t.checkExpect(
                RBTree.node("r", RBTree.node("r", leaf1, leaf1, c1, "black"),
                        RBTree.node("ra", leaf1, leaf1, c1, "black"), c1,
                        "black").hasDup(), true);
        t.checkExpect(
                RBTree.node("ra", RBTree.node("r", leaf1, leaf1, c1, "black"),
                        RBTree.node("r", leaf1, leaf1, c1, "black"), c1,
                        "black").hasDup(), true);
        t.checkExpect(
                RBTree.node("r", RBTree.node("ra", leaf1, leaf1, c1, "black"),
                        RBTree.node("r", leaf1, leaf1, c1, "black"), c1,
                        "black").hasDup(), true);

        // maxBlack
        t.checkExpect(leaf1.maxBlack(), 0);
        t.checkExpect(leaf2.maxBlack(), 0);
        t.checkExpect(node1.maxBlack(), 1);
        t.checkExpect(node2.maxBlack(), 1);
        t.checkExpect(node3.maxBlack(), 1);
        t.checkExpect(node4.maxBlack(), 1);
        t.checkExpect(node5.maxBlack(), 1);
        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2",
                                RBTree.node("4", leaf1, leaf1, c1, "black"),
                                leaf1, c1, "red"),
                        RBTree.node("3", leaf1, leaf1, c1, "black"), c1,
                        "black").maxBlack(), 2);
        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2", leaf1,
                                RBTree.node("4", leaf1, leaf1, c1, "black"),
                                c1, "red"),
                        RBTree.node("3", leaf1, leaf1, c1, "black"), c1,
                        "black").maxBlack(), 2);
        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2", leaf1, leaf1, c1, "red"),
                        RBTree.node("3",
                                RBTree.node("4", leaf1, leaf1, c1, "black"),
                                leaf1, c1, "black"), c1,
                                "black").maxBlack(), 3);
        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2", leaf1, leaf1, c1, "red"),
                        RBTree.node("3", leaf1,
                                RBTree.node("4", leaf1, leaf1, c1, "black"),
                                c1, "black"), c1, "black").maxBlack(), 3);

        // minBlack
        t.checkExpect(leaf1.minBlack(), 0);
        t.checkExpect(leaf2.minBlack(), 0);
        t.checkExpect(node1.minBlack(), 1);
        t.checkExpect(node2.minBlack(), 1);
        t.checkExpect(node3.minBlack(), 1);
        t.checkExpect(node4.minBlack(), 1);
        t.checkExpect(node5.minBlack(), 1);
        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2",
                                RBTree.node("4", leaf1, leaf1, c1, "black"),
                                leaf1, c1, "red"),
                        RBTree.node("3", leaf1, leaf1, c1, "black"), c1,
                        "black").minBlack(), 1);
        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2", leaf1,
                                RBTree.node("4", leaf1, leaf1, c1, "black"),
                                c1, "red"),
                        RBTree.node("3", leaf1, leaf1, c1, "black"), c1,
                        "black").minBlack(), 1);
        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2", leaf1, leaf1, c1, "red"),
                        RBTree.node("3",
                                RBTree.node("4", leaf1, leaf1, c1, "black"),
                                leaf1, c1, "black")
                                , c1, "black").minBlack(), 1);
        t.checkExpect(
                RBTree.node(
                        "1",
                        RBTree.node("2", leaf1, leaf1, c1, "red"),
                        RBTree.node("3", leaf1,
                                RBTree.node("4", leaf1, leaf1, c1, "black"),
                                c1, "black"), c1, "black").minBlack(), 1);

        // compare
        t.checkExpect(c1.compare("xx", "xxx"), -1);
        t.checkExpect(c1.compare("xxx", "xxx"), 0);
        t.checkExpect(c1.compare("xxx", "xx"), 1);
        t.checkExpect(c2.compare("a", "b"), -1);
        t.checkExpect(c2.compare("a", "a"), 0);
        t.checkExpect(c2.compare("b", "a"), 1);


        // buildList2
        t.checkExpect(leaf1.buildList2(), new ArrayList<String>());
        t.checkExpect(node1.buildList2(),
                new ArrayList<String>(Arrays.asList("red", "black", "black")));
        t.checkExpect(node2.buildList2(),
                new ArrayList<String>(Arrays.asList("black", "red", "red")));
        t.checkExpect(node3.buildList2(),
                new ArrayList<String>(Arrays.asList("black", "red", "red")));
        t.checkExpect(node4.buildList2(),
                new ArrayList<String>(Arrays.asList("black", "red", "red")));
    }
}
