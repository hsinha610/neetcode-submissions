class Solution {
    fun validWordSquare(words: List<String>): Boolean {

        val rows = words.size
        val cols = words.maxOf{it.length}
        for(i in 0..rows-1){
            for(j in i+1..cols){
                val x = runCatching{
                    words[i][j]
                }.getOrNull() ?: 'A'

                val y = runCatching{
                    words[j][i]
                }.getOrNull() ?: 'A'

                if(x != y){
                    return false
                }
            }
        }
        return true
    }
}
