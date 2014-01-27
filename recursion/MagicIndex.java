public class MagicIndex {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter at least one integer.");
            System.exit(1);
        }

        int[] arr = new int[args.length];

        for(int i = 0; i < args.length; i++)
            arr[i] = Integer.parseInt(args[i]);

        System.out.println("Magic index: " + magicIndex(arr));
    }

    /* A magic index in an array A[0...n-1] is defined to be an index such 
     * that A[i] = i. Given a sorted array of distinct integers, write a 
     * method to find a magic index, if one exists, in array A.
     */
    public static int magicIndex(int[] arr) {
        return magicIndex(arr, 0, arr.length);
    }

    public static int magicIndex(int[] arr, int start, int end) {
        if(start > end || start < 0 || end >= arr.length)
            return -1;

        int mid = (start + end) / 2;

        if(arr[mid] == mid)
            return mid;

        if(arr[mid] < mid)
            return magicIndex(arr, mid + 1, end);

        return magicIndex(arr, start, mid - 1);
    }

    // What if the values are not distinct?
    public static int magicIndex2(int[] arr) {
        return magicIndex2(arr, 0, arr.length - 1);
    }

    public static int magicIndex2(int[] arr, int start, int end) {
        if(start > end || start < 0 || end >= arr.length)
            return -1;

        int mid = (start + end) / 2;

        if(arr[mid] == mid)
            return mid;

        int index;

        int leftIndex = Math.min(mid - 1, arr[mid]);
        index = magicIndex2(arr, start, leftIndex);
        if(index >= 0)
            return index;

        int rightIndex = Math.max(mid + 1, arr[mid]);
        return magicIndex2(arr, rightIndex, end);
    }
}
