class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {

        var start = 0
        var end = nums.lastIndex

        while(start <= end){
            val mid = start + (end-start)/2

            if(nums[mid]==target) return mid

            if(target < nums[mid]){
                end = mid-1
            } else {
                start = mid+1
            }
        }

        return start

    }
}
