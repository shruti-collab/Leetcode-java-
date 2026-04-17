class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        if(head.next.next==null) return head;
        ListNode odd = new ListNode(-1);
        ListNode res = odd;
        ListNode even = new ListNode(-1);
        ListNode var = even;
        ListNode temp = head;
        int count = 1;
        while(temp!=null)
        {
            if(count%2!=0)
            {
                odd.next = temp;
                odd = temp;
                temp = temp.next;
                odd.next = null;
            }
            else
            {
                even.next = temp;
                even = temp;
                temp = temp.next;
                even.next = null;
            }
            count++;
        }
        odd.next = var.next;
        return res.next;
    }
}