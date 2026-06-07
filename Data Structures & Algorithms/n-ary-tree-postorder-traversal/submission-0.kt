/*
// Definition for a Node.
class Node(var `val`: Int) {
    var children: MutableList<Node> = mutableListOf()
}
*/

class Solution {
    fun postorder(root: Node?): List<Int> {

        val ans = mutableListOf<Int>()

        fun dfs(root:Node?){
            if(root == null) return

            root.children.forEach{
                dfs(it)
            }

            ans.add(root.`val`)
        }

        dfs(root)

        return ans.toList()
    }
}
