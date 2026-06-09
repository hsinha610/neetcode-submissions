class Solution {
    fun numEnclaves(grid: Array<IntArray>): Int {

        val rows = grid.size
        val cols = grid[0].size

    //  1001
    //  0110
    //  1100
    //  0001

     fun dfs(r: Int, c: Int){
        if(r <0 || r>= rows || c < 0 || c>=cols) return
        if(grid[r][c]==0) return
        println("R: $r, C: $c")
        grid[r][c]=0

        dfs(r+1,c)
        dfs(r-1,c)
        dfs(r,c+1)
        dfs(r,c-1)
     }

     for(j in 0 until cols){
        if(grid[0][j]==1){
            dfs(0,j)
        }
        if(grid[rows-1][j]==1){
            dfs(rows-1,j)
        }
     }

     for(i in 0 until rows){
        if(grid[i][0]==1){
            dfs(i,0)
        }
        if(grid[i][cols-1]==1){
            dfs(i,cols-1)
        }
     }

     var ans = 0

     grid.forEach{ row ->
        row.forEach{ item ->
         if(item==1){ans++}
        }
    }

     return ans   
    }
}
