class Solution {
    fun solve(board: Array<CharArray>) {

        val rows = board.size
        val cols = board.first().size


        for(i in listOf(0,rows-1)){
            for(j in 0 until cols){
                if(board[i][j]=='O'){
                    mark(i,j,rows,cols,board)
                }
            }
        }

        for(j in listOf(0,cols-1)){
            for(i in 0 until rows){
                if(board[i][j]=='O'){
                    mark(i,j,rows,cols,board)
                }
            }
        }

        for(i in 0 until rows){
            for(j in 0 until cols){
                if(board[i][j]=='O'){
                    board[i][j]='X'
                } else if(board[i][j]=='*'){
                    board[i][j]='O'
                }
            }
        }
    }

    fun mark(i:Int, j:Int, rows:Int, cols:Int, board: Array<CharArray>){
        if(i !in 0 until rows || j !in 0 until cols) return
        if(board[i][j]=='X' || board[i][j]=='*') return
        board[i][j] = '*'

        for((di,dj) in listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)){
            val ni = i + di
            val nj = j + dj

            mark(ni,nj,rows,cols,board)
        }
    }
}
