public class MaxSum {

    public static void main(String[] args) {
        int[] arr = new int[args.length];

        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(args[i]);

        int[] results = maxSum(arr);

        System.out.println("low: " + results[0]);
        System.out.println("high: " + results[1]);
        System.out.println("max: " + results[2]);
    }

    /* You are given an array of integers (both positive and negative). Find 
     * the contiguous sequence with the largest sum. Return the sum.
     */
    public static int[] maxSum(int[] arr) {
        if(arr.length == 0)
            return new int[] {-1, -1, Integer.MIN_VALUE};

        int start = 0;
        int end = 0;
        int max = arr[0];
        int start_temp = 0;
        int sum = max;

        for(int i = 1; i < arr.length; i++) {
            if(sum < 0) {
                sum = arr[i];
                start_temp = i;
            } else {
                sum += arr[i];
            }

            if(sum >= max) {
                max = sum;
                start = start_temp;
                end = i;
            }
        }

        return new int[] {start, end, max};
    }
}
