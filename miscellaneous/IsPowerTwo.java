public class IsPowerTwo {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter an integer.");
            System.exit(1);
        }

        int x = Integer.parseInt(args[0]);
        System.out.println("Is " + x + " a power of two? " + isPowerTwo(x));
    }

    /* How can you quickly determine whether a number is a power of 2?
     */
    public static boolean isPowerTwo(int x) {
        return (x & (x - 1)) == 0 && x != 0;
    }
}
