class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        
        for(i in nums.indices){
            for(j in nums.indices){
                if(i!=j){
                    if(nums[i]+nums[j]==target){
                        return intArrayOf(i,j).apply{ sort()}
                    }
                }
            }
        }

        return intArrayOf()
    }
}
