class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int rowBegin = 0, rowEnd = n - 1, columnBegin = 0, columnEnd = n - 1, input = 1, direction = 0;
        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {
            for (int i = columnBegin; i <= columnEnd; i++) {
                result[rowBegin][i] = input++;
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) {
                result[i][columnEnd] = input++;
            }
            columnEnd--;
            for (int i = columnEnd; i >= columnBegin; i--) {
                result[rowEnd][i] = input++;
            } 
            rowEnd--;
            for (int i = rowEnd; i >= rowBegin; i--) {
                result[i][columnBegin] = input++;
            }
            columnBegin++;
        }
        return result;
    }
}