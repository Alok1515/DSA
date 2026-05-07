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
    private int moves = 0;

    public int distributeCoins(TreeNode root) {
        solve(root);
        return moves;
    }
    private int solve(TreeNode curr) {
        if(curr == null) return 0;

        int l = solve(curr.left);
        int r = solve(curr.right);

        moves += Math.abs(l) + Math.abs(r);

        return (l + r + curr.val) - 1;
    }
}