/**
 * the class represent movie
 * 
 * @author Shiyu
 * @version 2013-12-1
 * 
 */
public class Movie {
    /** name of movie */
    String  name;
    /** starting time of movie */
    int     time;
    /** theater for movie */
    Theater theater;

    /**
     * Constructor of movie
     * 
     * @param name
     *            -- the name of the movie
     * @param time
     *            -- the starting time of the movie
     * @param theater
     *            -- the located theater of the movie
     * 
     * */
    Movie(String name, int time, Theater theater) {
        this.name = name;
        this.time = time;
        this.theater = theater;
    }

}
