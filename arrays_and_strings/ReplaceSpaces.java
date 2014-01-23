public class ReplaceSpaces {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to give a string argument");
            System.exit(1);
        }

        char[] str = args[0].toCharArray();
        char[] newStr;
        int newLength;
        int count = 0;

        for(int i = 0; i < str.length; i++) {
            if(str[i] == ' ')
                count++;
        }

        newLength = str.length + 2 * count + 1;
        newStr = new char[newLength];

        for(int i = 0; i < str.length; i++)
            newStr[i] = str[i];

        replaceSpaces(newStr, str.length);

        System.out.println("str: " + args[0]);
        System.out.println("newStr: " + new String(newStr, 0, newLength - 1)); 
    }

    /* Write a method to replace all spaces in a string with '%20'. You may 
     * assume that the string has sufficient space at the end of the string
     * to hold the additional characters, and that you are given the "true" 
     * length of the string.
     */
    public static void replaceSpaces(char[] str, int length) {
        int count = 0;
        int newLength;

        for(int i = 0; i < length; i++) {
            if(str[i] == ' ')
                count++;
        }

        newLength = length + 2 * count;
        str[newLength] = '\0';

        for(int i = length - 1, j = newLength - 1; i >= 0; i--) {
            if(str[i] == ' ') {
                str[j] = '0';
                str[j-1] = '2';
                str[j-2] = '%';
                j -= 3;
            } else {
                str[j] = str[i];
                j--;
            }
        }
    }
}


