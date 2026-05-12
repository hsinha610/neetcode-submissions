class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {

        val g = generateGraph(edges)
        val visited = BooleanArray(n+1)
        var count = 0

        for(i in 0..<n){
            if(visited[i].not()){
                dfs(i,g,visited)
                count++
            }
        }

        return count
    }

    fun generateGraph(edges: Array<IntArray>): MutableMap<Int,MutableList<Int>>{
        
        val graph = mutableMapOf<Int,MutableList<Int>>()

        edges.forEach{
            graph.computeIfAbsent(it.first()){mutableListOf()}.add(it.last())
            graph.computeIfAbsent(it.last()){mutableListOf()}.add(it.first())
        }

        return graph
    }

    fun dfs(i:Int, g:MutableMap<Int,MutableList<Int>>, visited: BooleanArray){
        visited[i] = true

        g[i]?.forEach{
            if(visited[it].not()){
                dfs(it,g,visited)
            }
        }
    }
}
