public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
    public boolean visited;
    public TreeNode parent; // only used in problems that specify that nodes
                            // have link to its parent.

    public TreeNode(int value) {
        this.value = value;
        this.visited = false;
    }
}
