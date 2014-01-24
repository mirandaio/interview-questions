public class PowerTwo {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter a non-negative integer");
            System.exit(1);
        }

        int x = Integer.parseInt(args[0]);
        System.out.println("2^" + x + " = " + exp(x));
    }

    /* How can you quickly compute 2^x?
     */
    public static int exp(int x) {
        return 1 << x;
    }
}
