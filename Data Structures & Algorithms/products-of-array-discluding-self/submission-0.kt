class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {

        val ans = IntArray(nums.size){1}

        for(i in 1..nums.lastIndex){
            ans[i] = nums[i-1] * ans[i-1]
        }   

        var prodRight = 1

        for(i in nums.lastIndex-1 downTo 0){
            ans[i] = nums[i+1] * prodRight * ans[i]
            prodRight *= nums[i+1]
        }

        return ans
    }
}
