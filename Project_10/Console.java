/** Shiyu Wang
 *  shiyu@ccs.neu.edu
 *  
 *  There are 4 error from Web-cat cause I lose 4 points,
 *  "This method call is 16 spaces from the margin 
 *  and it should be at 20 spaces."
 *  
 *  however, once I change them, web-cat will ask me to change 
 *  it back to 16 spaces. I don't wan to lose those points
 *  Is it a bug of Web-cat?
 *  
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 * this class represents the console
 * 
 * @author Shiyu
 * @version 2013-4-12
 */
public class Console {
    /** the TicketSales used in Console */
    TicketSales ts  = new TicketSales();

    /** selected movie */
    Movie       m   = null;

    /** selected movie's number */
    int         x   = 0;

    /** record the number of tickets */
    int         nt  = 0;

    /** record the number of children */
    int         nc  = 0;

    /** record the number of seniors */
    int         ns  = 0;

    /** confirm purchasing */
    boolean     buy = false;

    /**
     * show the welcome page
     */
    @SuppressWarnings("resource")
    void welcome() {
        System.out.println("     Welcome to our Cinema" + "\n"
                + "You can choose the option you want" + "\n"
                + "1. Buying ticket" + "\n" + "2. Manage cinema" + "\n");
        Scanner sc = new Scanner(System.in);
        String it = sc.next();
        if (!(it.equals("1") || it.equals("2"))) {
            System.out.println("input is not valid, please redo it");
            welcome();
        }

        if (it.equals("1")) {
            this.moviePrint();
        }
        if (it.equals("2")) {
            this.change();
        }

    }
    /**
     * change the movies
     */
    @SuppressWarnings("resource")
    void change() {
        System.out.println("1. add movie");
        System.out.println("2. remove movie");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            System.out.println("input is not valid, please redo it");
            change();
        }
        
        else {
            System.out.println("input is not valid, please redo it");
            change();
        }
    }

    /**
     * print all the movies the cinema has
     */
    @SuppressWarnings("resource")
    void moviePrint() {
        System.out.println("Which movie you would like to watch?" + "\n");
        int count = 1;
        for (int i = 0; i < ts.nlist.size(); i++) {
            System.out.println(count + "." + ts.nlist.get(i));
            count++;
        }
        Scanner s = new Scanner(System.in);
        if (s.hasNextInt()) {
            int it = s.nextInt();

            if (!(0 < it && it <= ts.nlist.size())) {
                System.out.println("input is not valid, please redo it");
                moviePrint();
            } 
            else {
                tPrint(it);

            }
        } 
        else {
            System.out.println("input is not valid, please redo it");
            moviePrint();
        }

    }

    /**
     * print the movie with time and theater information
     * 
     * @param it\
     *            -- the input int from movie print
     */
    @SuppressWarnings("resource")
    void tPrint(int it) {
        int size = 0;
        String name = "";
        int time = 0;
        String theater = "";
        System.out.println("Please choose one of the following"
                + " time and Theater you would like to watch:" + "\n");
        ArrayList<Movie> mlist = ts.cinema.movies;
        for (int i = 0; i < mlist.size(); i++) {
            if (mlist.get(i).name.equals(ts.nlist.get(it - 1))) {
                System.out.println((size + 1) + ". " + mlist.get(i).name + ": "
                        + "time: " + mlist.get(i).time / 60 + ":"
                        + mlist.get(i).time % 60 + " " + "Theater: "
                        + mlist.get(i).theater.name + " "
                        + "Remaning/Total seats: " + mlist.get(i).theater.seat
                        + "/" + mlist.get(i).theater.totalSeat);
                size++;
                name = mlist.get(i).name;
                time = mlist.get(i).time;
                theater = mlist.get(i).theater.name;
            }
        }

        Scanner s = new Scanner(System.in);
        if (s.hasNextInt()) {
            int in = s.nextInt();

            if (0 < in && in <= size) {
                for (int j = 0; j < mlist.size(); j++) {
                    if (mlist.get(j).name.equals(name)
                            && mlist.get(j).time == time
                            && mlist.get(j).theater.name.equals(theater)) {
                        m = mlist.get(j);
                        x = j;
                        purchase();
                    }
                }
            } 
            else {
                System.out.println("input is not valid, please redo it");
                tPrint(it);
            }

        } 
        else {
            System.out.println("input is not valid, please redo it");
            tPrint(it);
        }
    }

    /**
     * purchase the ticket
     */
    @SuppressWarnings("resource")
    void purchase() {
        System.out
                .println("Alright, now you can start purchasing your ticket(s)"
                        + "\n");
        System.out.println("First, how many tickets in total you want to get"
                + " (including children and senior)" + "\n");
        System.out.println("(The ticket's prices are:" + "Adult: "
                + ts.plist.get(0) + "/n" + "Child: " + ts.plist.get(1) + "/n"
                + "Senior: " + ts.plist.get(2) + ")");
        Scanner s = new Scanner(System.in);
        if (s.hasNextInt()) {
            int si = s.nextInt();
            nt = si;
            if (0 < si && si < m.theater.seat) {
                purchase2();
                ts.cinema.movies.get(x).theater.seat -= si;
            } 
            else {
                System.out.println("Sorry, we dont have enough seat,"
                        + " or your input is not valid, please redo it");
                purchase();
            }
        }

        else {
            System.out.println("input is not valid, please redo it");
            purchase();
        }
    }

    /**
     * count the children ticket
     */
    @SuppressWarnings("resource")
    void purchase2() {
        System.out.println("Thank you" + "\n");
        System.out.println("Now, how many tickets were there for children?");
        Scanner s = new Scanner(System.in);
        if (s.hasNextInt()) {
            int c = s.nextInt();
            nc = c;
            if (0 <= c && c <= nt) {
                purchase3();
                ts.cinema.movies.get(x).theater.cSeat += c;
            }

            else {
                System.out.println("Sorry, you didn't buy that much tickets"
                        + " ,or input is not valid, please redo it");
                purchase2();
            }

        }

        else {
            System.out.println("your input is not valid, please redo it");
            purchase2();
        }
    }

    /**
     * count the senior ticket
     */
    @SuppressWarnings("resource")
    void purchase3() {
        System.out.println("OK!" + "\n");
        System.out.println("Now, how many tickets were there for seniors?");
        Scanner s = new Scanner(System.in);
        if (s.hasNextInt()) {
            int sen = s.nextInt();
            ns = sen;
            if (0 <= sen && sen <= (nt + nc)) {
                confirm();

                ts.cinema.movies.get(x).theater.sSeat += sen;

                ts.cinema.movies.get(x).theater.aSeat += (nt - nc - sen);
            }

            else {
                System.out.println("Sorry, you didn't buy that much tickets"
                        + " ,or input is not valid, please redo it");
                purchase3();
            }

        }

        else {
            System.out.println("your input is not valid, please redo it");
            purchase3();
        }
    }

    /**
     * confirm the purchase
     */
    @SuppressWarnings("resource")
    void confirm() {
        System.out.println("Ok, all things are done");
        System.out.println("Your total is: "
                + (nc * ts.plist.get(1) + ns * ts.plist.get(2) + (nt - nc - ns)
                        * ts.plist.get(0)) + "\n");
        System.out.println("Are you sure for it?" + "\n");
        System.out.println("1.Yes");
        System.out.println("2.No");
        Scanner s = new Scanner(System.in);
        if (s.hasNextInt()) {
            int b = s.nextInt();

            if (b == 1) {
                System.out
                        .println("Thank you for purchasing, enjoy your movie!"
                                + "\n" + "\n");
                buy = true;
                welcome();
            }
            if (b == 2) {
                System.out.println("You can redo everything again" + "\n"
                        + "\n");
                welcome();
            }

            else {
                System.out.println("your input is not valid, please redo it");
                confirm();
            }
        } 
        else {
            System.out.println("your input is not valid, please redo it");
            confirm();
        }

    }

    /**
     * main method to run the console
     */
    /*
     * public static void main(String[] args) { Console c = new Console();
     * c.ts.initCinema("cinema.txt"); c.welcome(); }
     */

}
