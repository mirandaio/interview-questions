public class BitSwapRequired {

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("You need to enter 2 integers.");
            System.exit(1);
        }

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("Number of bits to swap: " + bitSwapRequired(a, b));
    }

    /* Write a function to determine the number of bits required to convert
     * integer A to integer B.
     *
     * EXAMPLE
     * Input: 31, 14
     * Output: 2
     */
    public static int bitSwapRequired(int a, int b) {
        int count = 0;

        for(int c = a ^ b; c != 0; c >>= 1) {
            count += (c & 1);
        }

        return count;
    }

    public static int bitSwapRequired2(int a, int b) {
        int count = 0;

        for(int c = a ^ b; c != 0; c = c & (c - 1)) {
            count++;
        }

        return count;
    }
}
