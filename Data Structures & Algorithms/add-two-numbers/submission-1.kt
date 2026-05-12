/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return getSum(l1,l2,0)
    }

    private fun getSum(l1: ListNode?, l2: ListNode?, carry: Int) : ListNode?{
        if(l1 == null && l2 == null && carry != 0) return ListNode(carry)
        if(l1 == null && l2 == null) return null


        val sum = ((l1?.`val` ?: 0) + (l2?.`val` ?: 0) + carry)%10
        val carry = ((l1?.`val` ?: 0) + (l2?.`val` ?: 0) + carry)/10

        val ans = ListNode(sum)

        ans.next = getSum(l1?.next,l2?.next, carry)

        return ans
    }
}
