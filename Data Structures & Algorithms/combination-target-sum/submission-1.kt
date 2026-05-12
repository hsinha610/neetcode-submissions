class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort( )
        val ans = mutableListOf<List<Int>>()

        fun helper(combo: MutableList<Int>, target: Int){
            if(target < 0) return
            if(target == 0) {
                ans.add(combo.toList())
                return
            }

            for(i in nums){
                if(target - i < 0) return
                combo.add(i)
                helper(combo,target-i)
                combo.removeLast()
            }
        }

        helper(mutableListOf(), target)

        return ans.map{ it.sorted()}.toSet().toList()

    }
}
