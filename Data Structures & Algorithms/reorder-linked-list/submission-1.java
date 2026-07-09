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

    public ListNode getMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev=head;
            head = next;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode midNode = getMidNode(head);
        ListNode rlh = reverseList(midNode.next);midNode.next=null;
        
        for(ListNode h1 = head ;rlh!=null;h1=h1.next.next){
            ListNode temp = h1.next,temp2=rlh.next;
            h1.next = rlh;
            h1.next.next=temp;
            rlh=temp2;
        }
    }
}
