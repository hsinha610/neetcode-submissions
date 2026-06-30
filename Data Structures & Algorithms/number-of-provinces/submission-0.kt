class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {

        val graph = mutableMapOf<Int,MutableList<Int>>()

        isConnected.forEachIndexed{ i, row->
            row.forEachIndexed{ j, connected ->
                if(connected==1){
                    graph.computeIfAbsent(i){mutableListOf()}.add(j)
                    graph.computeIfAbsent(j){mutableListOf()}.add(i)
                }
            }
        }

        val visited =  BooleanArray(isConnected.size)

        var ans = 0

        fun dfs(i:Int){
            if(visited[i]) return
            visited[i] = true

            graph[i]?.forEach{
                dfs(it)
            }
        }

        isConnected.forEachIndexed{ i, row->
            row.forEachIndexed{ j, connected ->
                if(connected == 1 && visited[i].not()){
                    ans++
                    dfs(i)
                }
            }
        }

        return ans
    }
}
