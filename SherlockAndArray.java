import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
import java.util.*;
//import java.util.concurrent.*;
//import java.util.regex.*;

public class SherlockAndArray {

    // Complete the balancedSums function below.
    static String balancedSums(List<Integer> arr) {
        int left_sum = 0;
        int right_sum = 0;
        int total_sum = 0;
        
        for (int i : arr) {
        	// Calculate total sum from array
            total_sum += i;
        }
        
        for (int i = 0; i < arr.size(); i++) {
            // Account for edge case
        	if (i == 0) {
                left_sum = 0;
                right_sum = total_sum - arr.get(i);
                
            // Add previous num to left_sum, subtract current num from right_sum
            } else {
                left_sum += arr.get(i-1);
                right_sum -= arr.get(i);
            }
            
            // Check if both sides are equal
            if (left_sum == right_sum) {
                return "YES";
            }
        }
        
        return "NO";

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());
        // Process file data and pass in each array of nums to function
        for (int TItr = 0; TItr < T; TItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr.add(arrItem);
            }

            String result = balancedSums(arr);
            // Print out result of each array
            System.out.println(result);
            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
