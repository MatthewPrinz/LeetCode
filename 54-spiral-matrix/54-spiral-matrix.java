class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int rowBegin = 0, colBegin = 0, rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1, direction = 0;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            switch (direction) {
                case 0:
                    for (int i = colBegin; i <= colEnd; i++) {
                        result.add(matrix[rowBegin][i]);
                    }
                    rowBegin++;
                    break;
                case 1:
                    for (int i = rowBegin; i <= rowEnd; i++) {
                        result.add(matrix[i][colEnd]);
                    }
                    colEnd--;
                    break;
                case 2:
                    for (int i = colEnd; i >= colBegin; i--) {
                        result.add(matrix[rowEnd][i]);
                    }
                    rowEnd--;
                    break;
                case 3:
                    for (int i = rowEnd; i >= rowBegin; i--) {
                        result.add(matrix[i][colBegin]);
                    }
                    colBegin++;
                    break;
            }
            direction = (direction + 1) % 4;
        }
        return result;
    }
}
