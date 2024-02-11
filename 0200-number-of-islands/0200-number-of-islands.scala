object Solution {
    def numIslands(grid: Array[Array[Char]]): Int = {
        var result = 0
        for (i <- 0 to grid.length - 1) {
            for (j <- 0 to grid(0).length - 1) {
                if (grid(i)(j) == '1') {
                    result += 1
                    dfs(grid, i, j)
                }
               
            }
        }
        result
    }
    def dfs(grid: Array[Array[Char]], i: Int, j: Int): Unit = {
        if (i < 0 || j < 0 || j >= grid(0).length || i >= grid.length || grid(i)(j) == '0') {
            return
        } else {
            grid(i)(j) = '0'
            dfs(grid, i + 1, j)
            dfs(grid, i - 1, j)
            dfs(grid, i, j + 1)
            dfs(grid, i, j - 1)
        }
        
    }
    
}