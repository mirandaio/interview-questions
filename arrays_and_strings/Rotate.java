import java.util.Random;

public class Rotate {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter the size n of the matrix");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        int[][] matrix = new int[n][n];
        Random r = new Random();

        // Fill matrix with random numbers
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                matrix[i][j] = r.nextInt(10);
        }

        System.out.println("Before Rotating");
        printMatrix(matrix, n);
        rotate(matrix, n);
        System.out.println("After Rotating");
        printMatrix(matrix, n);
    }

    /* Given an image represented by an NxN matrix, where each pixel in the 
     * image is 4 bytes, write a method to rotate the image by 90 degrees.
     * Can you do this in place?
     */
    public static void rotate(int[][] img, int n) {
        for(int layer = 0; layer < n / 2; layer++) {
            int rotations = n - 2 * layer - 1;
            int last = n - 1 - layer;

            for(int i = 0; i < rotations; i++) {

                // top -> temp
                int temp = img[layer][layer + i];
                
                // left -> top
                img[layer][layer + i] = img[last - i][layer];

                // bottom -> left
                img[last - i][layer] = img[last][last - i];

                // right -> bottom
                img[last][last - i] = img[layer + i][last];

                // top -> right
                img[layer + i][last] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");

            System.out.println();
        }
    }
}
