public class FindBeginning {

    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n9;

        System.out.println("Beginning of cycle:");
        Node beginning = findBeginning(n0);

        if(beginning == null)
            System.out.println("There is no cycle.");
        else
            System.out.println(beginning.data);
    }

    /* Given a circular linked list, implement an algorithm which returns the
     * node at the beginning of the loop.
     */
    public static Node findBeginning(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                break;
        }

        // There was no cycle, so return null
        if(fast == null || fast.next == null)
            return null;

        // both slow and fast are at collision node
        slow = head;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
