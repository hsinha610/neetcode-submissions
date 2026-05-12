class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        
        val maxHeap = PriorityQueue<Pair<Int, IntArray>>(compareBy({-it.first}))

        points.forEach{

            maxHeap.add((it[0]*it[0] + it[1]*it[1]) to it)

            if(maxHeap.size > k){
                maxHeap.poll()
            }
        }

        return maxHeap.map{it.second}.toTypedArray()


    }
}
