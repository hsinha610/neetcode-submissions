class KthLargest(private val k: Int, private val nums: IntArray) {

    private val minHeap = PriorityQueue<Int>()

    init{
        nums.forEach{
            add(it)
        }
    }


    fun add(`val`: Int): Int {
         minHeap.add(`val`)

         if(minHeap.size>k){
            minHeap.poll()
         }

         return minHeap.peek()   
    }
}
