class Solution {
    val cachedResult = IntArray(46){ -1 }
    fun climbStairs(n: Int): Int {
        if(n==0) return 1
        if(n<0) return 0
        if(cachedResult[n]!= -1) return cachedResult[n]

        cachedResult[n] = climbStairs(n-1) + climbStairs(n-2)
        return cachedResult[n]
    }
}
