/* A non-empty zero-indexed array A consisting of N integers is given. A slice
 * of that array is a pair of integers (P, Q) such that 0 <= P <= Q < N.
 * Integer P is called the beginning of the slice; integer Q is called the end
 * of the slice. The number Q - P + 1 is called the size of the slice. A slice
 * (P, Q) of array A is called ascending if A[P] < A[P+1] < ... A[Q-1] < A[Q].
 * Write a function:
 *
 * class AscendingSlice { public int ascendingSlice(int[] A); }
 *
 * that, given a zero-indexed array A consisting of N integers, returns the 
 * beginning of any ascending slice of A of maximal size.
 */
class AscendingSlice {
    public int ascendingSlice(int[] A) {
        int start = 0;
        int end = 0;
        int start_temp = 0;
        int end_temp = 0;

        for(int i = 1; i < A.length; i++) {
            if(A[i-1] < A[i]) {
                end_temp = i;
            } else {
                if(end - start < end_temp - start_temp) {
                    start = start_temp:
                    end = end_temp;
                }

                start_temp = i;
                end_temp = i;
            }
        }

        if(end - start < end_temp - start_temp) {
            start = start_temp;
        }

        return start;
    }
}
