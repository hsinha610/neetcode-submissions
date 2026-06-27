class Solution {

    val cache = IntArray(38){ -1 }
    fun tribonacci(n: Int): Int {
        if(n==0) return 0
        if(n <=2) return 1
        if(cache[n]!=-1) return cache[n]

        cache[n] = tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3)

        return cache[n]
    }
}
