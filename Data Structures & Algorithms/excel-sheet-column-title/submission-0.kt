class Solution {
    fun convertToTitle(columnNumber: Int): String {
        var n = columnNumber
        var ans = ""

        val chars = CharArray(26){ (65+it).toChar() }

        while(n > 0){
            val rem = n%26 - 1
            ans = chars[(rem + 26)%26].toString() + ans
            n = n/26

            if(rem < 0){
                n--
            }
        }

        return ans
    }
}
