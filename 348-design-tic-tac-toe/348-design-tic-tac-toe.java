class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antidiagonal;
    int n;
    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.n = n;
    }
    
    
    // Precondition assumed: players are either 1 or something else
    public int move(int row, int col, int player) {
        int move = player == 1 ? 1 : - 1;
        boolean win = false;
        rows[row] += move;
        cols[col] += move;
        if (row == col) {
            diagonal += move;
        }
        if ((row + col) == n - 1) {
            antidiagonal += move;
        }
        if (Math.abs(rows[row]) == n || 
           Math.abs(cols[col]) == n || 
           Math.abs(diagonal) == n || 
           Math.abs(antidiagonal) == n) {
            win = true;
        }
        return win ? player : 0;
    }
}
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */