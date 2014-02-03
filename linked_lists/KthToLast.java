import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class KthToLast {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        String[] nums = null;
        int k = -1;
        Node head = null;
        Node last = null;

        System.out.println("Enter integers separated by spaces:");

        try {
            nums = br.readLine().split("\\s+");
        } catch(IOException ioe) {
            System.out.println("Could not read line of input.");
            System.exit(1);
        }

        for(int i = 0; i < nums.length; i++) {
            if(head == null) {
                head = new Node(Integer.parseInt(nums[i]));
                last = head;
            } else {
                last.next = new Node(Integer.parseInt(nums[i]));
                last = last.next;
            }
        }

        System.out.println("Enter k:");

        try {
            k = Integer.parseInt(br.readLine());
        } catch(IOException ioe) {
            System.out.println("Could not read k.");
            System.exit(1);
        }

        System.out.println("Linked list entered:");
        System.out.println(head);
        System.out.println("k: " + k);
        System.out.println("kth to last element: " + kthToLast(head, k).data);
    }

    /* Implement an algorithm to find the kth to last element of a singly
     * linked list.
     */

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static Node kthToLast(Node head, int k) {
        Node fast = head;
        Node slow = head;

        while(k > 0) {
            if(fast == null)
                return null;

            fast = fast.next;
            k--;
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
