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

    public void reorderList(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque();
        ListNode midNode = getMidNode(head);
        for(ListNode h1 = midNode.next;h1 != null;h1=h1.next){
            stack.push(h1);
        }

        for(ListNode h1 = head ;!stack.isEmpty();h1=h1.next.next){
            ListNode temp = h1.next;
            h1.next = stack.pop();
            h1.next.next=temp;
        }
        midNode.next=null;
    }
}
