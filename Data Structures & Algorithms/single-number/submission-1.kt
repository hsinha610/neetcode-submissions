class Solution {
    fun singleNumber(nums: IntArray): Int {

        var ans = 0
        for(i in 0..nums.lastIndex) {
            ans= ans xor nums[i]
        }

        return ans
    }
}
