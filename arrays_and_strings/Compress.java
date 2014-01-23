public class Compress {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter one argument");
            System.exit(1);
        }

        String str = args[0];

        System.out.println("str: " + str);
        System.out.println("compressed: " + compress2(str));
    }

    /* Implement a method to perform basic string compression using the counts 
     * of repeated characters. For example, the string aabcccccaaa would 
     * become a2b1c5a3. If the "compressed" string would not become smaller
     * than the original string, your method should return the original string.
     */

    public static String compress1(String str) {
        if(str.length() < 1)
            return str;

        StringBuilder result = new StringBuilder();
        String newStr;

        char previous = str.charAt(0);
        int count = 1;

        for(int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);

            if(current == previous) {
                count++;
            } else {
                result.append(previous);
                result.append(count);
                previous = current;
                count = 1;
            }
        }

        result.append(previous);
        result.append(count);
        newStr = result.toString();
        return str.length() <= newStr.length() ? str : newStr;
    }

    public static String compress2(String str) {
        int newLength = countCompression(str);

        if(str.length() <= newLength)
            return str;

        char[] result = new char[newLength];
        int index = 0;
        char last = str.charAt(0);
        int count = 1;

        for(int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);

            if(current == last) {
                count++;
            } else {
                index = setChar(result, last, index, count);
                last = current;
                count = 1;
            }
        }

        setChar(result, last, index, count);
        return new String(result);
    }

    public static int setChar(char[] str, char c, int index, int count) {
        str[index] = c;
        index++;
        char[] number = String.valueOf(count).toCharArray();

        for(char d : number) {
            str[index] = d;
            index++;
        }

        return index;
    }

    public static int countCompression(String str) {
        if(str.length() < 1)
            return 0;

        int total = 0;
        char last = str.charAt(0);
        int count = 1;

        for(int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);

            if(current == last) {
                count++;
            } else {
                total += 1 + String.valueOf(count).length();
                last = current;
                count = 1;
            }
        }

        total += 1 + String.valueOf(count).length();
        return total;
    }
}
