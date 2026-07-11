/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Node cur = head;
        
        while(cur!=null){
            Node copyCur = new Node(cur.val);
            copyCur.next = cur.next;
            cur.next = copyCur;
            cur =copyCur.next;
        }

        cur = head;

        while(cur!=null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur=cur.next.next;
        }

        cur = head;
        Node dummy = new Node(-1);
        Node newCur = dummy;

        while(cur!=null){
            newCur.next = cur.next;
            cur.next=cur.next.next;
            newCur=newCur.next;
            cur=cur.next;
        }
        return dummy.next;
    }
}
