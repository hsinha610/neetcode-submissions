class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {

        var maxArea = 0

        for(i in 0..grid.lastIndex){
            for(j in 0..grid[0].lastIndex){

                if(grid[i][j]==1){
                    maxArea = max(maxArea,dfs(i,j,grid))
                }
            }
        }

        return maxArea
    }

    fun dfs(i: Int, j: Int, grid: Array<IntArray>): Int {

        grid[i][j] = -1

        var ans = 0

        val delta = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

        delta.forEach{ (di,dj)->
          val ni = i + di
          val nj = j + dj

          if(ni in grid.indices && nj in grid[0].indices && grid[ni][nj]!=-1 && grid[ni][nj]!=0){
            ans += dfs(ni, nj, grid)
          }  
        }

        return 1 + ans
    }
}
