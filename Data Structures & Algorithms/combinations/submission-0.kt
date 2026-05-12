class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {

        val ans = mutableSetOf<List<Int>>()

        fun helper(localAns: MutableList<Int>, start: Int) {

            if(localAns.size == k){
                ans.add(localAns.sorted())
                return
            }

            for(i in start..n){
                localAns.add(i)

                helper(localAns, i+1)

                localAns.removeLast()
            }



        }

        helper(mutableListOf(), 1)

        return ans.toList()
    }
}
