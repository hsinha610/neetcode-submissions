class Solution {
    fun singleNonDuplicate(nums: IntArray): Int {

        var start = 0
        var end = nums.lastIndex

        while(start <= end){
            val mid = start + (end-start)/2

            val left = mid-1
            val right = mid+1

            if(left < 0 && right > nums.lastIndex){
                return nums[mid]
            }

            if(left < 0 && nums[mid]!=nums[right]){
                return nums[mid]
            }

            if(left < 0 && nums[mid]==nums[right]){
                start = mid+1
            }

            if(right > nums.lastIndex && nums[mid]!=nums[left]){
                return nums[mid]
            }

            if(right > nums.lastIndex && nums[mid]==nums[left]){
                end=mid-1
            }

            if(nums[mid] != nums[right] && nums[mid] != nums[left]){
                return nums[mid]
            }

            if(nums[mid]==nums[left] && nums[mid]!=nums[right] && mid%2==0){
                end = mid-1
                continue
            }

            if(nums[mid]!=nums[left] && nums[mid]==nums[right] && mid%2==1){
                end = mid-1
                continue
            }

            if(nums[mid]==nums[left] && nums[mid]!=nums[right] && mid%2==1){
                start = mid+1
                continue
            }

            if(nums[mid]!=nums[left] && nums[mid]==nums[right] && mid%2==0){
                start = mid+1
                continue
            }
        }

        return -1
    }
}
