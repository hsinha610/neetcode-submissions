/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if(root1==null && root2 == null) return null
        if(root1==null) return root2
        if(root2==null) return root1

        return TreeNode((root1?.`val` ?: 0) + (root2?.`val` ?: 0)).apply{
            left = mergeTrees(root1.left,root2.left)
            right = mergeTrees(root1.right,root2.right)
        }
    }

}
