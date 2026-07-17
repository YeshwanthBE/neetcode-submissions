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
    class TwM{
        TreeNode node;
        int max;
        TwM(TreeNode node, int max){
            this.node = node;
            this.max=max;
        }
    }
    public int goodNodes(TreeNode root) {
        Deque<TwM> stack = new ArrayDeque<>();stack.push(new TwM(root,root.val));
        
        int goodNodeCount = 0;
        
        while(!stack.isEmpty()){
            TwM twm = stack.pop();
            TreeNode node = twm.node; 

            if(node.val>= twm.max){
                goodNodeCount++;
            }
            
            int curMax = Math.max(twm.max,node.val);
            
            if(node.right != null){
                stack.push(new TwM(node.right,curMax));
            }

            if(node.left != null){
                stack.push(new TwM(node.left,curMax));
            }
            
        }

        return goodNodeCount;
    }
}
