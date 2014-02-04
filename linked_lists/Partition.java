import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Partition {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        String[] nums = null;
        int x = -1;
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

        System.out.println("Enter integer x:");
        
        try {
            x = Integer.parseInt(br.readLine());
        } catch(IOException ioe) {
            System.out.println("Could not read x.");
            System.exit(1);
        }

        System.out.println("Linked list entered:");
        System.out.println(head);
        System.out.println("x: " + x);

        head = partition(head, x);

        System.out.println("Linked list after partition:");
        System.out.println(head);
    }

    /* Write code to partition a linked list around a value x, such that all
     * nodes less than x come before all nodes greater than or equal to x.
     */
    public static Node partition(Node node, int x) {
        Node less = null;
        Node lessLast = null;
        Node greater = null;
        Node greaterLast = null;

        while(node != null) {
            Node next = node.next;
            node.next = null;

            if(node.data < x) {
                if(less == null) {
                    less = node;
                    lessLast = node;
                } else {
                    lessLast.next = node;
                    lessLast = node;
                }
            } else {
                if(greater == null) {
                    greater = node;
                    greaterLast = node;
                } else {
                    greaterLast.next = node;
                    greaterLast = node;
                }
            }

            node = next;
        }

        if(lessLast == null)
            return greater;

        lessLast.next = greater;
        return less;
    }
}
