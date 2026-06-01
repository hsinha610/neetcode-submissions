class Solution {
    fun findBuildings(heights: IntArray): IntArray {
        val ans = mutableListOf<Int>()
        var maxTillNow = -1

        for(i in heights.lastIndex downTo 0){
            if(heights[i] > maxTillNow){
                ans.add(i)
                maxTillNow = heights[i]
            }
        }

        return ans.reversed().toIntArray()
    }
}
