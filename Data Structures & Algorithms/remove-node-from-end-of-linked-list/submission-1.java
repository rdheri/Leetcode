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
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        dummy.next = head;
        ListNode sizePtr = head;
        int size = 0;

        while(sizePtr != null) {
            sizePtr = sizePtr.next;
            size++;
        }

        if(size == 1 && n == 1) {
                head = null;
                return head;
            }

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
