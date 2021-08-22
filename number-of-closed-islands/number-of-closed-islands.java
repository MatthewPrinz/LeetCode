class Solution {
    
    public void dfs(int[][] grid, int startRow, int startCol)
    {
        if (startRow >= grid.length || startRow < 0 || startCol < 0 ||startCol >= grid[startRow].length || 
            grid[startRow][startCol] == 1)
            return;
        
        grid[startRow][startCol] = 1;
        dfs(grid, startRow+1, startCol);
        dfs(grid, startRow-1, startCol);
        dfs(grid, startRow, startCol+1);
        dfs(grid, startRow, startCol-1);
    }
    
    public int closedIsland(int[][] grid) {
        int numIslands = 0;
        if (grid == null || grid.length == 0)
            return 0;
        for (int i = 0; i < grid.length; i++)
        {
            if (grid[i][0] == 0)
                dfs(grid, i, 0);
            if (grid[i][grid[i].length-1] == 0)
                dfs(grid, i, grid[i].length-1);
        }
        for (int j = 0; j < grid[0].length; j++)
        {
            if (grid[0][j] == 0)
                dfs(grid, 0, j);
            if (grid[grid.length-1][j] == 0)
                dfs(grid, grid.length-1, j);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }
}