class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        
        var ans = ""

        var i = 0
        var j = 0

        while(i< word1.length && j < word2.length){

            ans += "${word1[i]}${word2[j]}"

            i++
            j++
        }

        while(i < word1.length){
            ans += word1[i++]
        }

        while(j < word2.length){
            ans += word2[j++]
        }

        return ans
    }
}
