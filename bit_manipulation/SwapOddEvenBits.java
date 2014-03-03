public class SwapOddEvenBits {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter an integer.");
            System.exit(1);
        }

        int num = Integer.parseInt(args[0]);
        System.out.println("After swapping odd and even bits: " +
            swapOddEvenBits(num));
    }

    /* Write a program to swap odd and even bits in an integer with as few
     * instructions as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and
     * bit 3 are swapped, and so on).
     */
    public static int swapOddEvenBits(int num) {
        return ((num << 1) & 0xAAAAAAAA) | ((num >> 1) & 0x55555555);
    }
}
