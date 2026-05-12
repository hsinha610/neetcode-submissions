class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {

        val ans = mutableSetOf<List<Int>>()

        fun helper(candidate: MutableList<Int>, localTarget: Int, idx: Int) {
            if(localTarget < 0) return
            if(localTarget == 0){
                ans.add(candidate.sorted())
                return
            }
            
            for(i in idx..candidates.lastIndex){
                candidate.add(candidates[i])
                helper(candidate, localTarget - candidates[i], i+1)
                candidate.removeLast()
            }
        }

        helper(mutableListOf(), target, 0)

        return ans.toList()
    }
}
