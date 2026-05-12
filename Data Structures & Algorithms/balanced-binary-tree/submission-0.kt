/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    val mem = mutableMapOf<TreeNode,Int>()

    fun isBalanced(root: TreeNode?): Boolean {
        if(root == null) return true
        
        val heightL = getHeight(root.left)
        val heightR = getHeight(root.right)

        return abs(heightL-heightR) <=1 && isBalanced(root.left) && isBalanced(root.right)

    }

    fun getHeight(root: TreeNode?): Int {
        if(root==null) return 0
        if(mem[root]!=null) return mem[root] ?: 0

        mem[root] = 1 + max(getHeight(root.left), getHeight(root.right))
        return mem[root] ?: 0
    }
}
