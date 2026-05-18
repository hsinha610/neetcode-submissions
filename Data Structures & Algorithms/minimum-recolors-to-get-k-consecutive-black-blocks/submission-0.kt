class Solution {
    fun minimumRecolors(blocks: String, k: Int): Int {

        var start = 0
        var end = -1

        var countW = 0
        var countB = 0

        var ans = Int.MAX_VALUE

        repeat(k){
            if(blocks[++end]=='W'){
                countW++
            } else {
                countB++
            }
        }

        ans = min(ans, countW)

        while(end <= blocks.lastIndex){
            ans = min(ans, countW)

            if(blocks[start++]=='W'){
                countW--
            } else {
                countB--
            }
            end++
            if(end <= blocks.lastIndex && blocks[end]=='W'){
                countW++
            } else {
                countB++
            }
        }

        return ans

    }
}
