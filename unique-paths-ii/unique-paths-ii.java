class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int[][] paths = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean seenObstacle = false;
        for (int i = 0; i < paths.length; i++) {
            if (!seenObstacle)
                seenObstacle = obstacleGrid[i][0] == 1;
            paths[i][0] = seenObstacle ? 0 : 1;
        }
        seenObstacle = false;
        for (int i = 0; i < paths[0].length; i++) {
            if (!seenObstacle)
                seenObstacle = obstacleGrid[0][i] == 1;
            paths[0][i] = seenObstacle ? 0 : 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i-1][j] != 1)
                    paths[i][j] += paths[i-1][j];
                if (obstacleGrid[i][j-1] != 1)
                    paths[i][j] += paths[i][j-1];
            }
        }
        return (obstacleGrid[paths.length - 1][paths[0].length - 1] == 1) ? 0 : paths[paths.length - 1][paths[0].length - 1];
    }
}