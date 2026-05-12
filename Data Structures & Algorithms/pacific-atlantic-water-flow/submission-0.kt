class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {

        val rows = heights.size
        val cols = heights.first().size
        val visited = Array<BooleanArray>(rows){ BooleanArray(cols)}

        val ans = mutableListOf<List<Int>>()

            for(i in 0..rows-1){
             for(j in 0..cols-1){
                if(dfsPacific(i,j,heights,Array<BooleanArray>(rows){ BooleanArray(cols)}, rows,cols) &&
                dfsAtlantic(i,j,heights,Array<BooleanArray>(rows){ BooleanArray(cols)},rows,cols)) {
                    ans.add(listOf(i,j))
                }
            }
            }

            return ans.toList()

    }

    fun dfsPacific(r: Int, c: Int, heights: Array<IntArray>, visited: Array<BooleanArray>, rows: Int, cols: Int) : Boolean {
        if(r <= 0 || c<=0) return true

        visited[r][c] = true

         val currentHeight = heights[r][c]


         if(r+1 < rows && heights[r+1][c] <= currentHeight && visited[r+1][c]==false) { if(dfsPacific(r+1,c,heights,visited, rows,cols)) return true }
        if(r-1 >= 0 && heights[r-1][c] <= currentHeight && visited[r-1][c]==false) { if(dfsPacific(r-1,c,heights,visited, rows,cols)) return true }
        if(c+1 < cols && heights[r][c+1] <= currentHeight && visited[r][c+1]==false) { if(dfsPacific(r,c+1,heights,visited, rows,cols)) return true }
        if(c-1 >= 0  && heights[r][c-1] <= currentHeight && visited[r][c-1]==false) { if(dfsPacific(r,c-1,heights,visited, rows,cols)) return true }

return false

        }

    fun dfsAtlantic(r: Int, c: Int, heights: Array<IntArray>, visited: Array<BooleanArray>, rows: Int, cols: Int) : Boolean {
        if(r>=rows-1 || c >= cols-1) return true

        visited[r][c] = true

         
         val currentHeight = heights[r][c]


        if(r+1 < rows && heights[r+1][c] <= currentHeight && visited[r+1][c]==false) { if(dfsAtlantic(r+1,c,heights,visited, rows,cols)) return true }
        if(r-1 >= 0 && heights[r-1][c] <= currentHeight && visited[r-1][c]==false) { if(dfsAtlantic(r-1,c,heights,visited, rows,cols)) return true }
        if(c+1 < cols && heights[r][c+1] <= currentHeight && visited[r][c+1]==false) { if(dfsAtlantic(r,c+1,heights,visited, rows,cols)) return true }
        if(c-1 >= 0  && heights[r][c-1] <= currentHeight && visited[r][c-1]==false) { if(dfsAtlantic(r,c-1,heights,visited, rows,cols)) return true }

        return false
    }
}
