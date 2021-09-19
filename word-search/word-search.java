class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j] && dfs(i, j, board, word, 0))
                    return true;
            }
        }
        return false;
    }
    
    boolean dfs(int i, int j, char[][] board, String word, int count) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || count >= word.length() || word.charAt(count) != board[i][j])
            return false;
        if (count == word.length()-1)
            return true;
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean right = dfs(i+1, j, board, word, count + 1);
        boolean left = dfs(i-1, j, board, word, count + 1);
        boolean up = dfs(i, j-1, board, word, count+1);
        boolean down = dfs(i, j+1, board, word, count+1);
        board[i][j] = temp;
        return right || left || up || down;   
    }
}