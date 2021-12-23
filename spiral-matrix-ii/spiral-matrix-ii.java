class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int rowBegin = 0, rowEnd = n - 1, columnBegin = 0, columnEnd = n - 1;
        int input = 1, direction = 0;
        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {
            switch (direction) {
                case 0: // right
                    for (int i = columnBegin; i <= columnEnd; i++) {
                        result[rowBegin][i] = input++;
                    }
                    rowBegin++;
                    break;
                case 1: // down
                    for (int i = rowBegin; i <= rowEnd; i++) {
                        result[i][columnEnd] = input++;
                    }
                    columnEnd--;
                    break;
                case 2: // left
                    for (int i = columnEnd; i >= columnBegin; i--) {
                        result[rowEnd][i] = input++;
                    } 
                    rowEnd--;
                    break;
                case 3: // up
                    for (int i = rowEnd; i >= rowBegin; i--) {
                        result[i][columnBegin] = input++;
                    }
                    columnBegin++;
                    break;
            }
            direction = (direction + 1) % 4;
        }
        return result;
    }
}