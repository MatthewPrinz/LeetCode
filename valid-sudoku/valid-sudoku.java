class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        // 1 & 2
        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) {
                        return false;
                    }
                    row.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (col.contains(board[j][i])) {
                        return false;
                    }
                    col.add(board[j][i]);
                }
            }
        }
        // 3
        int count = 0;
        int i = 0;
        int j = 0;
        while (count < 9) {
            Set<Character> square = new HashSet<>();
            for (int k = i; k < (3+i); k++) {
                for (int l = j; l < (3+j); l++) {
                    if (board[k][l] != '.') {
                        if (square.contains(board[k][l])) {
                            return false;
                        }
                        square.add(board[k][l]);
                    }
                }
            }
            if (i == 6) {
                i = 0;
                j += 3;
            }
            else {
                i += 3;
            }
            count++;
        }
        return true;
    }
}