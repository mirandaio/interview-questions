public class TicTacToe {

    public static void main(String[] args) {
        
    }

    /* Design an algorithm to figure out if someone has won a game of
     * tic-tac-toe.
     */
    // returns 'e' if there is no winner.
    // returns 'x' if player x has won.
    // returns 'o' if player o has won.
    public static char tictactoe(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            
            if(board[i][0] != 'e' && board[i][0] == board[i][1] &&
                board[i][0] == board[i][2])
                return board[i][0];

            if(board[0][i] != 'e' && board[0][i] == board[1][i] &&
                board[0][i] == board[2][i])
                return board[0][i];
        }

        if(board[0][0] != 'e' && board[0][0] == board[1][1] &&
            board[0][0] == board[2][2])
            return board[0][0];

        if(board[0][2] != 'e' && board[0][2] == board[1][1] &&
            board[0][2] == board[2][0])
            return board[0][2];

        return 'e';
    }

    public static char tictactow(char[][] board) {
        int n = board.length;
        int row = 0;
        int col = 0;

        // Check rows
        for(row = 0; row < n; row++) {
            if(board[row][0] != 'e') {
                for(col = 1; col < n; col++) {
                    if(board[row][0] != board[row][col])
                        break;
                }
                
                if(col == n)
                    return board[row][0];
            }
        }

        // Check columns
        for(col = 0; col < n; col++) {
            if(board[0][col] != 'e') {
                for(row = 1; row < n; row++) {
                    if(board[0][col] != board[row][col])
                        break;
                }
                
                if(row == n)
                    return board[0][col];
            }
        }

        // Check diagonal top left to bottom right
        if(board[0][0] != 'e') {
            for(row = 1; row < n; row++) {
                if(board[0][0] != board[row][row])
                    break;
            }

            if(row  == n)
                return board[0][0];
        }

        // Check diagonal bottom left to top right
        if(board[n-1][0] != 'e') {
            for(row = 1; row < n; row++) {
                if(board[n-1][0] != board[n-1-row][row])
                    break;
            }

            if(row == n)
                return board[n-1][0];
        }

        return 'e';
    }
}
