class Solution {
    fun permute(nums: IntArray): List<List<Int>> {

        val ans = mutableListOf<List<Int>>()

        fun dfs(permutation: MutableList<Int>, nums: IntArray){
            if(permutation.size == nums.size){
                ans.add(permutation.toList())
                return
            }

            val remaining = nums.toList() - permutation

            for(i in remaining){
                    permutation.add(i)
                    dfs(permutation, nums)
                    permutation.removeLast()
            }
        }

        dfs(mutableListOf<Int>(), nums)

        return ans.toList()


    }

    
}
