/* Implement a MyQueue class which implements a queue using two stacks.
 */
import java.util.Stack;

public class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }

    public int size() {
        return in.size() + out.size();
    }

    public void enqueue(int n) {
        in.push(n);
    }

    public int dequeue() {
        if(out.isEmpty()) {
            while(!in.isEmpty())
                out.push(in.pop());
        }

        return out.pop();
    }

    public int peek() {
        if(out.isEmpty()) {
            while(!in.isEmpty())
                out.push(in.pop());
        }

        return out.peek();
    }
}
