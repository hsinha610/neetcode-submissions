class Solution {
    fun maxArea(heights: IntArray): Int {
        var ans = 0

        for(i in 0..heights.lastIndex){
            for(j in i+1..heights.lastIndex){
                ans = max(ans, (j-i) * min(heights[i],heights[j]))
            }
        }

        return ans
    }
}
