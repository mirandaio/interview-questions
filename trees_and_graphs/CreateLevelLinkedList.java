import java.util.LinkedList;

public class CreateLevelLinkedList {

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

        LinkedList<LinkedList<TreeNode>> lists = createLevelLinkedList2(n5);

        for(LinkedList<TreeNode> list : lists) {
            for(TreeNode node : list) {
                System.out.print(node.value + " ");
            }

            System.out.println();
        }
    }

    /* Given a binary search tree, design an algorithm which creates a list
     * of all the nodes at each depth (e.g., if you have a tree with depth D,
     * you'll have D linked lists).
     */
    public static LinkedList<LinkedList<TreeNode>> createLevelLinkedList(
            TreeNode root) {
        LinkedList<LinkedList<TreeNode>> lists = new
            LinkedList<LinkedList<TreeNode>>();

        createLevelLinkedList(root, 0, lists);
        return lists;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public static void createLevelLinkedList(TreeNode node, int level,
            LinkedList<LinkedList<TreeNode>> lists) {
        if(node == null)
            return;

        if(lists.size() == level)
            lists.add(new LinkedList<TreeNode>());

        LinkedList<TreeNode> list = lists.get(level);
        list.add(node);

        createLevelLinkedList(node.left, level + 1, lists);
        createLevelLinkedList(node.right, level + 1, lists);
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public static LinkedList<LinkedList<TreeNode>> createLevelLinkedList2(
            TreeNode root) {
        LinkedList<LinkedList<TreeNode>> lists = new
            LinkedList<LinkedList<TreeNode>>();

        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if(root != null)
            current.add(root);

        while(current.size() > 0) {
            lists.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();

            for(TreeNode parent : parents) {
                if(parent.left != null)
                    current.add(parent.left);

                if(parent.right != null)
                    current.add(parent.right);
            }
        }

        return lists;
    }
}
