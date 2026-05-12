/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if(root == null) return emptyList()

        val ans = mutableListOf<Int>()

        val q = LinkedList<TreeNode>()
        q.add(root)

        while(q.isNotEmpty()){

            val itemsInQ = q.size

            repeat(itemsInQ){
                val node = q.poll()
                node.left?.let{ q.add(it)}
                node.right?.let{ q.add(it)}

                if(it == itemsInQ-1){
                    ans.add(node.`val`)
                }
            }
        }

        return ans.toList()

    }
}
