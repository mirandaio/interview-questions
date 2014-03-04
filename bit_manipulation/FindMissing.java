import java.util.ArrayList;

public class FindMissing {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter an array of integers " +
            "from 0 to n with one of the integers missing.");
            System.exit(1);
        }

        ArrayList<BitInteger> a = new ArrayList<BitInteger>(args.length);

        for(int i = 0; i < args.length; i++) {
            a.add(new BitInteger(Integer.parseInt(args[i])));
        }

        System.out.println("Missing integer: " + findMissing(a));
    }

    /* An array A[1...n] contains all the integers from 0 to n, except for one
     * number which is missing. In this problem, we cannot access an entire
     * integer in A with a single operation. The elements of A are represented
     * in binary, and the only operation we can use to access them is
     * "fetch the jth bit of A[i]", which takes constant time. Write code to
     * find the missing integer. Can you do it in O(n) time?
     */

    public static int findMissing(ArrayList<BitInteger> a) {
        return findMissing(a, BitInteger.INTEGER_SIZE - 1);
    }

    public static int findMissing(ArrayList<BitInteger> a, int col) {
        if(col < 0)
            return 0;

        ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>(a.size()/2);
        ArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>(a.size()/2);

        for(BitInteger num : a) {
            if(num.fetch(col) == 0) {
                zeroBits.add(num);
            } else {
                oneBits.add(num);
            }
        }

        if(zeroBits.size() <= oneBits.size()) {
            int v = findMissing(zeroBits, col - 1);
            return v << 1;
        } else {
            int v = findMissing(oneBits, col - 1);
            return (v << 1) | 1;
        }
    }
}
