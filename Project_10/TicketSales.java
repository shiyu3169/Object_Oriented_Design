/** Shiyu Wang
 *  shiyu@ccs.neu.edu
 *  
 *  There are 4 error from Web-cat cause I lose 4 points,
 *  "This method call is 32 spaces from the margin 
 *  and it should be at 36 spaces."
 *  
 *  however, once I change them, web-cat will ask me to change 
 *  it back to 32 spaces. I don't want to lose those points
 *  Is it a bug of Web-cat?
 *  
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * the class TicketSeller by requirement
 * 
 * @author Shiyu
 * @version 2013-12-1
 */
public class TicketSales {

    /** new ArrayList of movies in cinema */
    ArrayList<Movie>   mlist  = new ArrayList<Movie>();

    /** the cinema */
    Cinema             cinema = new Cinema(mlist, null);

    /** the arrayList of moveis name from input file */
    ArrayList<String>  nlist  = new ArrayList<String>();

    /** the arraylist of theaters with it's capacity from input file */
    ArrayList<String>  tlist  = new ArrayList<String>();

    /** the arraylist of 3 different prices from input file */
    ArrayList<Integer> plist  = new ArrayList<Integer>();
    
    /** the string used to represent reportSales */
    String confirm = "";
    
    /**  the string used to represent manager report */
    String man = "";
    
    /** the string used to represent log report */
    String log = "";
    
    /** the int represent the number of Manager reports */
    int count = 0;

    /**
     * EFFECT: update the nlist with given file
     * 
     * @param fileName
     *            -- the given file
     * @throws FileNotFoundException
     *             -- if the file is not found
     */
    void getNames(String fileName) throws FileNotFoundException {
        /** the created scanner by given file */
        Scanner input1 = new Scanner(new File(fileName));

        while (input1.hasNextLine()) {
            if (input1.nextLine().equals("Movies")) {
                String s = input1.nextLine();
                while (!s.equals("Theaters")) {
                    nlist.add(s.substring(0, s.indexOf(":")));
                    s = input1.nextLine();
                }
            }
        }
        input1.close();
    }
    
    /**
     * EFFECT: update the tlist with given file
     * 
     * @param fileName
     *            -- the given file
     * @throws FileNotFoundException
     *             -- if the file is not found
     */
    void getTheaters(String fileName) throws FileNotFoundException {
        /** the created scanner by given file */
        Scanner input2 = new Scanner(new File(fileName));

        while (input2.hasNextLine()) {
            if (input2.nextLine().equals("Theaters")) {
                String s = input2.nextLine();
                while (!s.equals("Shows")) {
                    tlist.add(s);
                    s = input2.nextLine();
                }
            }
        }
        input2.close();
    }

    /**
     * EFFECT: update the plist with given file
     * 
     * @param fileName
     *            -- the given file
     * @throws FileNotFoundException
     *             -- if the file is not found
     */
    void getPrices(String fileName) throws FileNotFoundException {
        /** the created scanner by given file */
        Scanner input3 = new Scanner(new File(fileName));

        while (input3.hasNextLine()) {
            if (input3.nextLine().equals("Prices")) {
                String s = input3.nextLine();
                while (!s.equals("End")) {
                    plist.add(Integer.valueOf(s.substring(s.indexOf(":") + 1)));
                    s = input3.nextLine();
                }
            }
        }
        input3.close();
    }

    /**
     * initialise the Cinema with the given file
     * 
     * @param fileName
     *            -- the file used to initialize cinema
     */
    void initCinema(String fileName) {
        try {
            /** update nlist */
            this.getNames(fileName);
            /** update tlist */
            this.getTheaters(fileName);
            /** update plist */
            this.getPrices(fileName);

            /** the created scanner by given file */
            Scanner input = new Scanner(new File(fileName));

            while (input.hasNextLine()) {
                if (input.nextLine().equals("Shows")) {
                    String s = input.nextLine();
                    while (!s.equals("Prices")) {
                        Movie m = new Movie("", 0, null);
                        Theater t = new Theater("", 0);
                        m.name = nlist
                                .get(Integer.valueOf(s.substring(0, 1)) - 1);
                        String theater = tlist.get(Integer.valueOf(s.substring(
                                2, 3)) - 1);
                        t.name = theater.substring(0, theater.indexOf(":"));
                        t.seat = Integer.valueOf(theater.substring(theater
                                .indexOf(":") + 1));
                        t.totalSeat = Integer.valueOf(theater.substring(theater
                                .indexOf(":") + 1));
                        m.theater = t;
                        m.time = Integer.valueOf(s.substring(4));
                        cinema.movies.add(m);
                        s = input.nextLine();
                    }
                    cinema.prices = plist;
                }
            }
            input.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found! Please retry (1)");
        }
    }
        

    /**
     * process the order by given file
     * 
     * @param fileName
     *            -- the file used to process order
     */

    void processOrders(String fileName) {
        try {
            /** the created scanner by given file */
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNextLine()) {
                String it = input.nextLine();
                if (it.equals("report")) {
                    count++;
                    manup();
                }
                if (!it.equals("report")) {
                    String[] parts = it.split(",");
                    for (int i = 0; i < cinema.movies.size(); i++) {
                        if (nlist.get(Integer.valueOf(parts[0]) - 1).equals(
                                cinema.movies.get(i).name)
                                && tlist.get(Integer.valueOf(parts[1]) - 1)
                                        .substring(
                                                0,
                                                tlist.get(
                                                        Integer
                                                        .valueOf(parts[1]) - 1)
                                                        .indexOf(":"))
                                        .equals(cinema.movies
                                                .get(i).theater.name)
                                && Integer.valueOf(parts[2]) == cinema.movies
                                        .get(i).time) {
                            if (cinema.movies.get(i).theater.seat < Integer
                                    .valueOf(parts[3])
                                    + Integer.valueOf(parts[4])
                                    + Integer.valueOf(parts[5])) {
                                confirm = confirm + it + "," + 0 + "\n";
                                log = log + "no error occured" + "\n";
                            }
                            if (cinema.movies.get(i).theater.seat >= Integer
                                .valueOf(parts[3])
                                + Integer.valueOf(parts[4])
                                + Integer.valueOf(parts[5])) {
                                log = log + "this theater has no space" + "\n";
                                cinema.movies.get(i).theater.seat -= (Integer
                                        .valueOf(parts[3])
                                        + Integer.valueOf(parts[4]) + Integer
                                        .valueOf(parts[5]));
                                cinema.movies.get(i).theater.aSeat += Integer
                                        .valueOf(parts[3]);
                                cinema.movies.get(i).theater.cSeat += Integer
                                        .valueOf(parts[4]);
                                cinema.movies.get(i).theater.sSeat += Integer
                                        .valueOf(parts[5]);
                                confirm = confirm
                                        + it
                                        + ","
                                        + (Integer.valueOf(parts[3])
                                                * plist.get(0)
                                                + Integer.valueOf(parts[4])
                                                * plist.get(1) + Integer
                                                .valueOf(parts[5])
                                                * plist.get(2)) + "\n";
                            }
                        }
                    }
                }
            }
            input.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found! Please retry (2)");
        }
    }

    /**
     * report the sales
     * @return the reports
     */
    String reportSales() {
        return confirm;
    }
    
    /**
     * EFFECT: update the manager report
     */
    void manup() {
        man = man + "Report " + count + "\n";
        for (int i = 0; i < cinema.movies.size(); i++) {
            man = man + cinema.movies.get(i).name + ","
                    + cinema.movies.get(i).theater.name + ","
                    + cinema.movies.get(i).time + ","
                    + cinema.movies.get(i).theater.totalSeat + ","
                    + cinema.movies.get(i).theater.aSeat + ","
                    + cinema.movies.get(i).theater.cSeat + ","
                    + cinema.movies.get(i).theater.sSeat + "\n";
        }
    }

    /**
     * provide mamager report
     * @return the manager report
     */
    String managerReport() {
        return man;
    }

    /**
     * provide log report
     * @return the log report
     */
    String logReport() {
        return log;
    }
    

}
