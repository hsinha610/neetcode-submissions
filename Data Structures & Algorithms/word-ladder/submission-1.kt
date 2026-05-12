class Solution {
    val graph = mutableMapOf<String, MutableSet<String>>()

    fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>): Int {

        var ans = when(getNumberOfDiffChars(beginWord, endWord)){
            0 -> 0
            else -> null
        }

        if(ans != null){
            return ans
        } else {
            wordList.forEach{
                if(getNumberOfDiffChars(it,beginWord) == 1){
                    graph.computeIfAbsent(beginWord){ mutableSetOf()}.add(it)
                }
            }

            for(i in wordList){
                for(j in wordList){
                    if(i!=j){
                        if(getNumberOfDiffChars(i,j) == 1){
                            graph.computeIfAbsent(i){ mutableSetOf()}.add(j)
                            graph.computeIfAbsent(j){ mutableSetOf()}.add(i)
                        }
                    }
                }
            }

            val q = LinkedList<String>()
            val visited = mutableMapOf<String,Boolean>()
            q.add(beginWord)
            visited[beginWord] = true

            var step = 0

            while(q.isNotEmpty()){
                step++
                repeat(q.size){
                    val node = q.poll()
                    if(node == endWord){
                        ans = step
                    }
                    graph[node]?.forEach{ nbr ->
                        if((visited[nbr] ?: false)  == false){
                            visited[nbr] = true
                            q.add(nbr)
                        }
                    }
                }
                
            }

            return ans ?: 0
        }

        return 0

    }

    fun getNumberOfDiffChars(s1: String, s2: String): Int {

        var count = 0

        for(i in 0 until s1.length){
            if(s1[i] != s2[i])
                count++
        }

        return count
    }
}
