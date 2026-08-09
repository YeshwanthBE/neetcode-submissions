/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Map<Integer,Node> valVsNode = new HashMap<>();
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(node);
        

        boolean[] isVisited = new boolean[100];
        isVisited[node.val-1]=true;


        while(!stack.isEmpty()){
            Node oldNode = stack.pop();

            Node newNode = valVsNode.computeIfAbsent(oldNode.val,k->new Node(k));

            for(var neighbor : oldNode.neighbors){
                newNode.neighbors.add(valVsNode.computeIfAbsent(neighbor.val,k->new Node(k)));
                if(!isVisited[neighbor.val-1]){
                    isVisited[neighbor.val-1]=true;
                    stack.push(neighbor);
                }
            }

            

        }

        return valVsNode.get(node.val);
    }
}