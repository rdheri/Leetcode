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
    public boolean hasCycle(ListNode head) {
        ListNode ptr = head;
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        while(ptr!=null) {
            if(map.containsValue(ptr.val)) {
                return true;
            }
            else {
            map.put(ptr.val, index);
            index++;
        }
        ptr = ptr.next;
    }
    return false;
    }
}
