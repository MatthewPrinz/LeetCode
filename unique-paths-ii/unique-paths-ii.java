class Solution {
    final int INV = 2000000000;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int[][] distance = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean seenObstacle = false;
        for (int i = 0; i < distance.length; i++) {
            if (!seenObstacle)
                seenObstacle = obstacleGrid[i][0] == 1;
            System.out.printf("SeenObstacle is: %s (%s), on coordinate: %d, 0\n", seenObstacle, obstacleGrid[i][0], i);
            distance[i][0] = seenObstacle ? 0 : 1;
        }
        seenObstacle = false;
        for (int i = 0; i < distance[0].length; i++) {
            if (!seenObstacle)
                seenObstacle = obstacleGrid[0][i] == 1;
            System.out.printf("SeenObstacle is: %s (%s), on coordinate: 0, %d\n", seenObstacle, obstacleGrid[0][i], i);
            distance[0][i] = seenObstacle ? 0 : 1;
        }
        System.out.println("Distance is:");
        printIntMat(distance);
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i-1][j] != 1)
                    distance[i][j] += distance[i-1][j];
                if (obstacleGrid[i][j-1] != 1)
                    distance[i][j] += distance[i][j-1];
            }
        }
        printIntMat(distance);
        return (obstacleGrid[distance.length - 1][distance[0].length - 1] == 1) ? 0 : distance[distance.length - 1][distance[0].length - 1];
    }
    void printIntMat(int[][] m) {
        for (int[] r : m) {
            System.out.println(Arrays.toString(r));
        }
    }
}