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
        int len=0;
        ListNode h1=head;
        while(h1!=null){
            h1=h1.next;len++;
        }
        int deleteIdx = len-n;

        if(deleteIdx == 0){
            return head.next;
        }

        h1=head;
        while(--deleteIdx>0){
            h1=h1.next;
        }
        h1.next=h1.next.next;

        return head;
    }
}
