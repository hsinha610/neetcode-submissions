class Solution {
    fun subsetXORSum(nums: IntArray): Int {

        var ans = 0

        fun helper(i:Int, xr: Int){
            if(i==nums.size){
                ans += xr
                return
            }

    
            helper(i+1,xr xor nums[i])
            helper(i+1,xr)
        }

         helper(0,0)

         return ans
    }
}
