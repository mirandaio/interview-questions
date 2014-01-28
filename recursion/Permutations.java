import java.util.ArrayList;

public class Permutations {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter a string.");
            System.exit(1);
        }

        String str = args[0];
        ArrayList<String> perms = getPerms(str);

        System.out.println("String: " + str);
        System.out.println("Permutations:");

        for(int i = 0; i < perms.size(); i++)
            System.out.println(perms.get(i));
    }

    /* Write a method to compute all permutations of a string.
     */
    public static ArrayList<String> getPerms(String str) {
        if(str == null)
            return null;

        if(str.length() == 0) {
            ArrayList<String> temp = new ArrayList<String>();
            temp.add("");
            return temp;
        }

        char first = str.charAt(0);
        ArrayList<String> without = getPerms(str.substring(1));
        ArrayList<String> with = new ArrayList<String>();

        for(int i = 0; i < without.size(); i++) {
            String s = without.get(i);
            for(int j = 0; j <= s.length(); j++)
                with.add(insert(s, first, j));
        }

        return with;
    }

    public static String insert(String str, char c, int i) {
        return str.substring(0, i) + c + str.substring(i);
    }
}
