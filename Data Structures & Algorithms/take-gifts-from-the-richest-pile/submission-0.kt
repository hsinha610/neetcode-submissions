class Solution {
    fun pickGifts(gifts: IntArray, k: Int): Long {

        val maxHeap = PriorityQueue<Long>(reverseOrder())

        gifts.forEach {
            maxHeap.add(it.toLong())
        }

        repeat(k){
            val n = maxHeap.poll()
            maxHeap.add(floor(sqrt(n.toDouble())).toLong())
        }

        return maxHeap.toList().sum()
    }
}
