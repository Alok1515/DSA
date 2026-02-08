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
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    private int checkHeight(TreeNode node) {
        if(node == null) return 0;

        int lh = checkHeight(node.left);
        if(lh == -1) return -1; // left subtree not balanced

        int rh = checkHeight(node.right);
        if(rh == -1) return -1; // right subtree not balanced

        if(Math.abs(lh - rh) > 1) return -1; // current node not balanced

        return Math.max(lh, rh) + 1;
    }
}