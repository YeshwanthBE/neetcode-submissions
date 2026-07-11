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
        Map<Node,Node> oldVsNew = new HashMap<>();
        Node dummy = new Node(-1);
        Node cur = dummy;

        while(head != null){
            Node newNode = oldVsNew.computeIfAbsent(head,oldNode->new Node(oldNode.val));
            Node newRandomNode = null;
            if(head.random !=null){
                newRandomNode = oldVsNew.computeIfAbsent(head.random,oldNode->new Node(oldNode.val));
            }
            newNode.random = newRandomNode;
            cur.next=newNode;cur=cur.next;
            head=head.next;
        }

        return dummy.next;
    }
}
