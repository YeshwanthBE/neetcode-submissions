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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q ==null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }
        
        Deque<TreeNode> nodeStack1 = new ArrayDeque<>();nodeStack1.push(p);
        Deque<TreeNode> nodeStack2 = new ArrayDeque<>();nodeStack2.push(q);

        while(!nodeStack1.isEmpty() && !nodeStack2.isEmpty()){
            TreeNode node1 = nodeStack1.pop();
            TreeNode node2 = nodeStack2.pop();

            if(node1.val != node2.val){
                return false;
            }

            if(node1.left != null && node2.left != null){
                nodeStack1.push(node1.left);
                nodeStack2.push(node2.left);
            }else if(node1.left != node2.left){
                return false;
            }

            if(node1.right != null && node2.right != null){
                nodeStack1.push(node1.right);
                nodeStack2.push(node2.right);
            }else if(node1.right != node2.right){
                return false;
            }

        }

        return true;
    }
}
