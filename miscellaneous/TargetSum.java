import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class TargetSum {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        String input = null;
        String[] nums;
        int target = 0;
        int[] arr;

        System.out.println("Enter some integers:");

        try {
            input = br.readLine();
        } catch(IOException ioe) {
            System.out.println("Could not read line of input.");
            System.exit(1);
        }

        System.out.println("Enter an integer:");

        try {
            target = Integer.parseInt(br.readLine());
        } catch(IOException ioe) {
            System.out.println("Could not read line of input.");
            System.exit(1);
        }

        nums = input.split("\\s+");
        arr = new int[nums.length];

        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(nums[i]);

        System.out.println("Can find two numbers in the array that sum to " +
            target + "?");
        System.out.println(targetSum(target, arr));
    }

    /* Given an integer x and an unsorted array of integers, describe an 
     * algorithm to determine whether two of the numbers add up to x.
     */
    public static boolean targetSum(int x, int[] arr) {
        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++) {
            int val = x - arr[i];

            int index = Arrays.binarySearch(arr, val);

            if(index >= 0 && index != i)
                return true;
        }

        return false;
    }
}
