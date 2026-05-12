/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode h1 = list1, h2 = list2;
        ListNode ans = null;
        ListNode tail = ans;

        if(h1 == null) return h2;
        if(h2 == null) return h1;

        while(h1!=null && h2!=null){
            if(h1.val <= h2.val){
                if(ans == null){
                    ans = h1;
                    tail = h1;
                } else {
                    tail.next = h1;
                    tail = tail.next;
                }
                h1 = h1.next;
            } else {
                if(ans == null){
                    ans = h2;
                    tail = h2;
                } else {
                    tail.next = h2;
                    tail = tail.next;
                }
                h2=h2.next;
            }
        }
        if(h1!=null){
            tail.next = h1;
        }
        if(h2!=null){
            tail.next = h2;
        }

        return ans;
    }
}