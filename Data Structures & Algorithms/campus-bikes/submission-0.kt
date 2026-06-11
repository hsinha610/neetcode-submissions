class Solution {
    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): IntArray {

        val pq = PriorityQueue<Triple<Int,Int,Int>>(compareBy({it.third},{it.first}, {it.second}))

        workers.forEachIndexed{ iw, (xw,yw) ->
            bikes.forEachIndexed{ ib, (xb,yb) ->
                pq.offer(Triple(iw,ib,Math.abs(xw-xb)+Math.abs(yw-yb)))
            }
        }

        val ans = IntArray(workers.size){-1}
        var count = workers.size
        var bikeTaken = BooleanArray(bikes.size)

        while(count!=0 && pq.isNotEmpty()){
            val (iw,ib,dist) = pq.poll()
            println("$iw, $ib, $dist")

            if(ans[iw]== -1 && bikeTaken[ib].not()){
                ans[iw] = ib
                bikeTaken[ib] = true
                count--
            }
        }

        return ans
    }
}
