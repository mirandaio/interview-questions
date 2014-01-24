public class ReverseWords {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Enter a string in double quotes");
            System.exit(1);
        }

        System.out.println("String entered: " + args[0]);
        char[] str = args[0].toCharArray();
        reverseWords(str);
        String reverse = new String(str);
        System.out.println("After reverseWords: " + reverse);
    }

    /* Write a function to reverse the order of words in a string in place.
     */
    public static void reverseWords(char[] str) {
        int start = 0;
        int end = 0;
        reverse(str, 0, str.length - 1);

        while(start < str.length) {
            if(Character.isWhitespace(str[start])) {
                start++;
            } else {
                end = start + 1;

                while(end < str.length && !Character.isWhitespace(str[end]))
                    end++;

                reverse(str, start, end - 1);

                start = end;
            }
        }
    }

    public static void reverse(char[] arr, int start, int end) {
        while(start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
