Submitted is a BFS solution. I chose to use a Set to check for duplicates and a Queue for the BFS implementation. Note the technical details:
* Adding a comma between coordinates in the set (this is so there are no hash collisions - e.g. so (1,90) does not collide with (19, 0))
* Additionally, I chose to use Strings in the set as the hashcode of an int[] doesn't depend on the contents of the array.
<br>
This is a much simpler DFS solution.

```
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
    if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0')
      return;
    grid[i][j] = '0';
    dfs(grid, i + 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i - 1, j);
    dfs(grid, i, j - 1);
  }
}
```
