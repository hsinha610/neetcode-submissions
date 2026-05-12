class Solution {
    fun lengthOfLongestSubstring(s: String): Int {

        if(s.length < 2) return s.length

        val charIndexMap = mutableMapOf<Char,Int>()

        var left = 0
        var right = 1

        var ans = 0

        charIndexMap[s[0]] = 0

        while(right < s.length){
            val rightChar = s[right]

            if(charIndexMap.getOrDefault(rightChar,-1) != -1 && charIndexMap.getOrDefault(rightChar,-1) >= left){
                ans = max(ans, right-left)
                left = charIndexMap.getOrDefault(rightChar,-1) + 1
                charIndexMap[rightChar] = right
                right++
            } else {
                charIndexMap[rightChar] = right
                right ++
            }
        }

        ans = max(ans,right - left)

        return ans

    }
}
