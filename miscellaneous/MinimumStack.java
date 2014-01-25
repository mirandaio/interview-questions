/* Describe a stack data structure that supports "push", "pop", and
 * "find minimum" operations. "Find minimum" returns the smallest element 
 * in the stack.
 */
public class MininumStack {
    
    Stack<Integer> s;
    Stack<Integer> mins;

    public MinimumStack() {
        s = new Stack<Integer>();
        mins = new Stack<Integer>();
    }

    public void push(int n) {
        if(n <= mins.peek())
            mins.push(n);

        s.push(n);
    }

    public int pop() {
        int n = s.pop();

        if(n == mins.peek())
            mins.pop();

        return n;
    }

    public int findMin() {
        if(mins.isEmpty())
            return Integer.MAX_VALUE;

        return mins.peek();
    }
}
