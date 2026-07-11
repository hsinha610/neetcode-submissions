class Solution {
    fun largestUniqueNumber(nums: IntArray): Int {
        nums.sort()

        var ans = -1

        val count = mutableMapOf<Int,Int>()

        nums.forEach{
            count[it] = (count[it]?:0) + 1
        }

        nums.forEach{
            if(count[it]==1){
                ans = it
            }
        }

        

        return ans
    }
}
