import java.util.LinkedList;

public class FindSum {

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode neg5 = new TreeNode(-5);

        n1.left = n0;
        n1.right = n3;

        n0.left = n9;
        n0.right = n2;

        n3.left = n6;
        n3.right = n7;

        n9.right = n10;

        n2.left = n8;

        n6.right = n4;

        n8.right = neg5;

        neg5.left = n5;

        findSum(n1, 10);
    }

    /* You are given a binary tree in which each node contains a value. Design
     * an algorithm to print all paths which sum to a given value. Note that a
     * path can start or end anywhere in the tree.
     */
    public static void findSum(TreeNode node, int target) {
        int[] path = new int[depth(node)];
        findSum(node, target, path, 0);
    }

    public static void findSum(TreeNode node, int target, int[] path, int i) {
        if(node == null)
            return;

        path[i] = node.value;
        i++;

        printPaths(path, i, target);

        findSum(node.left, target, path, i);
        findSum(node.right, target, path, i);

        i--;
        path[i] = Integer.MIN_VALUE;
    }

    public static void printPaths(int[] path, int len, int target) {
        int sum = 0;
        for(int i = len - 1; i >= 0; i--) {
            sum += path[i];

            if(sum == target) {
                for(int j = i; j < len; j++)
                    System.out.print(path[j] + " ");

                System.out.println();
            }
        }
    }

    public static int depth(TreeNode node) {
        if(node == null)
            return 0;

        return 1 + Math.max(depth(node.left), depth(node.right));
    }

    // Simpler version assuming path can only start at the root but end 
    // anywhere.
    public static void simpleFindSum(TreeNode node, int value) {
        LinkedList<Integer> path = new LinkedList<Integer>();
        simpleFindSum(node, path, value);
    }

    public static void simpleFindSum(TreeNode node, LinkedList<Integer> path,
            int value) {

        if(node == null)
            return;

        path.add(node.value);

        if(value == node.value) {
            for(int i : path)
                System.out.print(i + " ");

            System.out.println();
        }

        simpleFindSum(node.left, path, value - node.value);
        simpleFindSum(node.right, path, value - node.value);
        path.remove(path.size() - 1);
    }
}
