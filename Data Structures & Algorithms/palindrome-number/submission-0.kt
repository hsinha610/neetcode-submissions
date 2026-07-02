class Solution {
    fun isPalindrome(x: Int): Boolean {
        var new = 0
        var n = x

        while(n>0){
            val rem = n%10
            new = new*10 + rem
            n = n/10
        }

        return new == x
    }
}
