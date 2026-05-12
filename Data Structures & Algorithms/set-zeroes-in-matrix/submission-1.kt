class Solution {
    fun setZeroes(matrix: Array<IntArray>) {

        val r = matrix.size
        val c = matrix.first().size

        for(i in 0..r-1) {
            for(j in 0..c-1){
                if(matrix[i][j]==0){

                    for(ii in 0..r-1){
                        if(matrix[ii][j]!=0)
                        matrix[ii][j] = -1
                    }
                    for(jj in 0..c-1){
                        if(matrix[i][jj]!=0)
                        matrix[i][jj] = -1
                    }
                }
            }
        }

        for(i in 0..r-1) {
            for(j in 0..c-1){
                if(matrix[i][j]==-1){
                    matrix[i][j] = 0
                    
                }
            }
        }


    }
}
