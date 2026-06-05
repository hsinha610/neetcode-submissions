import java.util.PriorityQueue

class Solution {
    fun highFive(items: Array<IntArray>): Array<IntArray> {

        val ans = mutableListOf<IntArray>()

        val pq = PriorityQueue<IntArray>(compareBy({it.first()}, {-it.last()}))

        items.forEach{
            pq.add(it)
        }

        while(pq.isNotEmpty()){
            var total = 0
            var id = -1
            repeat(5){
                val (i,s) = pq.poll()
                id= i
                total+=s
            }

            ans.add(intArrayOf(id, total/5))
            while(pq.isNotEmpty() && pq.peek().first()==id){
                pq.poll()
            }
        }

        return ans.toTypedArray()
    }
}
