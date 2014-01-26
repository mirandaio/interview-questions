/* Describe a queue data structure that is implemented using one or more 
 * stacks. Write the enqueue and dequeue operations for the queue.
 */
import java.util.Stack;

public class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }

    // Time complexity: O(1)
    public void enqueue(int n) {
        in.push(n);
    }

    // Time complexity: O(1) amortized
    public int dequeue() {
        if(!out.isEmpty())
            return out.pop();

        while(!in.isEmpty())
            out.push(in.pop());

        return out.pop();
    }

    public int size() {
        return in.size() + out.size();
    }
}
