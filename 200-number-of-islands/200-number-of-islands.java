class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return result;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
    
    void bfs(char[][] grid, int i, int j) {
        Set<String> noDupes = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        noDupes.add("" + i + ',' + j);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] coords = queue.poll();
                int currI = coords[0];
                int currJ = coords[1];
                if ((currI + 1) < grid.length && grid[currI + 1][currJ] == '1') {
                    if (!noDupes.contains("" + (currI + 1) + ',' + currJ)) {
                        queue.add(new int[]{(currI + 1), currJ});
                        noDupes.add("" + (currI + 1) + ',' + currJ);
                    }
                }
                if ((currI - 1) >= 0 && grid[currI - 1][currJ] == '1') {
                    if (!noDupes.contains("" + (currI - 1) + ',' + currJ)) {
                        queue.add(new int[]{(currI - 1), currJ});
                        noDupes.add("" + (currI - 1) + ',' + currJ);
                    }
                }
                if ((currJ + 1) < grid[0].length && grid[currI][currJ + 1] == '1') {
                    if (!noDupes.contains("" + currI + ',' + (currJ + 1))) {
                        queue.add(new int[]{currI, (currJ + 1)});
                        noDupes.add("" + currI + ',' + (currJ + 1));
                    }
                } 
                if ((currJ - 1) >= 0 && grid[currI][currJ - 1] == '1') {
                    if (!noDupes.contains("" + currI + ',' + (currJ - 1))) {
                        queue.add(new int[]{currI, (currJ - 1)});
                        noDupes.add("" + currI + ',' + (currJ - 1));
                    }
                }
                grid[currI][currJ] = '0';
            }
        }
    }
}