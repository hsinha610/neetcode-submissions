/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {

        if(root == null) return emptyList()
        
        val ans = mutableListOf<List<Int>>()

        val q = LinkedList<TreeNode>()

        q.add(root)

        while(q.isNotEmpty()){
            val localAns = mutableListOf<Int>()
            repeat(q.size){
                val n = q.poll()
                localAns.add(n.`val`)
                n.left?.let {
                    q.add(it)
                }
                n.right?.let{
                    q.add(it)
                }
            }

            ans.add(localAns.toList())

        }

        return ans.toList()

    }
}
