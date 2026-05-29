class Solution {
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {

        val minHeap = PriorityQueue<Pair<Int,Int>>(compareBy({it.first},{it.second}))

        for(i in nums.indices){
            minHeap.add(nums[i] to i)
        }

        repeat(k){
            val (a,b) = minHeap.poll()
            nums[b] = a*multiplier
            minHeap.add(nums[b] to b)
        }

        return nums
    }
}
