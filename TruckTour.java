import java.io.*;
//import java.math.*;
//import java.text.*;
import java.util.*;
//import java.util.regex.*;

public class TruckTour {

    /*
     * Complete the truckTour function below.
     */
    static int truckTour(int[][] petrolpumps) {
        /*
         * Write your code here.
         */

        int liters = 0;
        int distance = 0;
        // number of gas station we start at
        int start_num = 0;
        int row = 0;
        // boolean value used to ensure a circular path from start_num to start_num
        boolean loop = false;

        // loops through each gas station
        while (row < petrolpumps.length) {
        	// adds certain # of liters to tank
            liters += petrolpumps[row][0];
            // store distance to next gas station
            distance = petrolpumps[row][1];

            // Increment start_num if impossible to reach next station
            if (distance > liters) {
                start_num++;
                // start loop again from new start_num
                row = start_num;
                liters = 0;
            } else {
                liters -= distance;
                // used to break out of loop once circle successfully achieved
                if (row == start_num && loop == true) {
                    break;
                }
                // circles back to beginning of array if at last element
                if (row == petrolpumps.length - 1) {
                    row = 0;
                    loop = true;
                } else {
                    row++;
                }
            }
        }
        
        // Used to alert user if given test case is not possible
        if (start_num >= petrolpumps.length) {
            System.out.println("Impossible Test Case!");
        }

        return start_num;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(scanner.nextLine().trim());
        
        int[][] petrolpumps = new int[n][2];
        // Scan contents of input file and processes data into 2D array	
        for (int petrolpumpsRowItr = 0; petrolpumpsRowItr < n; petrolpumpsRowItr++) {
            String[] petrolpumpsRowItems = scanner.nextLine().split(" ");

            for (int petrolpumpsColumnItr = 0; petrolpumpsColumnItr < 2; petrolpumpsColumnItr++) {
                int petrolpumpsItem = Integer.parseInt(petrolpumpsRowItems[petrolpumpsColumnItr].trim());
                petrolpumps[petrolpumpsRowItr][petrolpumpsColumnItr] = petrolpumpsItem;
            }
        }

        int result = truckTour(petrolpumps);
        // Prints out the earliest possible gas station number to start at
        System.out.println(result);

    }
}
