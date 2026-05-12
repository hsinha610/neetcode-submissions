class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {

        if(s2.length < s1.length) return false

        val count1 = IntArray(26){ 0 }

        val count2 = IntArray(26){ 0 }

        s1.forEach{
            count1[it - 'a']++
        }

        
        var start = 0
        var end = 0

        while(end < s2.length){
            if(end-start+1 > s1.length){
                count2[s2[end]-'a']++
                end++
                count2[s2[start]-'a']--
                start++
            } else {
                count2[s2[end]-'a']++
                end++
            }

            var ans = true

            for(i in 0..25){
                ans = ans && count1[i] == count2[i]
            }

            if(ans){
                return ans
            }
        }

        return false

    }
}
