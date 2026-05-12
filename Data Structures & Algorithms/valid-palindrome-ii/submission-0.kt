class Solution {
    fun validPalindrome(s: String): Boolean {

        var start = 0
        var end = s.length-1

        while(start <= end && s[start]==s[end]){
            start++
            end--
        }

        var a = start + 1
        var b = end

        while(a<=b && s[a]==s[b]){
            a++
            b--
        }

        var x = start
        var y = end - 1

        while(x<=y && s[x]==s[y]){
            x++
            y--
        }

        return (b < a) || (y < x)

    }
}
