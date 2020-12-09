class Solution {
    // 1) iterate through borders only
    // 2) if see O -> change it & surrounding Os to an intermediary character (say Z)
    // 3) iterate through gameboard 
    // 3.1) if see Z - change to O. If see O - flip
    
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0 || board == null)
            return;
        // 1
        // top row
        for (int i = 0; i < 1; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                dfs(board, i, j);
            }
        }
        // bottom row
        for (int i = board.length -1; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                dfs(board, i, j);
            }
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
