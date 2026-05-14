class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {

        val maxHeap = PriorityQueue<Pair<Int,Int>>(compareBy({ - it.first},{-it.second}))

        arr.forEach{
            maxHeap.add(abs(x-it) to it)
        }

        while(maxHeap.size > k){
            maxHeap.poll()
        }

        var ans = mutableListOf<Int>()

        var minHeap = PriorityQueue<Int>()

        while(maxHeap.isNotEmpty()){
            minHeap.add(maxHeap.poll().second)
        }

        while(minHeap.isNotEmpty()){
            ans.add(minHeap.poll())
        }

        return ans
    }
}
