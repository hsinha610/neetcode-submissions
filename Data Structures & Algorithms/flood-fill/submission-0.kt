class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {


        val originalColor = image[sr][sc]

        if(originalColor == color) return image

        fun dfs(i:Int, j:Int){
            if(i !in image.indices) return
            if(j !in image.first().indices) return
            if(image[i][j] != originalColor) return
            image[i][j] = color

            dfs(i+1,j)
            dfs(i-1,j)
            dfs(i,j+1)
            dfs(i,j-1)
        }

        dfs(sr,sc)

        return image
    }
}
