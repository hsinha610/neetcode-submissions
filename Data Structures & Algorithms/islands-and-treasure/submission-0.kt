class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val rows = grid.size
        val cols = grid.first().size

        val q =LinkedList<Node>()

        for(i in 0..<rows) {
            for(j in 0..<cols){
                if(grid[i][j]==0){
                    q.add(Node(i,j,0))
                }
            }
        }

        while(q.isNotEmpty()){
            var size = q.size
            while(size>0)
            {
                size--
                val (x,y,d) = q.poll()
                val delta = listOf(-1 to 0, 1 to 0, 0 to 1, 0 to -1)

                delta.forEach{ (dx,dy) ->

                val nx = x + dx
                val ny = y + dy

            if(nx in 0..<rows && ny in 0..<cols && grid[nx][ny]==2147483647){
                grid[nx][ny] = d+1
                q.add(Node(nx,ny,d+1))
            }
            }
            }
        }
    
    }
}

data class Node(val x: Int, val y: Int, val distance: Int)