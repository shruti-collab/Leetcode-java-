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
        ListNode temp = head;

        for( int i = 1; i <= n; i++ ) {
            temp = temp.next;
        }

        if( temp == null ) {        // corner case : l == n
            ListNode newHead = head.next;
            head = null;
            return newHead;
        }

        ListNode curr = head;
        while( temp.next != null ) {
            temp = temp.next;
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;
    }
}