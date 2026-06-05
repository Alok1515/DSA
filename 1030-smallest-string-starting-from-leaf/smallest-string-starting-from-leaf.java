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

    String result = "";

    private void dfs(TreeNode node, String curr) {

        if(node == null) return;

        curr = (char) (node.val + 'a') + curr;

        if(node.left == null && node.right == null) {
            if(result == "" || result.compareTo(curr) > 0) {
                result = curr;
            }

            return;
        }

        dfs(node.left, curr);
        dfs(node.right, curr);
    }
    public String smallestFromLeaf(TreeNode root) {
        
        dfs(root, "");
        return result;
    }
}