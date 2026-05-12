class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        
        var ans = 0

        for(i in grid.indices){
            for(j in grid[i].indices){
                if(grid[i][j]==1){
                    ans = dfs(i,j,grid)
                }
            }
        }

        return ans
    }

    fun dfs(i: Int,j: Int, graph: Array<IntArray>) : Int {
        if((i !in graph.indices) || (j !in graph[0].indices)) return 1
        if(graph[i][j]==-1) return 0
        if(graph[i][j]==0){
            return 1
        }

        graph[i][j] = -1

        val di = listOf(-1,0,1,0)
        val dj = listOf(0,1,0,-1)

        return di.zip(dj).map{ (di,dj)->
            dfs(i+di,j+dj,graph)
        }.sum()
    }
}
