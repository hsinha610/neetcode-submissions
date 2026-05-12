/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if(root == null) return emptyList()
        val ans = mutableListOf<Int>()

        fun dfs(root: TreeNode){

            root.left?.let{dfs(it)}
            ans.add(root.`val`)
            root.right?.let{dfs(it)}
        }

        dfs(root)

        return ans
    }
}
