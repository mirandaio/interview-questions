public class CreateMinimalBST {

    public static void main(String[] args) {
        int[] arr = new int[args.length];

        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(args[i]);

        TreeNode root = createMinimalBST(arr, 0, arr.length - 1);
    }

    /* Given a sorted (increasing order) array, write an algorithm to create a
     * binary search tree with minimal height.
     */
    public static TreeNode createMinimalBST(int[] arr) {
        return createMinimalBST(arr, 0, arr.length - 1);
    }

    public static TreeNode createMinimalBST(int[] arr, int start, int end) {
        if(start > end)
            return null;

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(arr[mid]);
        root.left = createMinimalBST(arr, start, mid - 1);
        root.right = createMinimalBST(arr, mid + 1, end);

        return root;
    }
}
