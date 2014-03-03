public class NextPrevious {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter a positive integer.");
            System.exit(1);
        }

        int num = Integer.parseInt(args[0]);

        System.out.println("Next largest number with same number of 1 bits: " +
            getNext(num));

        System.out.println("Next smallest number with same number of " +
            "1 bits: " + getPrevious(num));
    }

    /* Given a positive integer, print the next smallest and the next largest
     * number that have the same number of 1 bits in their binary
     * representation.
     */

    // int is 32 bits two's complement
    public static int getNext(int num) {
        if(num <= 0)
            return -1;

        int i = 0;
        int count = 0; // count of 1s before i

        // find first 1 with 0 to its left
        while(i < 31) {
            if(getBit(num, i) && !getBit(num, i + 1))
                break;

            if(getBit(num, i))
                count++;

            i++;
        }

        // was not able to find 1 with 0 to its left
        if(i == 31)
            return -1;

        num = setBit(num, i + 1);
        num = clearBitsIto0(num, i);

        // move the 1s to the right of i all the way to the right
        num = setBitsIto0(num, count - 1);
        return num;
    }

    public static int getPrevious(int num) {
        if(num <= 0)
            return -1;

        // find first 1 with 0 to right
        int i = 1;

        int count = getBit(num, 0) ? 1 : 0;

        while(i < 31) {
            if(getBit(num, i) && !getBit(num, i - 1))
                break;

            if(getBit(num, i))
                count++;

            i++;
        }

        // was not able to find 1 with 0 to right
        if(i == 31)
            return -1;

        num = clearBit(num, i);
        num = setBitsIto0(num, i - 1);
        // move the 1s all the way to the left before i - 1
        num = clearBitsIto0(num, i - count - 2);
        return num;
    }

    public static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    public static int setBit(int num, int i) {
        return num | (1 << i);
    }

    public static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    public static int setBitsIto0(int num, int i) {
        int mask = (1 << (i + 1)) - 1;
        return num | mask;
    }

    public static int clearBitsIto0(int num, int i) {
        int mask = ~((1 << (i + 1)) - 1);
        return num & mask;
    }

    public static int getNext2(int n) {
        int c = n;
        int c0 = 0;
        int c1 = 0;

        while(((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }

        while((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        if(c0 + c1 == 31 || c0 + c1 == 0)
            return -1;

        int p = c0 + c1;

        n |= (1 << p);
        n &= ~((1 << p) - 1);
        n |= (1 << (c1 - 1)) - 1;
        return n;
    }

    public static int getPrevious2(int n) {
        int temp = n;
        int c0 = 0;
        int c1 = 0;

        while(((temp & 1) == 1) && (temp != 0)) {
            c1++;
            temp >>= 1;
        }

        if(temp == 0)
            return -1;

        while((temp & 1) == 0 && (temp != 0)) {
            c0++;
            temp >>= 1;
        }

        int p = c0 + c1;
        n &= ((~0) << (p + 1));

        int mask = (1 << (c1 + 1)) - 1;
        n |= mask << (c0 - 1);

        return n;
    }
}
