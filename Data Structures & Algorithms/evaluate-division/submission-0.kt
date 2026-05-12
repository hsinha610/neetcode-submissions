class Solution {

    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val graph = getGraph(equations,values)

        val ans = mutableListOf<Double>()

        queries.forEach{ (c,d)->
             if(graph.containsKey(c) == false || graph.containsKey(d) == false){
                ans.add(-1.0)
            } else if(c==d){
                ans.add(1.0)
            } else {
                val (prod,valid) = dfs(c,d,graph,mutableSetOf(),1.0)
                if(valid){
                    ans.add(prod)
                } else {
                    ans.add(-1.0)
                }
            }
        }

        return ans.toDoubleArray()

    }

    fun dfs(node: String, target: String, graph: Map<String,List<Pair<String,Double>>>, visited: MutableSet<String>, prod: Double) : Pair<Double, Boolean> {
        if(node in visited) return prod to false
        if(node == target) return prod to true
        visited.add(node)

        var found = false
        var ans = 1.0
        graph[node]?.forEach{ (nbr,wt)->
            val localAns = dfs(nbr,target,graph,visited, prod * wt)

            if(localAns.second){
                found = true
                ans = localAns.first
            }
        }

        return ans to found
    }

    fun getGraph(equations: List<List<String>>, values: DoubleArray) : Map<String,List<Pair<String,Double>>> {
        val graph = mutableMapOf<String,MutableList<Pair<String,Double>>>()

        equations.forEachIndexed{ i, (a,b) ->
            graph.computeIfAbsent(a){mutableListOf()}.add(b to values[i])
            graph.computeIfAbsent(b){mutableListOf()}.add(a to (1/values[i]))
        }

        return graph
    }
}
