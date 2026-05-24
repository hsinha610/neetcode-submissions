class Solution {
    fun arrangeCoins(n: Int): Int {
        

        var start : Long = 0
        var end : Long = n.toLong()

        var ans : Long = -1L

        while(start <= end){
            val mid : Long = start + (end-start)/2

            if(mid*(mid+1) == 2L*n){
                ans = mid
                break
            } else if(mid*(mid+1) < 2L*n){
                start = mid+1
            } else {
                end = mid-1
            }
        }

        return if(ans==-1L){end.toInt()} else{ans.toInt()}
    }
}
