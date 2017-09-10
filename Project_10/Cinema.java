import java.util.ArrayList;

/**
 * the class represent the cinema
 * 
 * @author Shiyu
 * @version 2013-12-1
 */
public class Cinema {
    /** the movies in the cinema as ArrayList<movies> */
    ArrayList<Movie>   movies;

    /** the different kinds of prices */
    ArrayList<Integer> prices;

    /**
     * constructor of Cinema
     * 
     * @param movies
     *            -- a list of movies show in cinema
     * @param prices
     *            list of 3 different prices
     * 
     * */
    Cinema(ArrayList<Movie> movies, ArrayList<Integer> prices) {
        this.movies = movies;
        this.prices = prices;
    }
    
    
}
