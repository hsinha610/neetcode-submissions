/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {

        val ans = mutableListOf<Int>()

        fun dfs(node: TreeNode?){
            if(node==null) return

            ans.add(node.`val`)
            dfs(node.left)
            dfs(node.right)
        }

        dfs(root)

        return ans
    }
}
