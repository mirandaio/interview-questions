public class PrintBinary {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter a string representing a " +
                "decimal number.");
            System.exit(1);
        }

        double num = Double.parseDouble(args[0]);

        System.out.println("The binary representation of " + num + " is: " +
            printBinary(num));
    }

    /* Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a
     * double, print the binary representation. If the number cannot be
     * represented accurately in binary with less than 32 characters, print 
     * "ERROR".
     */
    public static String printBinary(double num) {
        if(num <= 0 || num >= 1)
            return "ERROR";

        StringBuilder binary = new StringBuilder();
        binary.append(".");

        while(num > 0) {
            if(binary.length() >= 32)
                return "ERROR";

            num *= 2;

            if(num >= 1) {
                binary.append("1");
                num--;
            } else {
                binary.append("0");
            }
        }

        return binary.toString();
    }
}
