class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        
        val ans = mutableSetOf<List<Int>>()

        nums.sort()

        fun helper(i: Int, subset: MutableList<Int>){
            if(i == nums.size){
                ans.add(subset.toList())
                return
            }

            subset.add(nums[i])
            helper(i+1,subset)
            subset.removeLast()
            helper(i+1,subset)
        }

        helper(0,mutableListOf())

        return ans.toList()
    }
}
