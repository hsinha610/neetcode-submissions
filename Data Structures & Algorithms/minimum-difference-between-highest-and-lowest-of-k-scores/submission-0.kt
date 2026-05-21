class Solution {
    fun minimumDifference(nums: IntArray, k: Int): Int {

        var ans = Int.MAX_VALUE

        var high = Int.MIN_VALUE
        var low = Int.MAX_VALUE

        var start = 0
        var end = 0

        nums.sort()

        low = nums[0]
        high = nums[k-1]

        end = k

        ans = min(ans, high-low)

        while(end < nums.size){
            high = nums[end++]
            low = nums[++start]

            ans = min(ans, high-low)
        }

        return ans
    }
}
