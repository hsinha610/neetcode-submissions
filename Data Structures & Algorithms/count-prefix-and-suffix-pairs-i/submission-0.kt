class Solution {
    fun countPrefixSuffixPairs(words: Array<String>): Int {
        var ans = 0

        fun isPrefixAndSuffix(str1: String, str2: String): Boolean {
            return str1 == str2.take(str1.length) && str1 == str2.takeLast(str1.length)
        }

        for(i in 0..words.lastIndex){
            for(j in i+1..words.lastIndex){
                if(isPrefixAndSuffix(words[i], words[j])){
                    ans++
                }
            }
        }

        return ans
    }
}
