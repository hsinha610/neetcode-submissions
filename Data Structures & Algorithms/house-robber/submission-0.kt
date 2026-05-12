class Solution {

    val mem = IntArray(101){ -1 }
    fun rob(nums: IntArray): Int {

        if(nums.size == 1) return nums[0]

        var ans = 0

        ans = max(dfs(0,nums), dfs(1,nums))

        return ans

    }

    fun dfs(i: Int, nums: IntArray): Int{
        if(i > nums.lastIndex){
            return 0
        }

        if(mem[i]!= -1) return mem[i]

        
        var ans = 0

        for( j in (i+2)..nums.lastIndex){
            ans = max(ans, dfs(j,nums))
        }

        mem[i] = nums[i] + ans


        
        return mem[i]
    }
}
