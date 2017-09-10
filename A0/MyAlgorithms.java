/**Shiyu Wang
 wang.shiyu@husky.neu.edu
  
*/

import java.util.ArrayList;

/** the class MyAgorithms 
  @author Shiyu
  @version 2013-09-09*/

public class MyAlgorithms {
    
    
    /**
     * Template:
     * 
     * Fields: None
     * 
     * Methods: ...this.sort(arrayList<String>).... -- void
     * 
     * Methods for fields: No fields
     */
    
    /** Effect: 
     * insert the given item into the given ArrayList based on the given
    ordering in its appropriate place in the list 
    */
    /**
    @author Shiyu 
    @version 2013-09-09
    @param it -- an element string in arrayList
    @param alist -- the arrayList needs to be sorted
     */
    public static void sortedInsert(String it, ArrayList<String> alist) {
        sortedInsertHelp(it, alist, 0);
    }

    /** Effect: insert the given item into the given ArrayList based on the
    // given ordering; places the item at the given index if it is supposed
     to be there 
     */
    /**
     * @author Shiyu 
       @version 2013-09-09 
       @param item -- the element string in arrayList
       @param alist -- the arrayList needs to be sorted
       @param ind -- the index of arrayList
     */
    public static void sortedInsertHelp(
            String item, ArrayList<String> alist, int ind) {
        
        if (alist.isEmpty()) {
            alist.add(item);
        }
        else if (alist.size() > ind && 
                alist.get(ind).compareTo(item) <= 0) {
            sortedInsertHelp(item, alist, (ind + 1));
        }
        else if (alist.size() > ind && 
                alist.get(ind).compareTo(item) > 0) {
            alist.add(ind, item);
        }
        else {
            alist.add(item);
        }
    }

    /** Effect: sort the ArrayList based on the given ordering 
     */ 
    /**
    @author Shiyu 
    @version 2013-09-09
    @param slist -- the list needs to be sorted
   */
    public static void sort(ArrayList<String> slist) {
        
        if (slist != null && !slist.isEmpty()) {
            insertionSortHelper(slist);
        }
    }

    /** Effect: sort the given ArrayList based on the given ordering */
    /**
    @author Shiyu 
    @version 2013-09-09
    @param alist -- the list needs to be sorted */
    public static void insertionSortHelper(ArrayList<String> alist) {
        
        String it = alist.get(0);
        alist.remove(it);
        sort(alist);
        sortedInsert(it, alist);
    }
}