class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {

        val indegree = IntArray(n+1){0}
        val outdegree = IntArray(n+1){0}

        trust.forEach{ (a,b)->
            outdegree[a]++
            indegree[b]++
        }

        for(i in 1..n){
            if(outdegree[i]==0 && indegree[i]==(n-1)){
                return i
            }
        }

        return -1
    }
}
