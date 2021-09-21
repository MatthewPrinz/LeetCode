class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                nums.add(matrix[i][j]);
            }
        }
        boolean flag = true;
        int marker = 900;
        while (flag) {
            if (nums.contains(marker))
                marker++;
            else
                flag = false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0)
                    matrix[i][j] = marker;
            }
        }
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == marker) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < rows.size(); i++) {
            setRowCol(matrix, rows.get(i), cols.get(i));
        }
    }
    void setRowCol(int[][] mat, int row, int col) {
        for (int i = 0; i < mat.length; i++) {
            mat[i][col] = 0;
        }
        for (int j = 0; j < mat[row].length; j++) {
            mat[row][j] = 0;
        }
    }
    
}