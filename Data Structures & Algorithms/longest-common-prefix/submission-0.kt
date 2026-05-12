class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if(strs.any{ it.isEmpty()}) return ""
        
        val minLength = strs.minOf{ it.length }

        var i =0

        var ans = ""

        while(i<minLength){

            if(strs.all{ it[i] == strs.first()[i]}){
                ans += strs.first()[i]
                i++
            } else {
                break
            }
            
        }

        return ans
    }
}
