class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int[] visited = new int[isConnected.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(isConnected, visited, i);
            }
        }
        return count;
    }
    
    void dfs(int[][] grid, int[] visited, int i) {
        for (int j = 0; j < visited.length; j++) {
            if (visited[j] == 0 && grid[i][j] == 1) {
                visited[j] = 1;
                dfs(grid, visited, j);
            }
        }
    }
}
