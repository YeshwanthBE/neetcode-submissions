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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        int in = 0;
        for(int pre = 1;pre<preorder.length;pre++){
            TreeNode node = new TreeNode(preorder[pre]);
            if(stack.peek().val!=inorder[in]){
                stack.peek().left = node;
            }
            else{
                TreeNode parent = null;
                while (!stack.isEmpty() && stack.peek().val == inorder[in]) {
                    parent = stack.pop();
                    in++;
                }
                parent.right=node;
            }
            stack.push(node);
        }
        return root;
    }
}
