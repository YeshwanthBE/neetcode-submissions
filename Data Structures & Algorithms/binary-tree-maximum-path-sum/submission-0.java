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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSums(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftSum = maxPathSums(root.left);
        int rightSum = maxPathSums(root.right);

leftSum = Math.max(0, leftSum);
rightSum = Math.max(0, rightSum);
        int currentSum = leftSum+rightSum + root.val;

        maxSum = Math.max(maxSum, currentSum);

        return Math.max(leftSum,rightSum)+root.val;

    }

    public int maxPathSum(TreeNode root) {
        maxPathSums(root);
        return maxSum;

    }
}
