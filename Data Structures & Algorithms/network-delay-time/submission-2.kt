class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {

        val graph = getGraph(times,n)

        val minHeap = PriorityQueue<Pair<Int,Int>>(compareBy({ it. second }))

        minHeap.add(k to 0)

        val time = IntArray(n+1){  Int.MAX_VALUE }

        while(minHeap.isNotEmpty()){
            val (cNode,cTime) = minHeap.poll()

            if(cTime < time[cNode] ){
                time[cNode] = cTime

            for((nbrNode,nbrTime) in graph[cNode]){
               val newTime = cTime + nbrTime
               if(newTime < time[nbrNode])
                minHeap.add(nbrNode to newTime)
            }
            }

            
        }

        val timeList = time.toList().drop(1)

        if(timeList.any{ it == Int.MAX_VALUE}){
            return -1
        }


        return timeList.max()


    }

    fun getGraph(times: Array<IntArray>, n: Int) : Array<MutableList<Pair<Int,Int>>> {
        val graph = Array<MutableList<Pair<Int,Int>>>(n+1){ mutableListOf() }
        
        for((u,v,t) in times){
            graph[u].add( v to t)
        }

        return graph
    }
}
