class Solution {
    fun connectSticks(sticks: IntArray): Int {

        if(sticks.size<2) return 0

        val minHeap = PriorityQueue<Int>()

        sticks.forEach {
            minHeap.add(it)
        }
        var ans = 0

        while(minHeap.size>1){
            val a = minHeap.poll()
            val b = minHeap.poll()
            ans+= a+b
            minHeap.add(a+b)
        }

        return ans
    }
}
