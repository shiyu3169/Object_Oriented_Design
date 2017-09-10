/**
 * the class represents a theater
 * 
 * @author Shiyu
 * @version 2013-12-3
 */
public class Theater {
    /** the name of the theater */
    String name;
    /** number of seat available */
    int    seat;
    /** number of total seats */
    int totalSeat;
    
    /** number of Adult sold*/
    int aSeat;
    
    /** number of Children sold*/
    int cSeat;
    
    /** number of Senior sold*/
    int sSeat;

    /** constructor of Theater 
     * @param name -- the name of the theater
     * @param seat -- the available remaining seats of theater
     * 
     * */
    Theater(String name, int seat) {
        this.name = name;
        this.seat = seat;
    }
}
