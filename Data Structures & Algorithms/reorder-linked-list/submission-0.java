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
    public void reorderList(ListNode head) {
        /*if(head == null || head.next == null) continue;*/
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null;
        ListNode curr = slow;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode start = head;
        ListNode end = prev;
        while(end.next != null){
            ListNode tempStart = start.next;
            ListNode tempPrev = end.next;
            start.next = end;
            end.next = tempStart;
            start = tempStart;
            end = tempPrev;
        }
    }
}
