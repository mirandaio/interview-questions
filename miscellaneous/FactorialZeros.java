public class FactorialZeros {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter a positive integer");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);

        System.out.println("Number of zeros in " + n + "!");
        System.out.println(factorialZeros(n));
    }

    /* How many zeros are at the end of n!?
     */
    public static int factorialZeros(int n) {
        int count = 0;

        for(int i = 5; i <= n; i += 5)
            count += count5(i);

        return count;
    }

    public static int count5(int n) {
        if(n == 0)
            return 0;

        int count = 0;

        while(n % 5 == 0) {
            count++;
            n /= 5;
        }

        return count;
    }
}
