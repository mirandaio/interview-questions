import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DeleteNode {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        String[] nums = null;
        int k = -1;
        Node head = null;
        Node last = null;
        Node node;

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

        System.out.println("Enter the postion of node to delete:");
        
        try {
            k = Integer.parseInt(br.readLine());
        } catch(IOException ioe) {
            System.out.println("Could not read k.");
            System.exit(1);
        }

        System.out.println("Linked list entered:");
        System.out.println(head);
        System.out.println("Position of node to delete: " + k);

        node = head;
        while(k > 0) {
            node = node.next;
            k--;
        }

        deleteNode(node);

        System.out.println("Linked list after deleting node:");
        System.out.println(head);
    }

    /* Implement an algorithm to delete a node in the middle of a singly
     * linked list, given only access to that node.
     */
    public static boolean deleteNode(Node n) {
        if(n == null || n.next == null)
            return false; // cannot delete last node

        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }
}
