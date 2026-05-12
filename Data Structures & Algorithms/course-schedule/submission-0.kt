class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {

        val graph = mutableMapOf<Int, MutableList<Int>>()
        val indegree = IntArray(numCourses){ 0 }
        prerequisites.forEach{
            graph.computeIfAbsent(it.last()){mutableListOf()}.add(it.first())
            indegree[it.first()]++
        }

        val q = LinkedList<Int>()

        indegree.forEachIndexed{idx, i->
            if(i==0){
                q.add(idx)
            }
        }

        val ans = mutableListOf<Int>()

        while(q.isNotEmpty()){
            val node = q.poll()
            ans.add(node)
            graph[node]?.forEach{
                indegree[it]--
                if(indegree[it]==0){
                    q.add(it)
                }
            }
        }

        return ans.size == numCourses
    }
}
