import java.util.HashSet;

public class DeleteDups {

    public static void main(String[] args) {
        Node head = null;
        Node last = null;

        for(int i = 0; i < args.length; i++) {
            if(head == null) {
                head = new Node(Integer.parseInt(args[i]));
                last = head;
            } else {
                last.next = new Node(Integer.parseInt(args[i]));
                last = last.next;
            }
        }

        System.out.println("Before deleting duplicates");
        System.out.println(head);

        deleteDups2(head);

        System.out.println("After deleting duplicates");
        System.out.println(head);
    }

    /* Write code to remove duplicates from an unsorted linked list.
     * FOLLOW UP
     * How would you solve this problem if a temporary buffer is not allowed?
     */

    /* Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static void deleteDups1(Node head) {
        if(head == null)
            return;

        HashSet<Integer> h = new HashSet<Integer>();
        h.add(head.data);
        Node prev = head;
        Node current = prev.next;

        while(current != null) {
            if(h.contains(current.data)) {
                prev.next = current.next;
                current = prev.next;
            } else {
                h.add(current.data);
                prev = current;
                current = prev.next;
            }
        }
    }

    /* Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public static void deleteDups2(Node head) {
        Node current = head;

        while(current != null) {
            Node prev = current;

            while(prev.next != null) {
                if(prev.next.data == current.data)
                    prev.next = prev.next.next;
                else
                    prev = prev.next; 
            }

            current = current.next;
        }
    }
}
