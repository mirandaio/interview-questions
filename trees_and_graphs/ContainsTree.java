public class ContainsTree {

    public static void main(String[] args) {

    }

    /* You have two very large binary trees: T1, with millions of nodes, and
     * T2, with hundreds of nodes. Create an algorithm to decide if T2 is a
     * subtree of T1.
     *
     * A tree T2 is a subtree of T1 if there exists a node n in T1 such that
     * the subtree of n is identical to T2. That is, if you cut off the tree
     * at node n, the two trees would be identical.
     */

    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        if(t2 == null)
            return true;

        return subtree(t1, t2);
    }

    public static boolean subtree(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return false;

        if(t1.value == t2.value) {
            if(matchTree(t1, t2))
                return true;
        }

        return subtree(t1.left, t2) || subtree(t1.right, t2);
    }

    public static boolean matchTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return true;

        if(t1 == null || t2 == null)
            return false;

        if(t1.value != t2.value)
            return false;

        return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
    }
}
