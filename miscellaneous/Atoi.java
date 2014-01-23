public class Atoi {
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Enter at least one integer");
            System.exit(1);
        }

        for(int i = 0; i < args.length; i++)
            System.out.println(atoi(args[i]));
    }

    /* Write a function to convert a string into an integer */
    public static int atoi(String str) {
        int num = 0;
        boolean isNeg = false;
        int i = 0;

        if(str.charAt(i) == '-') {
            isNeg = true;
            i = 1;
        }

        while(i < str.length()) {
            num = num * 10 + str.charAt(i) - '0';
            i++;
        }

        return isNeg ? -num : num;
    }
}
