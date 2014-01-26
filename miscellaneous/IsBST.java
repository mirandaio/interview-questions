public class IsBST {

    /* Write a function to determine whether a given binary tree of distinct
     * integers is a valid binary search tree. Assume that each node contains 
     * a pointer to its left child, a pointer to its right child, and an 
     * integer, but not a pointer to its parent.
     */
    public static boolean isBST(TreeNode node) {
        return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST(TreeNode node, int min, int max) {
        if(node == null)
            return true;

        if(node.data < min || node.data > max)
            return false;

        if(!isBST(node.left, min, node.data))
            return false;

        return isBST(node.right, node.data, max);
    }
}
