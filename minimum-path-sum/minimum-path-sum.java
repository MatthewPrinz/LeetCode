class Solution {
    public int minPathSum(int[][] grid) {
        int[][] cost = new int[grid.length][grid[0].length];
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            sum += grid[i][0];
            cost[i][0] = sum;
        }
        sum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            sum += grid[0][i];
            cost[0][i] = sum;
        }
        for (int i = 1; i < cost.length; i++) {
            for (int j = 1; j < cost[0].length; j++) {
                cost[i][j] = Math.min(cost[i-1][j] + grid[i][j], cost[i][j-1] + grid[i][j]);
            }
        }
        return cost[grid.length-1][grid[0].length-1];
    }
}