import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AddLists {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        String[] num1 = null;
        String[] num2 = null;
        Node head1 = null;
        Node last1 = null;
        Node head2 = null;
        Node last2 = null;

        System.out.println("Enter integers separated by spaces:");

        try {
            num1 = br.readLine().split("\\s+");
            num2 = br.readLine().split("\\s+");
        } catch(IOException ioe) {
            System.out.println("Could not read line of input.");
            System.exit(1);
        }

        for(int i = 0; i < num1.length; i++) {
            if(head1 == null) {
                head1 = new Node(Integer.parseInt(num1[i]));
                last1 = head1;
            } else {
                last1.next = new Node(Integer.parseInt(num1[i]));
                last1 = last1.next;
            }
        }

        for(int i = 0; i < num2.length; i++) {
            if(head2 == null) {
                head2 = new Node(Integer.parseInt(num2[i]));
                last2 = head2;
            } else {
                last2.next = new Node(Integer.parseInt(num2[i]));
                last2 = last2.next;
            }
        }

        System.out.println("Numbers entered:");
        System.out.println(head1);
        System.out.println(head2);
        System.out.println("Sum:");
        System.out.println(addLists1(head1, head2));
        System.out.println(addLists2(head1, head2, 0));
        System.out.println(addLists3(head1, head2));
    }

    /* You have two numbers represented by a linked list, where each node
     * contains a single digit. The digits are stored in reverse order, 
     * such that the 1's digit is at the head of the list. Write a function
     * that adds the two numbers and returns the sum as a linked list.
     */

    // Iterative implementation
    public static Node addLists1(Node n1, Node n2) {
        Node n = null;
        Node last = null;
        int carry = 0;

        while(n1 != null || n2 != null) {
            int sum = carry;

            if(n1 != null) {
                sum += n1.data;
                n1 = n1.next;
            }

            if(n2 != null) {
                sum += n2.data;
                n2 = n2.next;
            }

            if(n == null) {
                n = new Node(sum % 10);
                last = n;
            } else {
                last.next = new Node(sum % 10);
                last = last.next;
            }

            carry = sum / 10;
        }

        if(carry != 0)
            last.next = new Node(carry);

        return n;
    }

    // Recursive solution
    public static Node addLists2(Node n1, Node n2, int carry) {
        if(n1 == null && n2 == null && carry == 0)
            return null;

        int sum = carry;

        if(n1 != null)
            sum += n1.data;

        if(n2 != null)
            sum += n2.data;

        Node result = new Node(sum % 10);

        result.next = addLists2(
            n1 == null ? null : n1.next,
            n2 == null ? null : n2.next,
            sum / 10);

        return result;
    }

    /* Follow up
     * Suppose the digits are stored in forward order. Repeat the above
     * problem.
     */
    public static Node addLists3(Node n1, Node n2) {
        n1 = reverse(n1);
        n2 = reverse(n2);
        Node result = addLists1(n1, n2);
        n1 = reverse(n1);
        n2 = reverse(n2);
        return reverse(result);
    }


    public static Node reverse(Node n) {
        Node prev = null;

        while(n != null) {
            Node next = n.next;
            n.next = prev;
            prev = n;
            n = next;
        }

        return prev;
    }
}
