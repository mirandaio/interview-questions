public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(data);
        Node n = next;

        while(n != null) {
            result.append(" -> ");
            result.append(n.data);
            n = n.next;
        }

        return result.toString();
    }
}
