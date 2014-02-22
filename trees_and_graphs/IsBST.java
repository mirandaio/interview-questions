public class IsBST {

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

        n5.left = n2;
        n5.right = n8;
        n2.left = n1;
        n2.right = n4;
        n8.left = n6;
        n4.left = n3;
        n6.right = n7;

        System.out.println("Is BST? " + isBST(n5));
    }

    /* Implement a function to check if a binary tree is a binary search tree.
     */

    // Time complexity: O(n)
    public static boolean isBST(TreeNode node) {
        return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST(TreeNode node, int min, int max) {
        if(node == null)
            return true;

        if(node.value <= min || node.value > max)
            return false;

        return isBST(node.left, min, node.value) && 
            isBST(node.right, node.value, max);
    }
}
