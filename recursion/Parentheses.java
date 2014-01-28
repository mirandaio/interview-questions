import java.util.LinkedList;

public class Parentheses {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter a non-negative integer.");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);

        System.out.println("Valid combinations of " + n + " pairs of " +
            "parentheses:");

        LinkedList<String> validParens = generateParens(n);

        for(String parens : validParens)
            System.out.println(parens);
    }

    /* Implement an algorithm to print all valid (i.e., properly opened and
     * closed) combinations of n-pairs of parentheses.
     */
    public static LinkedList<String> generateParens(int n) {
        LinkedList<String> list = new LinkedList<String>();
        char[] str = new char[2 * n];
        generateParens(list, n, n, str, 0);
        return list;
    }

    public static void generateParens(LinkedList<String> list, int left,
        int right, char[] str, int count) {
        if(left == 0 && right == 0) {
            String parens = new String(str);
            list.add(parens);
            return;
        }

        if(left > 0) {
            str[count] = '(';
            generateParens(list, left - 1, right, str, count + 1);
        }

        if(left < right) {
            str[count] = ')';
            generateParens(list, left, right - 1, str, count + 1);
        }
    }
}
