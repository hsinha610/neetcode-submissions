/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {

        if(node==null) return null

        val relations = Array<MutableSet<Int>>(101){ mutableSetOf()}
        val visited = BooleanArray(101)

        dfs(node,visited,relations)

        
        val newNodes = Array<Node>(101){ Node(it)}

        relations.forEachIndexed{ index, nodes->

            nodes.forEach{ node->

             newNodes[index].neighbors.add(newNodes[node])
             newNodes[node].neighbors.add(newNodes[index])
            }
        }

        newNodes.forEach{
            it.neighbors = ArrayList(it.neighbors.distinct())
        }

        return newNodes[1]


    }

    fun dfs(node: Node?, visited: BooleanArray, relations: Array<MutableSet<Int>>){
        if(node==null) return

        visited[node.`val`] = true

        node?.neighbors?.filterNotNull()?.forEach{

            relations[node.`val`].add(it.`val`)
            relations[it.`val`].add(node.`val`)

            if(visited[it.`val`]==false){
                dfs(it,visited,relations)
            }
        }
    }
}
