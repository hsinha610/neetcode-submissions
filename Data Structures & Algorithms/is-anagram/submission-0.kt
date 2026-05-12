class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val sCount = IntArray(26){ 0 }
        val tCount = IntArray(26){ 0 }

        s.forEach{
            sCount[it-'a']++
        }

        t.forEach{
            tCount[it-'a']++
        }

        for(i in 0 until 26){
            if(sCount[i]!=tCount[i]) return false
        }

        return true
    }
}
