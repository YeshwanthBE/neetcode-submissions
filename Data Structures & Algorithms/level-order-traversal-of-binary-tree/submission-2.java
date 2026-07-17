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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();queue.offer(root);
        
        while(!queue.isEmpty()){
            int k = queue.size();
            List<Integer> level= new ArrayList();
            for(int i=0 ; i<k ;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
           
        resultList.add(level);
        }
        return resultList;
    }
}
