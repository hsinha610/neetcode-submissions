class Solution {
    fun search(nums: IntArray, target: Int): Int {

        var ans = -1

        var start = 0
        var end = nums.lastIndex

        while(start<=end){
            val mid = start + (end-start)/2

            if(nums[mid]==target){
                return mid
            } else if(target < nums[mid]){
                end = mid -1
            } else {
                start = mid + 1
            }
        }

        return ans

    }
}
