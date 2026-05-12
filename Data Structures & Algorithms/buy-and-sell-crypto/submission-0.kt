class Solution {
    fun maxProfit(prices: IntArray): Int {
         val isDescending = prices.toList().zipWithNext().all{ it.first >= it.second }

        if(isDescending){
            return 0
        }

        val maxOnRight = IntArray(prices.size){ 0 }
        val minOnLeft = IntArray(prices.size){ 101 }

        for(i in 0..prices.size-1){
            if(i == 0){
                minOnLeft[i] = prices[i]
            } else {
                minOnLeft[i] = min(prices[i],minOnLeft[i-1])
            }
        }

        for(i in prices.size-1 downTo 0){
            if(i == prices.size-1){
                maxOnRight[i] = prices[i]
            } else {
                maxOnRight[i] = max(prices[i],maxOnRight[i+1])
            }
        }

        return maxOnRight.toList().zip(minOnLeft.toList()).map{ it.first - it.second }.max()
    }
}
