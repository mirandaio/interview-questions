import java.util.HashSet;

public class MakeChange {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter an integer.");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);

        System.out.println("Number of ways to represent " + n + " cents: " +
            makeChange2(n));
    }

    /* Given an infinite number of quarters (25 cents), dimes (10 cents),
     * nickels (5 cents) and pennies (1 cent), write code to calculate the
     * number of ways of representing n cents.
     */

    // very slow
    public static int makeChange(int n) {
        HashSet<String> set = new HashSet<String>();
        return makeChange(n, 0, 0, 0, 0, set);
    }

    public static int makeChange(int rem, int q, int d, int n, int p,
        HashSet<String> set) {
        if(rem < 0)
            return 0;

        if(rem == 0) {
            String str = q + "|" + d + "|" + n + "|" + p;

            if(set.contains(str))
                return 0;

            set.add(str);
            return 1;
        }

        return makeChange(rem - 25, q + 1, d, n, p, set) +
            makeChange(rem - 10, q, d + 1, n, p, set) +
            makeChange(rem - 5, q, d, n + 1, p, set) +
            makeChange(rem - 1, q, d, n, p + 1, set);
    }

    public static int makeChange2(int n) {
        return makeChange2(n, 25);
    }

    public static int makeChange2(int n, int denom) {
        int next_denom = 0;

        switch(denom) {
        case 25:
            next_denom = 10;
            break;
        case 10:
            next_denom = 5;
            break;
        case 5:
            next_denom = 1;
            break;
        case 1:
            return 1;
        }

        int ways = 0;

        for(int i = 0; i * denom <= n; i++)
            ways += makeChange2(n - i * denom, next_denom);

        return ways;
    }
}
