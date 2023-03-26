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
  
  void dfs(char[][] grid, int x, int y) {
    if (x >= grid.length || x < 0 || y < 0 || y >= grid[x].length || grid[x][y] == '0') {
      return;
    }
    grid[x][y] = '0';
    dfs(grid, x + 1, y);
    dfs(grid, x - 1, y);
    dfs(grid, x, y + 1);
    dfs(grid, x, y - 1);
  }
}