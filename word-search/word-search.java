class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) 
                    return true;
            }
        }
        return false;
    }
    
    boolean dfs(char[][] board, String word, int i, int j, int count) {
        if (count == word.length())
            return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || count > word.length() || word.charAt(count) != board[i][j])
            return false;
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean result = dfs(board, word, i+1, j, count+1) ||
            dfs(board, word, i-1, j, count+1) ||
            dfs(board, word, i, j+1, count+1) ||
            dfs(board, word, i, j-1, count+1);
        board[i][j] = temp;
        return result;
    }
}