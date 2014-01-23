import java.util.HashSet;

public class IsUniqueChars {

    public static void main(String[] args) {
        String str = "some string";

        System.out.println("str: " + str);
        System.out.println(isUniqueChars2(str));
    }
    
    /* Implement an algorithm to determine if a string has all unique 
     * characters. What if you cannot use additional data structures?
     */

    /* Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static boolean isUniqueChars1(String str) {
        HashSet<Character> h = new HashSet<Character>();

        for(int i = 0; i < str.length(); i++) {
            if(h.contains(str.charAt(i)))
                return false;

            h.add(str.charAt(i));
        }

        return true;
    }

    /* Assumes that the String only has ASCII characters
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static boolean isUniqueChars2(String str) {
        if(str.length() > 256)
            return false;

        boolean[] char_set = new boolean[256];

        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);

            if(char_set[val])
                return false;

            char_set[val] = true;
        }

        return true;
    }
}
