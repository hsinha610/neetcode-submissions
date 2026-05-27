class Solution {
    fun numKLenSubstrNoRepeats(s: String, k: Int): Int {
        if(k>s.length) return 0

        val cIndex = IntArray(26){ -1 }

        var start = 0
        var end = 0

        var ans = 0

        while(end < s.length){
        
            val charAtEnd = s[end]

            if(cIndex[charAtEnd - 'a'] == -1){
                cIndex[charAtEnd - 'a'] = end
                end++ 
            } else {
                val duplicateAt = cIndex[charAtEnd - 'a']
                for(i in start..duplicateAt)
                    cIndex[s[i] - 'a'] = -1

                start = duplicateAt + 1
                cIndex[charAtEnd - 'a'] = end
                end++
            }

            if(end - start > k){
                cIndex[s[start] - 'a'] = -1
                start++
            }  

            if(end - start == k){
                ans++
            }
        }

        return ans
    }
}