class Solution {

    val mem = IntArray(101){ -1 }
    
    fun minCostClimbingStairs(cost: IntArray): Int {
        val i = cost.size
        return min(help(i-1,cost), help(i-2, cost))
    }

    fun help(i: Int, cost: IntArray) : Int {
        if(i == 0 || i == 1) return cost[i]

        if(mem[i] != -1) return mem[i]

        mem[i] = cost[i] + min(help(i-1,cost), help(i-2, cost))


        return mem[i]
    
    }
}
