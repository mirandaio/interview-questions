public class IsBalanced {

    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t8 = new TreeNode(8);
        TreeNode t1 = new TreeNode(1);
        TreeNode t4 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t3 = new TreeNode(3);
        TreeNode t7 = new TreeNode(7);

        t5.left = t2;
        t5.right = t8;
        t2.left = t1;
        t2.right = t4;
        t8.left = t6;
        t4.left = t3;
        t6.right = t7;

        System.out.println("Is balanced? " + isBalanced2(t5));
    }

    /* Implement a function to check if a binary tree is balanced. For the 
     * purposes of this question, a balanced tree is defined to be a tree such
     * that the heights of the two subtrees of any node never differ by more
     * than one.
     */
    public static boolean isBalanced1(TreeNode root) {
        if(root == null)
            return true;

        int heightDiff = getHeight(root.left) - getHeight(root.right);

        if(Math.abs(heightDiff) > 1)
            return false;

        return isBalanced1(root.left) && isBalanced1(root.right);
    }

    public static int getHeight(TreeNode root) {
        if(root == null)
            return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static boolean isBalanced2(TreeNode root) {
        if(checkHeight(root) == -1)
            return false;

        return true;
    }

    public static int checkHeight(TreeNode root) {
        if(root == null)
            return 0;

        int leftHeight = checkHeight(root.left);

        if(leftHeight == -1)
            return -1;

        int rightHeight = checkHeight(root.right);

        if(rightHeight == -1)
            return -1;

        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
