class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
            return nums.groupBy{ it }.mapValues{ it.value.size }.any{ it.value > 1}
    }
}
