import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RemoveDoubly {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        String input = null;
        String[] nums;
        int val = 0;
        Node head = null;
        Node last = null;

        System.out.println("Enter a sequence of integers: ");

        try {
            input = br.readLine();
        } catch(IOException ioe) {
            System.out.println("Could not read line of input.");
            System.exit(1);
        }

        System.out.println("Enter value to remove:");

        try {
            val = Integer.parseInt(br.readLine());
        } catch(IOException ioe) {
            System.out.println("Could not read line of input.");
            System.exit(1);
        }

        nums = input.split("\\s+");

        for(int i = 0; i < nums.length; i++) {
            if(head == null) {
                head = new Node(Integer.parseInt(nums[i]));
                last = head;
            } else {
                last.next = new Node(Integer.parseInt(nums[i]));
                last.next.prev = last;
                last = last.next;
            }
        }

        System.out.println("Before removing value: " + head.toString());
        head = remove(head, val);
        System.out.print("After removing value: ");

        if(head == null)
            System.out.println("empty");
        else
            System.out.println(head.toString());

    }

    /* Write a function to remove a single occurrence of an integer from a 
     * doubly linked list if it is present.
     */
    public static Node remove(Node head, int n) {
        if(head == null)
            return null;

        if(head.data == n) {
            if(head.next != null) {
                head = head.next;
                head.prev = null;
                return head;
            } else {
                return null;
            }
        }

        Node node = head;

        while(node != null) {
            if(node.data == n) {
                if(node.prev != null)
                    node.prev.next = node.next;

                if(node.next != null)
                    node.next.prev = node.prev;

                return head;
            }

            node = node.next;
        }

        return head;
    }
}
