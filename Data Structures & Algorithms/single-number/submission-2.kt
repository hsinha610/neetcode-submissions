class Solution {
    fun singleNumber(nums: IntArray): Int {

        var ans = 0
        var i =0
        while(i < nums.size){
            ans = ans xor nums[i]
            i++
        }

        return ans
    }
}
