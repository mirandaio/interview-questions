public class RansomNote {

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("You need to enter a ransom note and the " +
                "contents of the magazines both in quotes.");
            System.exit(1);
        }

        String note = args[0];
        String mag = args[1];

        System.out.println("Ransom note: " + note);
        System.out.println("Magazine contents: " + mag);
        System.out.println("Can construct ransom note from mag contents?");
        System.out.println(ransomNote2(note, mag));
    }

    /* You need to write a ransom note by cutting letters out of the available 
     * magazines and pasting them together to form a letter. Given an arbitrary
     * ransom note string and another string containing all the contents of all
     * the magazines, write a function that will return true if the ransom 
     * note can be made from the magazines; otherwise, it will return false.
     * Every letter found in the magazine string can only be used once in your
     * ransom note.
     */
    public static boolean ransomNote1(String note, String mag) {
        int[] count = new int[256]; // Assumes only ASCII characters

        for(int i = 0; i < mag.length(); i++) {
            int c = mag.charAt(i);
            count[c]++;
        }

        for(int i = 0; i < note.length(); i++) {
            int c = note.charAt(i);
            count[c]--;

            if(count[c] < 0)
                return false;
        }

        return true;
    }

    public static boolean ransomNote2(String note, String mag) {
        int[] count = new int[256]; // Assumes only ASCII characters
        int n = 0;
        int m = 0;

        while(n < note.length()) {
            int nchar = note.charAt(n);

            if(count[nchar] > 0) {
                count[nchar]--;
                n++;
            } else {
                while(m < mag.length() && mag.charAt(m) != nchar) {
                    int mchar = mag.charAt(m);
                    count[mchar]++;
                    m++;
                }

                if(m >= mag.length())
                    return false;

                n++;
                m++;
            }
        }

        return true;
    }
}
