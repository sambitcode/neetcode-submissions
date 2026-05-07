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
    /*public ListNode reverseList(ListNode head) {
        
    }*/

    public ListNode reverseList(ListNode head) {
        return reverseListRecHelper(head);
    }

    private ListNode reverseListRecHelper(ListNode node) {
        if(node == null || node.next == null) return node;
        ListNode tempNode = reverseListRecHelper(node.next);
        node.next.next = node;
        node.next = null;
        return tempNode;
    }
}
