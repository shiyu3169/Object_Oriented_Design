import java.util.ArrayList;
import junit.framework.TestCase;

/**
 * 
 * @author Shiyu
 * @version 2013-09-09 
 */
public class MyAlgorithmsTest extends TestCase {
    
    /** for coverage of MyAlgorithms */
    MyAlgorithms ma = new MyAlgorithms();
    
    /** the example of unsorted arrayList<String> */
    static ArrayList<String> blist = new ArrayList<String>();
    
  /** the example of sorted arrayList<String> */
    static ArrayList<String> clist = new ArrayList<String>();
    
    /** the example of unsorted arrayList<String> */
    static ArrayList<String> elist = null;
    
  /** reset the ArrayList 
     */
    /**
    @author Shiyu 
    @version 2013-09-09 
    */
    static void reset() {
        blist.add("bbbb");
        blist.add("aaaa");
        blist.add("ffff");
        blist.add("eeee");

        clist.add("aaaa");
        clist.add("bbbb");
        clist.add("eeee");
        clist.add("ffff");
    }
    

    /** tests */
    /**
    @test
    @author Shiyu 
    @version 2013-09-09
    */
    public static void testSort() {
        
        /** sort empty list*/
        assertEquals(elist, null);
        /** before sorting*/
        reset();
        assertEquals(blist.get(0), "bbbb");
        /** sort */
        MyAlgorithms.sort(blist);
        MyAlgorithms.sort(elist);
        /** sorted */
        assertEquals(blist, clist);
        assertEquals(blist.get(0), "aaaa");
    }
}

