class Solution {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {

        val rows = matrix.size
        val cols = matrix[0].size

        val ans = Array<IntArray>(cols){ IntArray(rows){0}}

        for(i in 0..<rows){
            for(j in 0..<cols){
                ans[j][i]=matrix[i][j]
            }
        }

        return ans
    }
}
