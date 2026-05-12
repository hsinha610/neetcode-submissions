class Solution {
    fun openLock(deadends: Array<String>, target: String): Int {

        if("0000" in deadends) return -1
        
        val q = LinkedList<Pair<String,Int>>()

        q.add("0000" to 0)

        val visited = mutableSetOf<String>()

        visited.add("0000")

        var ans = -1

        while(q.isNotEmpty()){
            val (node,dist) = q.poll()

            if(node == target){
                ans = dist
                break
            } else {
                for(i in 0..3){
                    var c = IntArray(4){ node[it] - '0'}

                    c[i] = (c[i]+1)%10
                    val nbr1 = c.joinToString("")
                    if(nbr1 !in deadends && nbr1 !in visited){
                        visited.add(nbr1)
                        q.add(nbr1 to dist+1)
                    }

                    c[i] = (c[i]- 2 +10)%10
                    val nbr2 = c.joinToString("")
                    if(nbr2 !in deadends && nbr2 !in visited){
                        visited.add(nbr2)
                        q.add(nbr2 to dist+1)
                    }
                }
            }

        }

        return ans

    }
}
