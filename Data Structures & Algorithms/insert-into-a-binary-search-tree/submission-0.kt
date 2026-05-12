/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if(root==null) return TreeNode(`val`)

        insert(root, `val`)

        return root
    }

    fun insert(root: TreeNode?, v: Int){
        if(root==null) return
        if(v > root.`val`){
            if(root.right==null){
                root.right = TreeNode(v)
            } else {
                insert(root.right,v)
            }
        } else {
            if(root.left==null){
                root.left = TreeNode(v)
            } else {
                insert(root.left,v)
            }
        }
    }
}
