/* How would you design a stack which, in addition to push and pop, also has
 * a function min which returns the minimum element? Push, pop, and min should
 * all operate in O(1) time.
 */
import java.util.Stack;

public class StackWithMin extends Stack<Integer> {
    Stack<Integer> mins;

    public StackWithMin() {
        mins = new Stack<Integer>();
    }

    public void push(int n) {
        super.push(n);

        if(n <= min())
            mins.push(n);
    }

    public Integer pop() {
        int val = super.pop();

        if(val == min())
            mins.pop();

        return val;
    }

    public int min() {
        if(mins.isEmpty())
            return Integer.MAX_VALUE;

        return mins.peek();
    }
}
