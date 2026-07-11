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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1,h2=l2,dummy=new ListNode();
        ListNode h3=dummy;
        int carry =0;
        while(h1!=null && h2!=null){
            int sum = h1.val+h2.val+carry;
            h3.next= new ListNode(sum%10);
            carry = sum/10;
            h1=h1.next;h2=h2.next;h3=h3.next;
        }

        while(h1!=null){
            int sum = h1.val+carry;
            h3.next= new ListNode(sum%10);
            carry = sum/10;
            h1=h1.next;h3=h3.next;
        }
        while(h2!=null){
            int sum = h2.val+carry;
            h3.next= new ListNode(sum%10);
            carry = sum/10;
            h2=h2.next;h3=h3.next;
        }
        if(carry!=0){
            h3.next= new ListNode(carry);
        }
        return dummy.next;
    }
}
