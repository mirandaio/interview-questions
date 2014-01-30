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
        
        // Check for hits
        for(int i = 0; i < sol.length; i++) {
            if(sol[i] == guess[i]) {
                hits++;
                sol[i] = 'X';
                guess[i] = 'X';
            }
        }
        
        // Check for pseudo-hits
        for(int i = 0; i < sol.length; i++) {
            if(guess[i] != 'X') {
                for(int j = 0; j < sol.length; j++) {
                    if(guess[i] == sol[j]) {
                        pseudo++;
                        guess[i] = 'X';
                        sol[j] = 'X';
                        break;
                    }
                }
            }
        }

        return new int[] {hits, pseudo};
    }
}
