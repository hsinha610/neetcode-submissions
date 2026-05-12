class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {

        var ans = Int.MAX_VALUE

        var prefixSum = mutableListOf<Int>()

        prefixSum.add(0)

        for(i in 0..nums.lastIndex){
            prefixSum.add(prefixSum.last() + nums[i])
        }

        var start = 0
        var end = 1

        while(start <= end && start < prefixSum.size && end < prefixSum.size) {
            if(prefixSum[end]-prefixSum[start] >= target){
                ans = min(ans, end-start)

                start++
            } else{
                end++
            }
        }

        return if(ans == Int.MAX_VALUE) 0 else ans


    }
}
