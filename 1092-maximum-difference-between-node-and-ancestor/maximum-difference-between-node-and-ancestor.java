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
    public int maxAncestorDiff(TreeNode root) {
        int minV = root.val;
        int maxV = root.val;

        return findMaxDiff(root, root.val, root.val);
    }
    private int findMaxDiff(TreeNode root, int minV, int maxV) {
        if(root == null) return Math.abs(minV - maxV);

        minV = Math.min(minV, root.val);
        maxV = Math.max(maxV, root.val);

        int l = findMaxDiff(root.left, minV, maxV);
        int r = findMaxDiff(root.right, minV, maxV);

        return Math.max(l, r);
    }
}