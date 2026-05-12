class Solution {
    val graph = mutableMapOf<Int,MutableList<Int>>()

    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val indegree = IntArray(edges.size + 1){ 0 }
        val outdegree = IntArray(edges.size + 1){ 0 }

        edges.forEach{ (a,b) ->
            indegree[a]++
            indegree[b]++
            outdegree[a]++
            outdegree[b]++

            graph.computeIfAbsent(a){ mutableListOf()}.add(b)
            graph.computeIfAbsent(b){ mutableListOf()}.add(a)
        }

        val ans = IntArray(2){ 0 }

        var x = edges.toList()

        while(x.any{nodes -> nodes.any{ indegree[it]==1 && outdegree[it]==1}}) {
            val nodesToRemove = x.filter{nodes -> nodes.any{ indegree[it]==1 && outdegree[it]==1}}

            nodesToRemove.forEach{ (a,b) ->
                println("$a , $b")
                indegree[a]--
                indegree[b]--
                outdegree[a]--
                outdegree[b]--
            }

            x = x.filterNot{ it in nodesToRemove}
        }
       println(x.map{ "" + it.first() +" , " + it.last()}.joinToString("|"))

        x.reversed().forEach{ (a,b) ->

            if(ans[0] == 0){
                ans[0] = a
                ans[1] = b
            }
        }

        return ans
    }
}
