class Solution {
  public int numIslands(char[][] grid) {
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          result++;
        }
      }
    }
  return result;
  }
  
  void dfs(char[][] grid, int i, int j) {
    if (i >= grid.length || i < 0 || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
      return;
    }
    grid[i][j] = '0';
    dfs(grid, i + 1, j);
    dfs(grid, i - 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i, j - 1);
  }
}