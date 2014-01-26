import java.util.HashMap;

public class CountWays {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter the number of stairs.");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);

        System.out.println("Number of ways to go up the stairs: " +
            countWays2(n));

    }

    /* A child is running up a staircase with n steps, and can hop either 1 
     * step, 2 steps, or 3 steps at a time. Implement a method to count how 
     * many possible ways the child can run up the stairs.
     */
    public static int countWays1(int n) {
        if(n < 0)
            return 0;

        if(n == 0)
            return 1;

        return countWays1(n - 1) + countWays1(n - 2) + countWays1(n - 3);
    }

    // Solution using dynamic programming
    public static int countWays2(int n) {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        return countWays2(n, h);
    }

    public static int countWays2(int n, HashMap<Integer, Integer> h) {
        if(h.containsKey(n))
            return h.get(n);

        if(n < 0)
            return 0;

        int ways;

        if(n == 0)
            ways = 1;
        else
            ways = countWays2(n - 1, h) + countWays2(n - 2, h) +
                countWays2(n - 3, h);

        h.put(n, ways);
        return ways;
    }
}
