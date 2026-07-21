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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder result = new StringBuilder();
        Deque<TreeNode> stack = new ArrayDeque<>();stack.push(root);TreeNode dummy = new TreeNode(-1);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node == dummy){
                result.append("#,");continue;
            }
            result.append(node.val+",");
            if(node.right != null) {
                stack.push(node.right);
            }else{
                stack.push(dummy);
            }
            if(node.left != null){
                stack.push(node.left);
            }else{
                stack.push(dummy);
            } 
        }
        return result.toString();
    }
    
    private int index = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.length()==0){
            return null;
        }

        String[] nodes = data.split(",");
        return build(nodes);
    }

    public TreeNode build(String[] nodes){
        if(nodes[index].equals("#")){
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[index++]));
        node.left = build(nodes);
        node.right = build(nodes);

        return node;
    }
}
