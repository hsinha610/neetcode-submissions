class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {

        var left = 0
        var right = arr.lastIndex

        while(right-left+1 > k) {
            val d1 = abs(x-arr[left])
            val d2 = abs(x-arr[right])

            if(d1 < d2){
                right--
            } else if(d1 > d2){
                left++
            } else {
                right--
            }
        }

        val ans = mutableListOf<Int>()

        while(left<=right){
            ans.add(arr[left++])
        }

        return ans
    }
}
