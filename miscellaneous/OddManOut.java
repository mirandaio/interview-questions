import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class OddManOut {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        String[] nums = null;
        int[] arr;

        System.out.println("Enter integers where every integer appears " +
            "exactly twice, except for one integer which appears only once.");

        try {
            nums = br.readLine().split("\\s+");
        } catch(IOException ioe) {
            System.out.println("Could not read line of input.");
            System.exit(1);
        }

        arr = new int[nums.length];

        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(nums[i]);

        System.out.println("Integer that appears only once: " + 
            oddManOut2(arr));
    }

    /* You're given an unsorted array of integers where every integer appears 
     * exactly twice, except for one integer which appears only once. Write 
     * an algorithm that finds the integer that appears only once.
     */
    public static int oddManOut1(int[] arr) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                sum -= arr[i];
            } else {
                sum += arr[i];
                set.add(arr[i]);
            }
        }

        return sum;
    }

    // Solution using XOR
    public static int oddManOut2(int[] arr) {
        System.out.println("Using XOR");
        int n = 0;

        for(int i = 0; i < arr.length; i++)
            n ^= arr[i];

        return n;
    }

}
