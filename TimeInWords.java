import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
import java.util.*;
//import java.util.concurrent.*;
//import java.util.regex.*;

public class TimeInWords {

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String output;
        // Array of numbers in words
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", 
        				 "eight", "nine", "ten", "eleven", "twelve", "thirteen",                                 
        				 "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",                               
        				 "nineteen", "twenty", "twenty one", "twenty two", 
                         "twenty three", "twenty four", "twenty five", "twenty six",                              
                         "twenty seven", "twenty eight", "twenty nine" };
        
        // case statements to account for the various special cases
        switch (m) {
            case 0:
                output = nums[h] + " o' clock";
                break;
            
            case 15:
                output = "quarter past " + nums[h];
                break;
                
            case 30:
                output = "half past " + nums[h];
                break;
                
            case 45:
                output = "quarter to " + nums[h+1];
                break;
                
            default:
            	
                if (m < 30) {
                	// Change minutes to singular minute for minutes less than 10
                    if (m < 10) {
                        output = nums[m] + " minute past " + nums[h];
                    } else {
                        output = nums[m] + " minutes past " + nums[h];
                    }
                } else {
                    output = nums[60-m] + " minutes to " + nums[h+1];
                }      
        }
        
        // return string output of time in words
        return output;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);
        // print time in words to the console
        System.out.println(result);
        //bufferedWriter.write(result);
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
