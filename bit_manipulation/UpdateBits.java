public class UpdateBits {

    public static void main(String[] args) {
        if(args.length < 4) {
            System.out.println("You need to enter four integers (N, M, i, j)");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int i = Integer.parseInt(args[2]);
        int j = Integer.parseInt(args[3]);

        System.out.println(updateBits(n, m, i, j));
    }

    /* You are given two 32-bit numbers, N and M, and two bit positions, i and
     * j. Write a method to insert M into N such that M starts at bit j and
     * ends at bit i. You can assume that the bits j through i have enough
     * space to fit all of M. That is, if M = 10011, you can assume that there
     * are at least 5 bits between j and i. You would not, for example, have
     * j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
     *
     * EXAMPLE
     * Input:  N = 10000000000, M = 10011, i = 2, j = 6
     * Output: N = 10001001100
     */
    public static int updateBits(int n, int m, int i, int j) {
        int allOnes = ~0;
        // Clear bits j through i of N
        int left = allOnes << (j + 1);
        int right = (1 << i) - 1;
        int mask = left | right;
        n = n & mask;

        // Shift M so that it lines up with bits j through i
        m = m << i;
        m = m & (~mask);

        // Merge N and M
        return n | m;
    }
}
