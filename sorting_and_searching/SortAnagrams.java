import java.util.HashMap;
import java.util.LinkedList;
import java.util.Arrays;

public class SortAnagrams {

    public static void main(String[] args) {
        System.out.println("Before sorting: " + Arrays.toString(args));
        sortAnagrams(args);
        System.out.println("After sorting : " + Arrays.toString(args));
    }

    /* Write a method to sort an array of strings so that all the anagrams are
     * next to each other.
     */
    public static void sortAnagrams(String[] arr) {
        HashMap<String, LinkedList<String>> map = new
            HashMap<String, LinkedList<String>>();

        for(int i = 0; i < arr.length; i++) {
            String key = sortChars(arr[i]);

            if(!map.containsKey(key)) {
                map.put(key, new LinkedList<String>());
            }

            LinkedList<String> list = map.get(key);
            list.add(arr[i]);
        }

        int i = 0;
        for(String key : map.keySet()) {
            LinkedList<String> list = map.get(key);
            for(String str : list) {
                arr[i] = str;
                i++;
            }
        }
    }

    public static String sortChars(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
