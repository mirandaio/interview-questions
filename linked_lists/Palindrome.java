import java.util.Stack;

public class Palindrome {

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

        System.out.println("Linked list entered:");
        System.out.println(head);
        System.out.println("is palindrome1? " + isPalindrome1(head));
        System.out.println("is palindrome2? " + isPalindrome2(head));
    }

    /* Implement a function to check if a linked list is a palindrome.
     */

    // Time complexity: O(N)
    // Space complexity: O(N)
    public static boolean isPalindrome1(Node n) {
        Node n2 = reverseCopy(n);

        while(n != null) {
            if(n2.data != n.data)
                return false;

            n = n.next;
            n2 = n2.next;
        }

        return true;
    }

    // Time complexity: O(N)
    // Space complexity: O(N)
    public static boolean isPalindrome2(Node n) {
        Stack<Node> s = new Stack<Node>();
        Node slow = n;
        Node fast = n;

        while(fast != null && fast.next != null) {
            s.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        // if the length is odd, skip the middle element
        if(fast != null)
            slow = slow.next;

        while(slow != null) {
            if(s.pop().data != slow.data)
                return false;

            slow = slow.next;
        }

        return true;
    }

    public static Node reverseCopy(Node n1) {
        Node n2 = null;

        while(n1 != null) {
            Node n = new Node(n1.data);
            n.next = n2;
            n2 = n;
            n1 = n1.next;
        }

        return n2;
    }
}
