import java.util.Random;
import java.util.Arrays;

public class DeckShuffling {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter one or more distinct " +
                "integers.");
            System.exit(1);
        }

        int[] arr = new int[args.length];

        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(args[i]);

        System.out.println("Before shuffling");
        System.out.println(Arrays.toString(arr));

        deckShuffling(arr);

        System.out.println("After shuffling");
        System.out.println(Arrays.toString(arr));
    }

    /* Given an array of distinct integers, give an algorithm to randomly 
     * reorder the integers so that each possible reordering is equally 
     * likely. In other words, given a deck of cards, how can you shuffle
     * them such that any permutation of cards is equally likely?
     */
    public static void deckShuffling(int[] arr) {
        Random r = new Random();

        for(int i = arr.length - 1; i >= 1; i--) {
            int j = r.nextInt(i + 1);
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }
}
