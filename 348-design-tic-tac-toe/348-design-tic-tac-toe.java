class TicTacToe {
    int[][] board;
    int n;
    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        return checkWin(player) ? player : 0;
    }
    
    private boolean checkWin(int player) {
        boolean win = false;
        
        // Check horizontal, vertical
        for (int i = 0; i < n; i++) {
            int scoreHorizontal = 0;
            int scoreVertical = 0;
            for (int j = 0; j < n; j++) {
                if (board[i][j] == player) {
                    scoreHorizontal++;
                }
                if (board[j][i] == player) {
                    scoreVertical++;
                }
            }
            if (scoreHorizontal == n || scoreVertical == n) {
                win = true;
            }
        }
        int scoreToBottomRight = 0, scoreToBottomLeft = 0;
        for (int i = 0; i < n; i++) {
            if (board[i][i] == player) {
                scoreToBottomRight++;
            }
            if (board[n - 1 - i][i] == player) {
                scoreToBottomLeft++;
            }
        }
        if (scoreToBottomRight == n || scoreToBottomLeft == n) {
            win = true;
        }
        return win;
    }
    
}
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */