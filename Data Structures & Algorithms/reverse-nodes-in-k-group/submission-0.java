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

    public ListNode getKthNode(ListNode head, int k){
        while(head!=null && --k>0){
            head=head.next;
        }
        return head;
    }

    public ListNode reverseList(ListNode head,ListNode tail){
        ListNode prev = null;
        while(head!=tail){
            ListNode temp = head.next;
            head.next = prev;
            prev=head;
            head=temp;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode();
        ListNode h1 = dummy;h1.next=head;
        
        while(h1.next!=null){
            
            ListNode kthNode = getKthNode(h1.next,k);
            if(kthNode == null){
                break;
            }
            ListNode tailNode = h1.next;
            ListNode nextGroup = kthNode.next;
            h1.next = reverseList(h1.next,nextGroup);
            
            tailNode.next=nextGroup;
            h1=tailNode;
        }

        return dummy.next;
    }
}
