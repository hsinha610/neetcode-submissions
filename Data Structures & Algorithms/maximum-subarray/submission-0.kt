class Solution {
    fun maxSubArray(nums: IntArray): Int {

        var maxSum = Int.MIN_VALUE
        var currSum = 0

        nums.forEach{ num ->
            if(currSum < 0){
                currSum = 0
            }

            currSum += num

            maxSum = max(maxSum,currSum)
        }

        return maxSum
    }
}
