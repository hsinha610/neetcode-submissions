class Solution {
    fun confusingNumber(n: Int): Boolean {
        if(n.toString().toList().toSet().intersect(setOf('2','3','4','5','7')).isNotEmpty()) return false

        val a = n.toString()
        val b = n.toString().toList().reversed().map{ when(it){
            '6' -> '9'
            '9' -> '6'
            else-> it
        }}.dropWhile{ it == '0'}.joinToString("")

        println(a)
        println(b)
        return a!=b && b.isBlank().not()
    }
}
