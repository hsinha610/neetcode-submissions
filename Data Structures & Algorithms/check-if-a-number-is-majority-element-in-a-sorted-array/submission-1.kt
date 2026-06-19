class Solution {
    fun isMajorityElement(nums: IntArray, target: Int): Boolean {

        var firstIndex = Int.MAX_VALUE
        var lastIndex = Int.MIN_VALUE


        var start = 0
        var end = nums.lastIndex

        while(start<= end){
            val mid = start + (end-start)/2

            if(nums[mid]==target){
                firstIndex = mid
                end=mid-1
            } else if(nums[mid] < target){
                start = mid+1
            } else {
                end = mid-1
            }
        }

        start = 0
        end = nums.lastIndex

        while(start<=end){
            val mid = start + (end-start)/2

            if(nums[mid]==target){
                lastIndex = mid
                start = mid+1
            } else if(nums[mid] < target){
                start = mid+1
            } else{
                end = mid-1
            }
        }

        if(firstIndex == Int.MAX_VALUE || lastIndex == Int.MIN_VALUE) return false

        return (lastIndex-firstIndex+1) > nums.size/2
    }
}
