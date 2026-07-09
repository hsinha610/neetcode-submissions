/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if(root==null) return 0
        
        return ((root!!.`val`).takeIf{it >= low && it <= high} ?: 0) + rangeSumBST(root?.left, low, high) + rangeSumBST(root?.right, low, high)
    }
}
