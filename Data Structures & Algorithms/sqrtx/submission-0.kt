class Solution {
    fun mySqrt(X: Int): Int {
        val x = X.toLong()
        var start = 1L
        var end = x.toLong()
        var ans = 0L
        while(start <= end){
            val mid: Long = start + (end-start)/2
            println(mid)

            if(x/mid == mid) {return mid.toInt()}
            else if(mid < x/mid){
                ans = mid
                start = mid+1
            } else if(mid> x/mid){
                end = mid-1
            }
        }

        return ans.toInt()
    }
}
