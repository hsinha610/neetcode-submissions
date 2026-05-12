class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {

        val graph = getGraph(flights)

        val cost = IntArray(n){ Int.MAX_VALUE }

        val minHeap = PriorityQueue<Triple<Int,Int,Int>>(compareBy({it.first}))

        minHeap.add(Triple(0,src,-1))

        while(minHeap.isNotEmpty()){
            val (cCost, cNode, cStop) = minHeap.poll()

            if(cStop <= k ){

            if(cStop == k && cNode != dst) continue
            if(cNode == dst && cCost > cost[cNode]) continue

                cost[cNode] = cCost

                graph[cNode]?.forEach{ (nbrNode, nbrCost) ->

                val newCost = cCost + nbrCost

                if(newCost < cost[nbrNode])
                minHeap.add(Triple(newCost, nbrNode, cStop+1))


            }
            }

            
        }

        val ans = if(cost[dst] == Int.MAX_VALUE) -1 else cost[dst]

        return ans
    }

    fun getGraph(flights: Array<IntArray>) : Map<Int,List<Pair<Int,Int>>>{

        val map = mutableMapOf<Int,MutableList<Pair<Int,Int>>>()

        flights.forEach{ (start, end, cost)->

            map.computeIfAbsent(start){mutableListOf()}.add(end to cost)
        }

        return map
    }
}
