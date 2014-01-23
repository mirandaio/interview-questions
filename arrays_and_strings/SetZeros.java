import java.util.Random;

public class SetZeros {

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("You need to enter the number of rows and" + 
                " columns");
            System.exit(1);
        }

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int[][] matrix = new int[m][n];
        Random r = new Random();
        
        // Fill matrix with random numbers
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                matrix[i][j] = r.nextInt(10);
        }

        System.out.println("Before setting zeros");
        printMatrix(matrix);
        setZeros(matrix);
        System.out.println("After setting zeros");
        printMatrix(matrix);
    }

    /* Write an algorithm such that if an element in an MxN matrix is 0,
     * its entire row and column are set to 0.
     */

    public static void setZeros(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for(int i = 0; i < rows.length; i++) {
            for(int j = 0; j < columns.length; j++) {
                if(rows[i] || columns[j])
                    matrix[i][j] = 0;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j] + " ");

            System.out.println();
        }
    }
}
