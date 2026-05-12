class Solution {
    fun findMin(nums: IntArray): Int {

        val n = nums.size

        var start = 0
        var end = n-1

        if(nums[(start-1+ n)%n] >= nums[start] && nums[start] <= nums[(start+1)%n] ) return nums[start]


        while(start <= end){
            val mid = start + (end-start)/2
            
            if((nums[(mid+1)%n] > nums[mid]) && (nums[(mid-1+n)%n] > nums[mid])) {
                return nums[mid]
                }

            if(nums[start]< nums[end]){
                    end = mid-1
            } else if (nums[start]> nums[end]){
                if(nums[mid]>nums[end]){
                    start = mid+1
                } else if(nums[mid]<nums[start]){
                    end = mid - 1
                }
            }
        }

        return -1
    }
}
