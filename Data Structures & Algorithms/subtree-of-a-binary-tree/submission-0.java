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

    interface TreeNodeAction {
        void apply(TreeNode node);
    }

    public void dfs(TreeNode root,TreeNodeAction func){
        Deque<TreeNode> stack = new ArrayDeque<>();stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            func.apply(node);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            } 
        }
    }

    public void appendToStr(TreeNode node, StringBuilder strbd){
        strbd.append(node.val);
        if(node.right == null){
            strbd.append("#");
        }
        if(node.left == null){
            strbd.append("#");
        }
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        StringBuilder rootStr = new StringBuilder(),subRootStr = new StringBuilder();
        dfs(root,node->appendToStr(node,rootStr));
        dfs(subRoot,node->appendToStr(node,subRootStr));

        if(rootStr.toString().contains(subRootStr.toString())){
            return true;
        }
        return false;
    }
}
