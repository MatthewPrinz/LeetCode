        }
        // left column
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < 1; j++)
            {
                dfs(board, i, j);
            }
        }
        // right column
        for (int i = 0; i < board.length; i++)
        {
            for (int j = board[0].length-1; j < board[0].length; j++)
            {
                dfs(board, i, j);
            }
        }
        // 3
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                // 3.1
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'Z')
                    board[i][j] = 'O';
            }
        }
        
    }
    
    public void dfs(char[][] board, int i, int j)
    {
        // 2
        if (i >= board.length || j >= board[0].length || 
            i < 0 || j < 0 ||
            board[i][j] == 'X' || board[i][j] == 'Z')
            return;
        board[i][j] = 'Z';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
    
}
