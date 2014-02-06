import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();

        for(int i = 0; i < args.length; i++)
            s.push(Integer.parseInt(args[i]));

        System.out.println("Stack before sorting:");
        System.out.println(s);

        sort(s);

        System.out.println("Stack after sorting:");
        System.out.println(s);
    }

    /* Write a program to sort a stack in ascending order. You may use
     * additional stacks to hold items, but you may not copy the elements
     * into any other data structure (such as an array). The stack supports
     * the following operations: push, pop, peek, and isEmpty.
     */
    public static void sort(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<Integer>();

        while(!s.isEmpty()) {
            int n = s.pop();

            while(!temp.isEmpty() && n > temp.peek())
                s.push(temp.pop());

            temp.push(n);
        }

        while(!temp.isEmpty())
            s.push(temp.pop());
    }
}
