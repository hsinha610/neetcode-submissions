class Solution {
    fun countPrefixSuffixPairs(words: Array<String>): Int {
        var ans = 0

        for(i in 0..words.lastIndex){
            for(j in i+1..words.lastIndex){
                if(words[j].startsWith(words[i]) && words[j].endsWith(words[i])){
                    ans++
                }
            }
        }

        return ans
    }
}
