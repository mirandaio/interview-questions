import java.util.HashSet;

public class CommonAncestor {

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
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);

        n1.parent = null;
        n1.left = n2;
        n1.right = n3;

        n2.parent = n1;
        n2.left = n4;
        n2.right = n5;

        n3.parent = n1;
        n3.left = n6;
        n3.right = n7;

        n4.parent = n2;
        n4.left = n8;
        n4.right = n9;

        n5.parent = n2;

        n6.parent = n3;
        n6.right = n0;

        n7.parent = n3;

        n8.parent = n4;

        n9.parent = n4;

        n0.parent = n6;


        // Another tree
        n10.parent = null;
        n10.left = n11;
        n10.right = n12;

        n11.parent = n10;

        n12.parent = n10;

        TreeNode na = n4;
        TreeNode nb = n0;

        System.out.println("Common ancestor of : " + na.value + 
            " and " + nb.value);
        System.out.println(commonAncestor4(n1, na, nb).value);
    }

    /* Design an algorithm and write code to find the first common ancestor
     * of two nodes in a binary tree. Avoid storing additional nodes in a
     * data structure. NOTE: This is not necessarily a binary search tree.
     */

    // Using parent links and visited field of TreeNode class
    public static TreeNode commonAncestor1(TreeNode n1, TreeNode n2) {
        while(n1 != null || n2 != null) {
            if(n1 != null) {
                if(n1.visited)
                    return n1;

                n1.visited = true;
                n1 = n1.parent;
            }

            if(n2 != null) {
                if(n2.visited)
                    return n2;

                n2.visited = true;
                n2 = n2.parent;
            }
        }

        return null; // nodes are not in the same tree
    }

    // Using parent links and data structure to store nodes.
    public static TreeNode commonAncestor2(TreeNode n1, TreeNode n2) {
        HashSet<TreeNode> h = new HashSet<TreeNode>();

        while(n1 != null || n2 != null) {
            if(n1 != null) {
                if(h.contains(n1))
                    return n1;

                h.add(n1);
                n1 = n1.parent;
            }

            if(n2 != null) {
                if(h.contains(n2))
                    return n2;

                h.add(n2);
                n2 = n2.parent;
            }
        }

        return null; // nodes are not in the same tree
    }

    // Without link to parents

    // Time complexity: O(n)
    public static TreeNode commonAncestor3(TreeNode root, TreeNode n1, 
            TreeNode n2) {
        if(!contains(root, n1) || !contains(root, n2))
            return null;

        return commonAncestor3Helper(root, n1, n2);
    }

    // Assumes that both n1 and n2 are in the tree
    public static TreeNode commonAncestor3Helper(TreeNode root, TreeNode n1,
            TreeNode n2) {
        boolean n1left = contains(root.left, n1);
        boolean n2left = contains(root.left, n2);

        if(n1left != n2left)
            return root;

        if(n1left)
            return commonAncestor3Helper(root.left, n1, n2);

        return commonAncestor3Helper(root.right, n1, n2);
    }

    // Returns true if n is a descendant of root
    public static boolean contains(TreeNode root, TreeNode n) {
        if(root == null)
            return false;

        if(root == n)
            return true;

        return contains(root.left, n) || contains(root.right, n);
    }

    public static TreeNode commonAncestor4(TreeNode root, TreeNode n1,
            TreeNode n2) {
        if(root == null)
            return null;

        if(root == n1 && root == n2)
            return root;

        TreeNode x = commonAncestor4(root.left, n1, n2);

        if(x != null && x != n1 && x != n2)
            return x;

        TreeNode y = commonAncestor4(root.right, n1, n2);

        if(y != null && y != n1 && y != n2)
            return y;

        if(x != null && y != null) {
            return root;
        } else if(root == n1 || root == n2) {
            return root;
        } else {
            return x == null? y : x;
        }
    }
}
