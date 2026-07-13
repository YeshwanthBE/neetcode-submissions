/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public Deque<TreeNode> getPostOrderStack(TreeNode root){
        
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<TreeNode> nodeStack2 = new ArrayDeque<>();

        nodeStack.push(root);

        while(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            nodeStack2.push(node);

            if(node.left != null){
                nodeStack.push(node.left);
            }

            if(node.right != null){
                nodeStack.push(node.right);
            }
        }

        return nodeStack2;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        Deque<TreeNode> stack = getPostOrderStack(root);
        Map<TreeNode,Integer> nodeVsDepth = new HashMap<>();
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            int leftDepth = nodeVsDepth.getOrDefault(node.left,0);
            int rightDepth = nodeVsDepth.getOrDefault(node.right,0);

            if(Math.abs(leftDepth-rightDepth) > 1){
                return false;
            }

            nodeVsDepth.put(node,Math.max(leftDepth,rightDepth)+1);
        }

        return true;
    }
}
