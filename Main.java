/**
 * Project3.java
 * "Is it open?"
 *
 * @author Rylan Sedlacek
 * @version 2.0 (added methods in 2.0)
 */

// I pledge that I wrote this code on my own without cheating.
// stack overflow referenced to create the random special algorithm.
// idea from myself having to google the C.R.U.C. hours everytime I am hungry.

import java.util.*; //api methods
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException { //file not found

        Scanner stdin = new Scanner(System.in); //scanner
        Random randomTime = new Random(); //random time
        Random randomSpecial = new Random(); //random special

        System.out.print("Enter your meal plan: ");
        String fileName = stdin.next(); // meal plan file scan

        File myinputFile = new File(fileName); //file scanner here
        Scanner fileIn = new Scanner(myinputFile); //and here

        while (fileIn.hasNext()) { //begin while
            String mealPlan = fileIn.nextLine();

            int[] openTimes = {8, 12, 17}; //open and close times here array
            int[] closedTimes = {11, 15, 19};

            System.out.println("Your choice is: " + mealPlan);

            System.out.print("Ready to eat? "); //prompt Yes or No
            String choice = stdin.next();

            if (choice.equals("Yes")) { // yes choice
                int currentTime = randomTime.nextInt(15); //random times
                tellCurrentTime(currentTime);
                boolean isOpen = isLocationOpen(currentTime, openTimes, closedTimes); //call to location open method

                if (isOpen) {
                    System.out.println("Open"); //open
                    System.out.println(" ");

                    int key = randomSpecial.nextInt(4); //if open check the specials
                    int[] special = {1, 2, 3, 4};
                    int count = 0;

                    while (count < special.length && key != special[count]) { //sequential search
                        count++;
                    }

                    if (count == special.length) { //found key check specials
                        String[] specialItems = {"Chocolate Cake", "Tomato Soup", "Mac-n-Cheese", "Tim-Tams"}; //specials array
                        int randomItem = randomSpecial.nextInt(specialItems.length); //random special
                        String randomSpecialItem = specialItems[randomItem];

                        System.out.println("Special Today: " + randomSpecialItem); // tell us the special
                        System.out.println(" ");

                    } else {
                        System.out.println("No Special Today."); //or no special
                        System.out.println(" ");
                    }
                } else {
                    System.out.println("Closed"); //closed say this
                    System.out.println(" ");
                }
            } else if (choice.equals("No")) { // user says No say this
                System.out.println("OK, come back later!");
                System.out.println(" ");
            }
        } //end while

        stdin.close(); // close scanner
    } //end of main method

    /**
     * determines if a location is open or not!
     * @param  currentTime is found using the random method on line 40.
     * @param openTimes compared to determine if a location is open.
     * @param closedTimes compared to determine if a location is open.
     * @return isOpen
     */
    public static boolean isLocationOpen(int currentTime, int[] openTimes, int[] closedTimes) { //location open method
        boolean isOpen = false;

        for (int i = 0; i < openTimes.length; i++) { //is the location open for loop
            if (currentTime >= openTimes[i] && currentTime < closedTimes[i]) {
                isOpen = true;
            } else {
                System.out.print("");

            }
        } //end for

        return isOpen; //return isOpen
    } //end location open method

    /**
     * Formats the time, if (1-11, its am), if (12-24 its pm.)
     * @param currentTime current time is determined in the method above.
     */

    public static void tellCurrentTime(int currentTime) { //time format method
        if (currentTime >= 1 && currentTime <= 11) { // current time 1-11
            System.out.println("The current time is: " + currentTime + ":00 am"); // am
        } else {
            System.out.println("The current time is: " + currentTime + ":00 pm"); //if not then its pm
        }
    } //end time format method
} //end main




