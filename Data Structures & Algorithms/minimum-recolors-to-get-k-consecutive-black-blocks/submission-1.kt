class Solution {
    fun minimumRecolors(blocks: String, k: Int): Int {

        var start = 0
        var end = 0

        var countW = 0

        var ans = Int.MAX_VALUE

        repeat(k){
            if(blocks[end++]=='W'){
                countW++
            }
        }

        ans = min(ans, countW)

        while(end <= blocks.lastIndex){
            if(blocks[start++]=='W'){
                countW--
            }

            if(blocks[end++]=='W'){
                countW++
            }

            ans = min(ans, countW)
        }

        return ans

    }
}
