class Solution {
    fun findPeakElement(nums: IntArray): Int {
        var start = 0
        var end = nums.lastIndex

        var ans = -1

        while(start <= end){

            val mid = start + (end-start)/2

            val left = mid-1
            val right = mid+1

            if(left < 0 && right > nums.lastIndex){
                ans = mid
                break
            }

            if(left >= 0 && right > nums.lastIndex && nums[mid] > nums[left]){
                ans = mid
                break
            }

            if(left >= 0 && right > nums.lastIndex && nums[mid] < nums[left]){
                end = mid-1
            }

            if(left < 0 && right <= nums.lastIndex && nums[mid] > nums[right]){
                ans = mid
                break
            }

            if(left < 0 && right <= nums.lastIndex && nums[mid] < nums[right]){
                start = mid+1
            }

            if(left >= 0 && right <= nums.lastIndex){
                if(nums[left]<nums[mid] && nums[right]<nums[mid]){
                    ans = mid
                    start = mid+1
                    end = mid-1
                } else if(nums[left]<nums[mid] && nums[right]>nums[mid]){
                    start = mid+1
                } else if(nums[right]<nums[mid]){
                    end = mid-1
                } else if(nums[left]>nums[mid] && nums[right]>nums[mid]){
                    if(nums[start] > nums[end]){
                        end = mid-1
                    } else{
                        start = mid+1
                    }
                }
            }

        }

        return ans
    }
}
