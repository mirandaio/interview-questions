public class Substring {

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("You need to enter two strings.");
            System.exit(1);
        }

        String str1 = args[0];
        String str2 = args[1];

        System.out.println("Is " + str1 + " a substring of " + str2 + "?");
        System.out.println(substring(str1, str2));
    }

    /* Write a program to determine whether an input string x is a substring
     * of another input string y.
     */
    public static boolean substring(String str1, String str2) {
        for(int i = 0; i <= str2.length() - str1.length(); i++) {
            boolean sub = true;
            for(int j = 0; j < str1.length(); j++) {
                if(str1.charAt(j) != str2.charAt(i + j)) {
                    sub = false;
                    break;
                }
            }

            if(sub)
                return true;
        }

        return false;
    }
}
