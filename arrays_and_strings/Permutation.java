import java.util.HashMap;
import java.util.Arrays;

public class Permutation {

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("You need to give two arguments.");
            System.exit(1);
        }

        String str1 = args[0];
        String str2 = args[1];

        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println(permutation3(str1, str2));
    }

    /* Given two strings, write a method to decide if one is a permutation of 
     * the other */

    /* Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static boolean permutation1(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;

        HashMap<Character, Integer> h = new HashMap<Character, Integer>();

        for(int i = 0; i < str1.length(); i++) {
            char key1 = str1.charAt(i);
            char key2 = str2.charAt(i);

            if(h.containsKey(key1))
                h.put(key1, h.get(key1) + 1);
            else
                h.put(key1, 1);

            if(h.containsKey(key2))
                h.put(key2, h.get(key2) - 1);
            else
                h.put(key2, -1);
        }

        for(Character key : h.keySet()) {
            if(h.get(key) != 0)
                return false;
        }

        return true;
    }

    /* This solution assumes that the strings only contain ASCII characters
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static boolean permutation2(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;

        int[] char_set = new int[256];

        for(int i = 0; i < str1.length(); i++) {
            int val = str1.charAt(i);
            char_set[val]++;
        }

        for(int i = 0; i < str2.length(); i++) {
            int val = str2.charAt(i);
            char_set[val]--;

            if(char_set[val] < 0)
                return false;
        }

        return true;
    }

    /* Time complexity: O(n lg n)
     * Space complexity: O(n)
     */
    public static boolean permutation3(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        str1 = new String(arr1);
        str2 = new String(arr2);

        return str1.equals(str2);
    }
}
