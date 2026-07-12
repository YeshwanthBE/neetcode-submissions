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

    public ListNode merge2List(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode();
        ListNode head = dummy;

        ListNode l1 = list1,l2=list2;

        while(l1!=null && l2 !=null){
            if(l1.val > l2.val){
                head.next=l2;
                l2 = l2.next;
            }
            else{
                head.next = l1;
                l1=l1.next;
            }
            head=head.next;
        }

        while(l1!=null){
            head.next = l1;
            l1=l1.next;
            head=head.next;
        }

        while(l2!=null){
            head.next = l2;
            l2=l2.next;
            head=head.next;
        }

        return dummy.next;
    }

    public ListNode merge(ListNode[] lists,int left,int right){
       if(left==right){
            return lists[left];
       }

       int mid = left + (right-left)/2;

       ListNode l1 = merge(lists,left,mid);
       ListNode l2 = merge(lists,mid+1,right);

       return merge2List(l1,l2);
        
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length < 2){
            return lists.length == 1 ? lists[0] : null;
        }

        return merge(lists,0,lists.length-1);
    }
}
