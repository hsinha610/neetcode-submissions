class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rowGood = checkRow(board)

        if(rowGood.not()) return false

        val colGood = checkCol(board)

        if(colGood.not()) return false

        val subBoxGood = checkSubBox(board)

        return subBoxGood

    }

    fun checkSubBox(board: Array<CharArray>): Boolean {
        val subBoxIndices = listOf(0 to 0, 0 to 1, 0 to 2, 1 to 0, 1 to 1, 1 to 2, 2 to 0, 2 to 1, 2 to 2)

        val offsets = listOf(0 to 0, 3 to 0, 6 to 0, 0 to 3, 3 to 3, 6 to 3, 0 to 6, 3 to 6, 6 to 6)

        for((rof,cof) in offsets){
            val counts = IntArray(10){0}

            for((i,j) in subBoxIndices){
                
                board[i + rof][j + cof].toString().toIntOrNull()?.let{
                counts[it]++
                }
            }

            if(counts.toList().any{ it > 1}){
                return false
            }
        }

        return true
    }

    fun checkRow(board: Array<CharArray>): Boolean {
        for(i in 0..board.lastIndex){
            val row = board[i]
            val counts = IntArray(10){0}
            row.toList().map{ it.toString().toIntOrNull()}.filterNotNull().forEach{
                counts[it]++
            }
            if(counts.toList().any{ it > 1}){
                return false
            }
        }

        return true
    }

    fun checkCol(board: Array<CharArray>): Boolean {
        for(j in 0..board.lastIndex){
            val counts = IntArray(10){0}
            for(i in 0..board.lastIndex){
                board[i][j].toString().toIntOrNull()?.let{
                    counts[it]++
                }
            }
            if(counts.toList().any{ it > 1}){
                return false
            }
        }

        return true
    }
}
