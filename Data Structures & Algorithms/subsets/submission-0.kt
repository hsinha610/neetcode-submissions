class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {

        val ans = mutableListOf<List<Int>>()

        val subset = mutableListOf<Int>()

        fun dfs(subset: MutableList<Int>, i:Int){
            if(i == nums.size){
                ans.add(subset.toList())
                return
            }

            subset.add(nums[i])
            dfs(subset,i+1)
            subset.removeLast()
            dfs(subset,i+1)
        }

        dfs(subset,0)

        return ans
    }
}
