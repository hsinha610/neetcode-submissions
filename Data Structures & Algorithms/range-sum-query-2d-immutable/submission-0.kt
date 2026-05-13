class NumMatrix(val matrix: Array<IntArray>) {
    val rows = matrix.size
    val cols = matrix[0].size

    init {

            for(i in 0..rows-1){
                for(j in 1..cols-1){
                matrix[i][j] = matrix[i][j]+matrix[i][j-1]
            }}



            for(j in 0..cols-1){for(i in 1..rows-1){
                matrix[i][j] = matrix[i][j]+matrix[i-1][j]
            }}

    }
    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {


            var ans = matrix[row2][col2] - if(col1-1 >=0){matrix[row2][col1-1]} else {0} - if(row1-1 >=0){matrix[row1-1][col2]} else {0} + if(row1-1 >=0 && col1-1 >=0){matrix[row1-1][col1-1]} else {0}

            return ans
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */
