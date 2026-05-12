class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {


        val q = LinkedList<Pair<Int,Int>>()
        var time = 0

        for(i in grid.indices){
            for(j in grid[0].indices){
                if(grid[i][j]==2){
                    q.add(i to j)
                }
            }
        }

        while(q.isNotEmpty()){
            for(steps in 1..q.size)
            {
                val (i,j) = q.poll()

                val d = listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

                for((di,dj) in d){
                    val ni = i + di
                    val nj = j + dj

                    if(ni in grid.indices && nj in grid[0].indices && grid[ni][nj]==1){
                    q.add(ni to nj)
                      grid[ni][nj] = 2
                    }
                }
            }

            time++
        }


        for(i in grid.indices){
            for(j in grid[0].indices){
                if(grid[i][j]==1){
                    return -1
                }
            }
        }

        if(time == 0) return time

        return time - 1
    }
}
