import java.util.ArrayList;
import java.util.Arrays;
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
   //comparator
    /** example comparator */
    Comparator<String> c1 = new StringByLength();
    /** example comparator */
    Comparator<String> c2 = new StringByLex();
    /** example comparatpr */
    Comparator<Integer> c3 = new IntegerComparator();
    
    // visitor
    /** example visitor */
    RBTreeVisitor<String, ArrayList<Integer>>
    pathLengths = new PathLengths<String>();
    /** example visitor */
    RBTreeVisitor<String, ArrayList<Integer>>
    pathLengths2 = new PathLengths<String>();
    /** example visitor */
    RBTreeVisitor<String, ArrayList<Integer>>
    pathLengths3 = new PathLengths<String>();
    /** example visitor */
    RBTreeVisitor<String, Integer> height = new Height<String>();
    /** example visitor */
    RBTreeVisitor<String, Integer> blackHeight = new BlackHeight<String>();
    /** example visitor */
    RBTreeVisitor<String, ArrayList<Integer>>
    countNodes = new CountNodes<String>();
    
    // Leaf
    /** example Leaf with StrinByLength comparator */
    RBTree<String>                leaf1;
    /** example Leaf with StrinByLex comparator */
    RBTree<String>                leaf2;
    /** example Leaf with StrinByLength comparator */
    RBTree<Integer>                leaf3;

    // Node
    /** example Node with StrinByLength comparator */
    RBTree<String>                node1;
    /** example Node with StrinByLength comparator */
    RBTree<String>                node2;
    /** example Node with StrinByLength comparator */
    RBTree<String>                node3;
    /** example Node with StrinByLength comparator */
    RBTree<String>                node4;
    /** example Node with StrinByLength comparator */
    RBTree<String>                node5;

    /** example Node with StrinByLex comparator */
    RBTree<String>                node01;
    /** example Node with StrinByLex comparator */
    RBTree<String>                node02;
    /** example Node with StrinByLex comparator */
    RBTree<String>                node03;
    /** example Node with StrinByLex comparator */
    RBTree<String>                node04;
    /** example Node with StrinByLex comparator */
    RBTree<String>                node05;

    /** example Node with StrinByLength comparator */
    RBTree<String>                node001;
    
    /** example Node with StrinByLex comparator */
    RBTree<Integer>                nod01;
    /** example Node with StrinByLex comparator */
    RBTree<Integer>                nod02;
    /** example Node with StrinByLex comparator */
    RBTree<Integer>                nod03;
    /** example Node with StrinByLex comparator */
    RBTree<Integer>                nod04;
    /** example Node with StrinByLex comparator */
    RBTree<Integer>                nod05;
    /** example Node with StrinByLength comparator */
    RBTree<Integer>                nod001;
    
    /** example Node with StrinByLength comparator */
    RBTree<Integer>                nod0;
    
    /** example Node with StrinByLength comparator */
    RBTree<Integer>                nod00;
    
    
    // BTree
    /** example BTree */
    BTree<String>              bl1;
    /** example BTree */
    BTree<String>              bl2;
    /** example BTree */
    BTree<Integer>              bl3;
    /** example BTree */
    BTree<String>              bn1;
    /** example BTree */
    BTree<String>              bn2;
    /** example BTree */
    BTree<String>              bn3;
    /** example BTree */
    BTree<String>              bn4;

    /** example BTree */
    BTree<String>              bn5;
    /** example BTree */
    BTree<String>              bn01;
    /** example BTree */
    BTree<String>              bn02;
    /** example BTree */
    BTree<String>              bn03;
    /** example BTree */
    BTree<String>              bn04;
    /** example BTree */
    BTree<String>              bn05;
    /** example BTree */
    BTree<String>              bn001;
    
    /** example BTree */
    BTree<Integer>              b01;
    /** example BTree */
    BTree<Integer>              b02;
    /** example BTree */
    BTree<Integer>              b03;
    /** example BTree */
    BTree<Integer>              b04;
    /** example BTree */
    BTree<Integer>              b05;
    /** example BTree */
    BTree<Integer>              b001;

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
        nod01 = RBTree.node(4, RBTree.node(2, leaf3, leaf3, c3, "black"),
                RBTree.node(6, leaf3, leaf3, c3, "black"), c3, "red");
        nod02 = RBTree.node(6, RBTree.node(4,
                RBTree.node(2, leaf3, leaf3, c3, "red"), leaf3, c3, "red"),
                leaf3, c3, "black");
        nod03 = RBTree.node(6, RBTree.node(2, leaf3,
                RBTree.node(4, 
                        leaf3, leaf3, c3, "red"), c3, "red"), leaf3, c3,
                "black");
        nod04 = RBTree.node(2, leaf3, RBTree.node(6,
                RBTree.node(4, 
                        leaf3, leaf3, c3, "red"), leaf3, c3, "red"), c3,
                "black");
        nod05 = RBTree
                .node(2, leaf3, RBTree.node(4, leaf3,
                        RBTree.node(6,
                                leaf3, leaf3, c3, "red"), c3, "red"), c3,
                        "black");
        
        nod0 = RBTree.node(1, RBTree.node(2, leaf3, leaf3, c3, "red"), 
                    RBTree.node(3, leaf3, leaf3, c3, "red") , c3, "black");
        
        nod00 = RBTree.node(1, leaf3, leaf3, c3, "red");

        // BTree
        bl1 = new BTree<String>(leaf1);
        bl2 = new BTree<String>(leaf2);
        bl3 = new BTree<Integer>(leaf3);
        bn1 = new BTree<String>(node1);
        bn2 = new BTree<String>(node2);
        bn3 = new BTree<String>(node3);
        bn4 = new BTree<String>(node4);
        bn5 = new BTree<String>(node5);
        bn01 = new BTree<String>(node01);
        bn02 = new BTree<String>(node02);
        bn03 = new BTree<String>(node03);
        bn04 = new BTree<String>(node04);
        bn05 = new BTree<String>(node05);
        bn001 = new BTree<String>(node001);
        b01 = new BTree<Integer>(nod01);
        b02 = new BTree<Integer>(nod02);
        b03 = new BTree<Integer>(nod03);
        b04 = new BTree<Integer>(nod04);
        b05 = new BTree<Integer>(nod05);
        b001 = new BTree<Integer>(nod001);
        

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
        t.checkExpect(BTree.binTree(c3), bl3);

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
        
        t.checkExpect(bl3.contains(1), false);
        t.checkExpect(bl3.contains(1), false);
        t.checkExpect(b01.contains(1), false);
        t.checkExpect(b01.contains(2), true);
        t.checkExpect(b01.contains(4), true);
        t.checkExpect(b01.contains(6), true);
        t.checkExpect(b01.contains(2), true);
        t.checkExpect(b01.contains(4), true);
        t.checkExpect(b01.contains(6), true);

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
        t.checkExpect(new BTree<String>(node1.blackT()).repOK(), true);
        t.checkExpect(new BTree<String>(node01.blackT()).repOK(), true);

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
        
        t.checkExpect(new BTree<String>(null).iterator().hasNext(), false);
        
        
        //remove
        t.checkException(new UnsupportedOperationException("remove"),
                bn1.iterator(), "remove");

        // add
        bl1.add("x");
        bl2.add("x");
        t.checkExpect(bl1, 
                new BTree<String>(RBTree.node("x", leaf1, leaf1, c1, "red")));
        t.checkExpect(bl2, 
                new BTree<String>(RBTree.node("x", leaf2, leaf2, c2, "red")));
        reset();
        bn1.add("xx");
        t.checkExpect(
                bn1,
                new BTree<String>(RBTree.node("yyyy",
                        RBTree.node("xx", leaf1, leaf1, c1, "black"),
                        RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1,
                        "red")));
        bn1.add("yyyy");
        t.checkExpect(
                bn1,
                new BTree<String>(RBTree.node("yyyy",
                        RBTree.node("xx", leaf1, leaf1, c1, "black"),
                        RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1,
                        "red")));
        bn1.add("zzzzzz");
        t.checkExpect(
                bn1,
                new BTree<String>(RBTree.node("yyyy",
                        RBTree.node("xx", leaf1, leaf1, c1, "black"),
                        RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1,
                        "red")));
        bn1.add("aaaaaaa");
        t.checkExpect(
                bn1,
                new BTree<String>(RBTree.node(
                        "yyyy", RBTree.node("xx", leaf1, leaf1, c1,
                        "black"), RBTree.node("zzzzzz", leaf1,
                        RBTree.node("aaaaaaa", leaf1, leaf1, c1, "red"), c1,
                        "black"), c1, "red")));
        reset();
        bn1.add("aaaaa");
        t.checkExpect(
                bn1,
                new BTree<String>(RBTree.node(
                        "yyyy", RBTree.node("xx", leaf1, leaf1, c1,
                        "black"), RBTree.node("zzzzzz",
                        RBTree.node(
                                "aaaaa", leaf1, leaf1, c1, "red"), leaf1, c1,
                        "black"), c1, "red")));
        reset();
        bn1.add("aaa");
        t.checkExpect(
                bn1,
                new BTree<String>(RBTree.node("yyyy", RBTree.node("xx", leaf1,
                        RBTree.node(
                                "aaa", leaf1, leaf1, c1, "red"), c1, "black"),
                        RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1,
                        "red")));
        reset();
        bn1.add("a");
        t.checkExpect(
                bn1,
                new BTree<String>(RBTree.node("yyyy", RBTree.node("xx",
                        RBTree.node("a", leaf1, leaf1, c1, "red"), leaf1, c1,
                        "black"),
                        RBTree.node("zzzzzz", leaf1, leaf1, c1, "black"), c1,
                        "red")));
        reset();
        bn01.add("g");
        t.checkExpect(
                bn01,
                new BTree<String>(RBTree.node("d", RBTree
                        .node("b", leaf2, leaf2, c2, "black"), RBTree.node("f",
                        leaf2, RBTree.node("g", leaf2, leaf2, c2, "red"), c2,
                        "black"), c2, "red")));
        reset();
        bn01.add("e");
        t.checkExpect(
                bn01,
                new BTree<String>(RBTree.node("d", RBTree
                        .node("b", leaf2, leaf2, c2, "black"), RBTree.node("f",
                        RBTree.node("e", leaf2, leaf2, c2, "red"), leaf2, c2,
                        "black"), c2, "red")));
        reset();
        bn01.add("c");
        t.checkExpect(
                bn01,
                new BTree<String>(RBTree.node("d", RBTree.node("b", leaf2,
                        RBTree.node("c", leaf2, leaf2, c2, "red"), c2, "black"),
                        RBTree.node(
                                "f", leaf2, leaf2, c2, "black"), c2, "red")));
        reset();
        bn01.add("a");
        t.checkExpect(
                bn01,
                new BTree<String>(RBTree.node("d", RBTree.node("b",
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
                new BTree<String>(RBTree.node(
                        "yyyy", RBTree.node("xx", leaf1, leaf1, c1,
                        "black"), RBTree.node("zzzzzz", leaf1,
                        RBTree.node("aaaaaaa", leaf1, leaf1, c1, "red"), c1,
                        "black"), c1, "red")));
        reset();
        t.checkExpect(bl1.bad, false);
        bl1.active = 0;
        bl1.add("x");
        t.checkExpect(bl1, 
                new BTree<String>(RBTree.node("x", leaf1, leaf1, c1, "red")));
        reset();
        t.checkExpect(bl1.bad, false);
        bl1.active = 1;
        t.checkException(new ConcurrentModificationException(
                "add with active iterator"), bl1, "add", "it");
        bl1.active = 0;
        reset();
        
        // build(iter)
        bl1.build(bn1);
        t.checkExpect(bl1, new BTree<String>(node1.blackT()));
        reset();
        bl2.build(bn02);
        t.checkExpect(bl2, new BTree<String>(node01.blackT()));
        reset();
        bl1.build(bl1);
        t.checkExpect(bl1, bl1);
        reset();
        bl3.build(b01);
        t.checkExpect(bl3, new BTree<Integer>(nod01.blackT()));
        reset();
        bl3.build(b02);
        t.checkExpect(bl3, new BTree<Integer>(nod01.blackT()));
        reset();
        bl3.build(bl3);
        t.checkExpect(bl3, bl3);
        reset();

        // build(iter, numStrings)
        bl1.build(bn1, 0);
        t.checkExpect(bl1, BTree.binTree(c1));
        reset();
        bl2.build(bn02, 0);
        t.checkExpect(bl2, BTree.binTree(c2));
        reset();
        bl1.build(bn1, -1);
        t.checkExpect(bl1, new BTree<String>(node1.blackT()));
        reset();
        bl2.build(bn02, -1);
        t.checkExpect(bl2, new BTree<String>(node01.blackT()));
        reset();
        bl1.build(bn1, 5);
        t.checkExpect(bl1, new BTree<String>(node1.blackT()));
        reset();
        bl2.build(bn02, 5);
        t.checkExpect(bl2, new BTree<String>(node01.blackT()));
        reset();

        bl1.build(bn1, 1);
        t.checkExpect(bl1, 
                new BTree<String>(
                        RBTree.node("xx", leaf1, leaf1, c1, "black")));
        reset();
        bl2.build(bn02, 1);
        t.checkExpect(bl2, 
                new BTree<String>(
                        RBTree.node("b", leaf2, leaf2, c2, "black")));
        reset();
        
        bl1.build(bl1, 10);
        t.checkExpect(bl1, bl1);
        reset();
        
        bl3.build(b01, 0);
        t.checkExpect(bl3, BTree.binTree(c3));
        reset();
        bl3.build(b02, 0);
        t.checkExpect(bl3, BTree.binTree(c3));
        reset();
        bl3.build(b01, -1);
        t.checkExpect(bl3, new BTree<Integer>(nod01.blackT()));
        reset();
        bl3.build(b02, -1);
        t.checkExpect(bl3, new BTree<Integer>(nod01.blackT()));
        reset();
        bl3.build(b01, 5);
        t.checkExpect(bl3, new BTree<Integer>(nod01.blackT()));
        reset();
        bl3.build(b02, 5);
        t.checkExpect(bl3, new BTree<Integer>(nod01.blackT()));
        reset();

        bl3.build(b01, 1);
        t.checkExpect(bl3, 
                new BTree<Integer>(RBTree.node(2, leaf3, leaf3, c3, "black")));
        reset();
        bl3.build(b02, 1);
        t.checkExpect(bl3, 
                new BTree<Integer>(RBTree.node(2, leaf3, leaf3, c3, "black")));
        reset();
        
        bl3.build(bl3, 10);
        t.checkExpect(bl3, bl3);
        reset();
        
        //compare
        t.checkExpect(c1.compare("xx", "xxx"), -1);
        t.checkExpect(c1.compare("xxx", "xxx"), 0);
        t.checkExpect(c1.compare("xxx", "xx"), 1);
        t.checkExpect(c2.compare("a", "b"), -1);
        t.checkExpect(c2.compare("a", "a"), 0);
        t.checkExpect(c2.compare("b", "a"), 1);
        
        // visitor for pathLengths
        t.checkExpect(BTree.binTree(c1).accept(pathLengths),
                new ArrayList<Integer>(Arrays.asList(0)));
        t.checkExpect(
                new BTree<String>(RBTree.node("1", leaf1, leaf1, c1, "black"))
                        .accept(pathLengths2),
                new ArrayList<Integer>(Arrays.asList(1, 1)));
        t.checkExpect(new BTree<String>(node1).accept(pathLengths3),
                new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2)));

        // visitor for height
        t.checkExpect(bl1.accept(height), 0);
        t.checkExpect(bn1.accept(height), 2);
        t.checkExpect(bn2.accept(height), 3);
        
        //visitor for blackHeight
        t.checkExpect(bl1.accept(blackHeight), 0);
        t.checkExpect(bn1.accept(blackHeight), 1);
        t.checkExpect(bn2.accept(blackHeight), 1);
        t.checkExpect(
                new BTree<String>(RBTree.node("1", RBTree.node("2",
                        RBTree.node("4", leaf1, leaf1, c1, "black"), leaf1, c1,
                        "red"), RBTree.node("3", leaf1, leaf1, c1, "red"), c1,
                        "black")).accept(blackHeight), 2);
        t.checkExpect(
                new BTree<String>(RBTree.node("1", RBTree.node("2",
                        RBTree.node("4", leaf1, leaf1, c1, "red"), leaf1, c1,
                        "red"), RBTree.node("3", leaf1, leaf1, c1, "black"), c1,
                        "black")).accept(blackHeight), 2);

        // visitor for countNodes
        t.checkExpect(bl1.accept(countNodes),
                new ArrayList<Integer>(Arrays.asList(0, 0, 0)));
        t.checkExpect(bn1.accept(countNodes),
                new ArrayList<Integer>(Arrays.asList(3, 2, 1)));
        t.checkExpect(bn2.accept(countNodes),
                new ArrayList<Integer>(Arrays.asList(3, 1, 2)));
        t.checkExpect(bn3.accept(countNodes),
                new ArrayList<Integer>(Arrays.asList(3, 1, 2)));

    }

}
