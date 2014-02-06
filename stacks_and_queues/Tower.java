import java.util.Stack;

public class Tower {
    private Stack<Integer> disks;
    private int index;

    public Tower(int i) {
        disks = new Stack<Integer>();
        index = i;
    }

    public int index() {
        return index;
    }

    public void add(int d) {
        if(!disks.isEmpty() && disks.peek() <= d)
            System.out.println("Error placing disk " + d);
        else
            disks.push(d);
    }

    public void moveTopTo(Tower t) {
        int top = disks.pop();
        t.add(top);
        System.out.println("Move disk " + top + " from " + index() + " to " + 
            t.index());
    }

    public void moveDisks(int n, Tower destination, Tower buffer) {
        if(n <= 0)
            return;

        moveDisks(n - 1, buffer, destination);
        moveTopTo(destination);
        buffer.moveDisks(n - 1, destination, this);
    }
}

