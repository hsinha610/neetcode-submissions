class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {

        val isStr1Small = str1.length < str2.length

        val (a,b) = if(isStr1Small){
            str1 to str2
        } else {
            str2 to str1
        }

        var ans = ""

        for(i in 1..a.length){
            if(a.chunked(i).toSet().size == 1 && b.chunked(i).toSet().size == 1 && a.take(i)==b.take(i)){
                ans = a.take(i)
            }
        }

        return ans
    }
}
