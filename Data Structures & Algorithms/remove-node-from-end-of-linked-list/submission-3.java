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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode slowPtr = dummy;
        ListNode fastPtr = dummy;
        dummy.next = head;
        ListNode sizePtr = head;
        int size = 0;

        for(int i = 0; i < n; i++) {
            fastPtr = fastPtr.next;
        }
        while(fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        slowPtr.next = slowPtr.next.next;;
        return dummy.next;
    }
}
