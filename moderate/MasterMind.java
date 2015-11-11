/* The Game of Master Mind is played as follows:
 *
 * The computer has four slots, and each slot will contain a ball that is red
 * (R), yellow (Y), green (G) or blue (B). For example, the computer might
 * have RGGB (Slot #1 is red, Slots #2 and #3 are green, Slot #4 is blue).
 *
 * You, the user, are trying to guess the solution. You might, for example,
 * guess YRGB.
 *
 * When you guess the correct color for the correct slot, you get a "hit". If
 * you guess a color that exists but is in the wrong slot, you get a
 * "pseudo-hit". Note that a slot that is a hit can never count as a 
 * pseudo-hit.
 *
 * For example, if the actual solution is RGBY and you guess GGRR, you have
 * one hit and one pseudo-hit.
 *
 * Write a method that, given a guess and a solution, returns the number of
 * hits and pseudo-hits.
 */

public class MasterMind {

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("You need to enter a solution and guess for" +
                " a game of Master Mind");
            System.exit(1);
        }

        char[] sol = args[0].toCharArray();
        char[] guess = args[1].toCharArray();
        int[] results = mastermind(solution, guess);

        System.out.println("Number of hits: " + results[0]);
        System.out.println("Number of pseudo-hits: " + results[1]);
    }
        
    public static int[] mastermind(char[] sol, char[] guess) {
        int hits = 0;
        int pseudo = 0;
        int[] solCounts = new int[128]; // assume lower ASCII (use HashMap or some such?)
        int[] guessCounts = new int[128]; // assume lower ASCII (use HashMap or some such?)

        // Check for hits - O(n)
        for(int i = 0; i < sol.length; i++) {
            char s = sol[i];
            char g = guess[i];
            if(s == g) {
                hits++;
            } else {
                solCounts[(int)s]++;
                guessCounts[(int)g]++;
            }
        }
        
        // Check for pseudo-hits - O(k)
        for(int i = 0; i < solCounts.lenth; i++) {
            pseudo += java.lang.Math.min(solCounts[i], guessCounts[i]);
        }

        return new int[] {hits, pseudo};
    }
}
