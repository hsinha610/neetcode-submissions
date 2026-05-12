class Solution {
    fun isPalindrome(x: String): Boolean {
        
        if(x.length == 0) return true

        val s = x.replace(" ", "").filter { it in 'A'..'Z' || it in 'a'..'z' || it in '0'..'9'}.lowercase()

        if(s.length == 0) return true

        for(i in 0..(s.length/2)){
            if(s[i] != s[s.lastIndex-i]) return false
        }

        return true
    }
}
