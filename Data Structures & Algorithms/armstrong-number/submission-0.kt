class Solution {
    fun isArmstrong(n: Int): Boolean {
        val digitCount = n.toString().length

        var ans = 0

        n.toString().forEach{
            val d = it.digitToInt()
            var t = d

            repeat(digitCount-1){
                t = t*d
            }

            ans += t
        }

        println(ans)

        return ans == n
    }
}
