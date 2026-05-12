class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {


        val rows = matrix.size
        val cols = matrix.first().size


        var i = 0
        var j = cols-1

        while(j >= 0 && i < rows){

            if(matrix[i][j] == target){
                return true
            } else if(target > matrix[i][j]){
                i++
            } else {
                j--
            }
        }

        return false


    }
}
