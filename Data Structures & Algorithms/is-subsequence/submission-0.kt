class Solution {
    fun isSubsequence(s: String, t: String): Boolean {

        var sIndex = 0
        var tIndex= 0

        while(tIndex < t.length && sIndex < s.length){
            if(t[tIndex]==s[sIndex]){
                sIndex++
            }
            tIndex++
        }

        return sIndex == s.length
    }
}
