class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        
        return buildString{

        var i = 0
        var j = 0

        while(i < word1.length && j < word2.length){
            append(word1[i++])
            append(word2[j++])
        }

        while(i < word1.length){
            append(word1[i++])
        }

        while(j < word2.length){
            append(word2[j++])
        }

        }
    }
}
