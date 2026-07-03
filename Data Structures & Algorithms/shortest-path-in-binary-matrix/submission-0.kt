import java.util.*

class Solution {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {

        val visited = Array<BooleanArray>(grid.size){BooleanArray(grid.size)}

        val q = LinkedList<Triple<Int,Int,Int>>()

        if(grid[0][0]==0){
            q.add(Triple(0,0,1))
            visited[0][0]=true
        }

        var ans = -1

        val n = grid.size

        val di = listOf(0,-1,-1,-1,0,1,1,1)
        val dj = listOf(-1,-1,0,1,1,1,0,-1)

        while(q.isNotEmpty()){
            val (i,j,dist) = q.poll()

            if(i == n-1 && j==n-1){
                ans = dist
            }

            repeat(8){
                val ni = i+di[it]
                val nj = j + dj[it]

                if(ni >= 0 && ni < n && nj >= 0 && nj < n && visited[ni][nj].not() && grid[ni][nj]==0){
                    q.add(Triple(ni,nj,dist+1))
                    visited[ni][nj] = true
                }
            }
        }

        return ans
    }
}
