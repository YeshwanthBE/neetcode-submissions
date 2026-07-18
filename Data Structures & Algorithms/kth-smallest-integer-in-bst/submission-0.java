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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        TreeNode cur =root,prev=null;

        while(k-- > 0){
            while(cur != null){
                nodeStack.push(cur);
                cur=cur.left;
            }
            prev = nodeStack.pop();
            cur=prev.right;
        }

        return prev.val;
    }
}
