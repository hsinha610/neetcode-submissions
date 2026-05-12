class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {

        var start = 1
        var end = piles.max()

        var ans = piles.max()

        while(start<= end){
            val mid = start + (end-start)/2



          var hours =  piles.map{ if(it%mid==0) {it /mid } else {
                it/mid + 1
            }}.sum()

            if(hours<= h){
                ans = mid
                end = mid-1
            } else {
                start = mid+1
            }
        }

        return ans

    }
}
