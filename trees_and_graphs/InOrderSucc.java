public class InOrderSucc {

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

        n5.parent = null;
        n5.left = n2;
        n5.right = n8;

        n2.parent = n5;
        n2.left = n1;
        n2.right = n4;

        n8.parent = n5;
        n8.left = n6;
        n8.right = n9;

        n1.parent = n2;

        n4.parent = n2;
        n4.left = n3;

        n6.parent = n8;
        n6.right = n7;

        n9.parent = n8;

        n3.parent = n4;

        n7.parent = n6;

        TreeNode n = n9;
        System.out.println("In order successor of: " + n.value);

        TreeNode succ = inOrderSucc(n);
        if(succ == null) {
            System.out.println("Does not have in order successor.");
        } else {
            System.out.println(succ.value);
        }
    }

    /* Write an algorithm to find the 'next' node (i.e. in-order successor) of 
     * a given node in a binary search tree. You may assume that each node has
     * a link to its parent.
     */
    public static TreeNode inOrderSucc(TreeNode node) {
        if(node == null)
            return null;

        if(node.right != null) {
            node = node.right;

            while(node.left != null)
                node = node.left;
        } else {
            while(node.parent != null && node != node.parent.left)
                node = node.parent;

            node = node.parent;
        }

        return node;
    }
}
