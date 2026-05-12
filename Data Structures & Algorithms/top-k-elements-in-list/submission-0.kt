class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        val minHeap = PriorityQueue<Pair<Int,Int>>(compareBy({it.second}))

        nums.toList().groupBy{it}.mapValues{ it.value.size}.forEach{

            minHeap.add(it.key to it.value)

            if(minHeap.size>k){
                minHeap.poll()
            }
        }

        return IntArray(k){ minHeap.poll().first}

    }
}
