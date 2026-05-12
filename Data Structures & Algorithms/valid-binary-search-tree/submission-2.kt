/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    val elements = mutableListOf<Int>()

    fun isValidBST(root: TreeNode?): Boolean {
        dfs(root)

        return elements.zipWithNext().all { it.first < it.second}
    }

    fun dfs(root: TreeNode?){
        if(root==null) return

        dfs(root.left)
        elements.add(root.`val`)
        dfs(root.right)
    }
}
