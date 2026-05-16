class Solution {
    fun maxArea(heights: IntArray): Int {
        
        var left = 0
        var right = heights.lastIndex

        var ans = (right-left) * min(heights[right], heights[left])

        while(left < right){
            ans = max(ans, (right-left) * min(heights[right], heights[left]))

            if(heights[left]<heights[right]){
                left++
            } else {
                right--
            }
        }

        return ans
    }
}
