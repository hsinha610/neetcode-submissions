class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {

            val indegree = IntArray(numCourses+1){ 0 }

            val graph = mutableMapOf<Int,MutableList<Int>>()

            prerequisites.forEach { (a,b)->

                indegree[a]++
                graph.computeIfAbsent(b){mutableListOf()}.add(a)
            
            }

            val q :Queue<Int> = LinkedList<Int>()

            val ans = mutableListOf<Int>()

            for(i in 0 until numCourses){
                if(indegree[i]==0){
                    q.add(i)
                    ans.add(i)
                }
            }


            while(q.isNotEmpty()){
                val node = q.poll()

                graph[node]?.forEach{ nbr ->

                    indegree[nbr]--

                    if(indegree[nbr]==0){
                        q.add(nbr)
                        ans.add(nbr)
                    }
                }

            }

           return if(ans.size != numCourses){
                intArrayOf()
            } else {
                IntArray(numCourses){ ans[it]}
            }
    }
}
