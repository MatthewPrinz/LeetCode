class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                copy[i][j] = board[i][j];
            }
        }
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                int aliveNeighbors = liveNeighbors(copy, row, col);
                // System.out.println("row: " + row + " col: " + col + " aliveNeighbors: " + aliveNeighbors);
                if (copy[row][col] == 1)
                {
                    // rule 1
                    if (aliveNeighbors < 2)
                        board[row][col] = 0;
                    // rule 2
                    if (aliveNeighbors >= 2 && aliveNeighbors <= 3)
                        board[row][col] = 1;
                    // rule 3
                    if (aliveNeighbors > 3)
                        board[row][col] = 0;
                }
                // rule 4
                if ( (copy[row][col] == 0) && aliveNeighbors == 3)
                    board[row][col] = 1;
            }
        }
    }
    // Blackbox routine which checks dimensions & returns the number of alive neighbors
    // we can assume that number of dead neighbors are just 8 - liveNeighbors
    public int liveNeighbors(int[][] board, int row, int col)
    {
        int numAlive = 0;
        // left, right, down, up
        if ((row-1) >= 0)
            numAlive += board[row-1][col];
        if ((row+1) < board.length)
            numAlive += board[row+1][col];
        if ((col+1) < board[0].length)
            numAlive += board[row][col+1];
        if ((col-1) >= 0)
            numAlive += board[row][col-1];
        // down right
        if (((row+1) < board.length) && ((col+1) < board[0].length))
            numAlive += board[row+1][col+1];
        // up right
        if (((col-1) >= 0) && ((row+1) < board.length))
            numAlive += board[row+1][col-1];
        // down left
        if (((col+1) < board[0].length) && ((row-1) >= 0))
            numAlive += board[row-1][col+1];
        // up left
        if (((col-1) >= 0) && ((row-1) >= 0))
            numAlive += board[row-1][col-1];
        return numAlive;
    }
}
