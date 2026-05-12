class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        
        val row = grid.size
        val col = grid.first().size

        var count = 0

        for(i in 0..<row){
            for(j in 0..<col){
                if(grid[i][j]=='1'){
                    count++
                    dfs(i,j,grid, row, col)
                }
            }
        }

        return count
    }

    fun dfs(i: Int, j: Int, grid: Array<CharArray>, row:Int, col: Int){
        grid[i][j] = '0'

        if(i+1 < row && grid[i+1][j]=='1'){
            dfs(i+1, j, grid, row, col)
        }
        if(i-1 >=0 && grid[i-1][j]=='1'){
            dfs(i-1, j, grid, row, col)
        }
        if(j+1 < col && grid[i][j+1]=='1'){
            dfs(i, j+1, grid, row, col)
        }
        if(j-1 >= 0 && grid[i][j-1]=='1'){
            dfs(i, j-1, grid, row, col)
        }
    }
}
