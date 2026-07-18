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

    class rangedTree{
        TreeNode node;
        int min,max;

    }

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev=null,cur=root;
        while(cur != null || !stack.isEmpty()){
            
            while(cur!= null){
                stack.push(cur);
                cur=cur.left;
            }
            
            cur = stack.pop();
            
            if(prev!=null && cur.val<=prev.val){
                return false;
            }
            prev=cur;
            cur=cur.right;
        }

        return true;
    }
}
