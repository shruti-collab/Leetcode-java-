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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        while(p2!=null){
            if(p2.val==p1.val){
                while(p2!=null && p2.val==p1.val){
                    p2=p2.next;
                }
                prev.next=p2;
                p1=p2;
                if(p2!=null) p2=p2.next;
            }
            else{
                p1=p1.next;
                p2=p2.next;
                prev=prev.next;
            }
        }
        return dummy.next;
    }
}