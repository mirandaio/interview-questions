/* In a binary tree, if in the path from the root to the node A, there is no
 * node with value greater than A's value, then A is a visible node. We need 
 * to count the number of visible nodes in a binary tree.
 */
class VisibleNodes {
    public int visibleNodes(Tree T) {
        return numVisible(T, Integer.MIN_VALUE);
    }

    public int numVisible(Tree T, int maxValue) {
        if(T == null) {
            return 0;
        }

        int num = 0;

        if(T.x >= maxValue) {
            num = 1;
            maxValue = T.x;
        }

        return num + numVisible(T.l, maxValue) + numVisible(T.r, maxValue);
    }
}
