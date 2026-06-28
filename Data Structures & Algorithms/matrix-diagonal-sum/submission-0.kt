class Solution {
    fun diagonalSum(mat: Array<IntArray>): Int {

        val n = mat.size

        var ans = 0

        (0..n-1).zip(0..n-1).forEach{
            ans += mat[it.first][it.second]
        }

        (0..n-1).zip(n-1 downTo 0).forEach{
            ans += mat[it.first][it.second]
        }

        if(n %2==1){
            ans -= mat[n/2][n/2]
        }

        return ans
    }
}
