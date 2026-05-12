/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {

        val ans = mutableListOf<Int>()

        fun dfs(root: TreeNode?){
            if(root == null) return

            dfs(root.left)
            dfs(root.right)
            ans.add(root.`val`)
        }

        dfs(root)

        return ans
    }
}
