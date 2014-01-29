import java.util.ArrayList;

public class Queens {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter the size of the board.");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        ArrayList<Integer[]> results = placeQueens(n);

        for(int i = 0; i < results.size(); i++)
            printSolution(results.get(i));
    }

    /* Write an algorithm to print all ways of arranging eight queens on an
     * 8x8 chess board so that none of them share the same row, column or
     * diagonal. In this case, "diagonal" means all diagonals, not just the
     * two that bisect the board.
     */
    public static ArrayList<Integer[]> placeQueens(int n) {
        Integer[] columns = new Integer[n];
        ArrayList<Integer[]> results = new ArrayList<Integer[]>();
        placeQueens(0, n, columns, results);
        return results;
    }

    public static void placeQueens(int row, int n, Integer[] columns,
        ArrayList<Integer[]> results) {
        if(row ==  n) {
            Integer[] temp = new Integer[n];

            for(int i = 0; i < n; i++)
                temp[i] = columns[i];

            results.add(temp);
            return;
        }

        for(int col = 0; col < n; col++) {
            columns[row] = col;
            if(isValid(row, columns)) {
                placeQueens(row + 1, n, columns, results);
            }
            columns[row] = -1;
        }
    }

    public static boolean isValid(int row, Integer[] columns) {
        for(int row2 = 0; row2 < row; row2++) {
            if(columns[row] == columns[row2])
                return false;

            if(Math.abs(columns[row] - columns[row2]) == row - row2)
                return false;
        }

        return true;
    }

    public static void printSolution(Integer[] columns) {
        System.out.println("================");
        for(int row = 0; row < columns.length; row++)
            System.out.println("row: " + row + " column: " + columns[row]);
    }
}
