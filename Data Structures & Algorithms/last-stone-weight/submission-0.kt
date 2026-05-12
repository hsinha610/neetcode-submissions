class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        
        val maxHeap = PriorityQueue<Int>(reverseOrder()).apply{
            addAll(stones.toList())
        }


        while(maxHeap.size>1){
            val x = maxHeap.poll()
            val y = maxHeap.poll()

            if(x!=y){
                maxHeap.add(abs(x-y))
            }
        }

        return if(maxHeap.isNotEmpty()) maxHeap.poll() else 0
    }
}
