/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    var countGood = 0
    fun goodNodes(root: TreeNode?): Int {
        if(root == null) return countGood

        var maxSoFar = root.`val`

        dfs(root,-10001)

        return countGood
    }

    fun dfs(root: TreeNode?, maxSoFar: Int){
        if(root == null) return

        if(root.`val` >= maxSoFar) countGood++

        dfs(root.right, max(root.`val`, maxSoFar))
        dfs(root.left, max(root.`val`, maxSoFar))
    }
}
