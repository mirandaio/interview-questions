import java.util.Arrays;

public class Merge {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 0, 0, 0, 0};
        int[] b = {10, 11, 13};

        System.out.println("a     : " + Arrays.toString(a));
        System.out.println("b     : " + Arrays.toString(b));

        merge(a, b, 4, b.length);

        System.out.println("merged: " + Arrays.toString(a));
    }

    /* You are given two sorted arrays, A and B, where A has a large enough 
     * buffer at the end to hold B. Write a method to merge B into A in sorted
     * order.
     */
    public static void merge(int[] a, int[] b, int lenA, int lenB) {
        int indexA = lenA - 1;
        int indexB = lenB - 1;
        int index = lenA + lenB - 1;

        while(indexA >= 0 && indexB >= 0) {
            if(a[indexA] > b[indexB]) {
                a[index] = a[indexA];
                indexA--;
            } else {
                a[index] = b[indexB];
                indexB--;
            }
            index--;
        }

        while(indexB >= 0) {
            a[index] = b[indexB];
            indexB--;
            index--;
        }
    }
}
