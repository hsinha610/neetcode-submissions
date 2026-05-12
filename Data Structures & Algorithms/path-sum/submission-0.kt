/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if(root == null) return false

        return backtrack(root.`val`, root, targetSum)
    }

    fun backtrack(sum: Int, root: TreeNode, targetSum: Int): Boolean {
        if(sum == targetSum && root.left==null && root.right == null) return true

       return (root.left?.let{
            backtrack(sum + it.`val`, it, targetSum)
        } ?: false ) or (root.right?.let{
            backtrack(sum + it.`val`, it, targetSum)
        } ?: false)
    }
}
