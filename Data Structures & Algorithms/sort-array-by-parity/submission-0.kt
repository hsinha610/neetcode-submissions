class Solution {
    fun sortArrayByParity(nums: IntArray): IntArray {
        
        var start = 0
        var end = nums.lastIndex

        while(start <= nums.lastIndex && nums[start]%2==0){
            start++
        }

        while(end >= 0 && nums[end]%2==1){
            end--
        }

        while(start < end){
            if(nums[start]%2==0){
                start++
            } else if(nums[end]%2==1){
                end--
            } else{ 
            val a= nums[start]
            nums[start]=nums[end]
            nums[end]=a
            start++
            end--
            }
        }

        return nums
    }
}
