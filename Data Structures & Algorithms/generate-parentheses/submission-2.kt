class Solution {
    fun generateParenthesis(n: Int): List<String> {


        val ans = mutableListOf<String>()

        var open = n
        var close = n
        var total = 2*n

        fun helper(str: String){

            if(str.length == 2*n){
                ans.add(str)
                return
            }

            if(open > 0){
                open--
                helper(str + '(')
                open++
            }

            if(close > 0 && close > open){
                close--
                helper(str + ')')
                close++
            }
        }

        helper("")

        println(ans)

        return ans
    }
}
