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
    int maxDiff;

    void findMaxUtil(TreeNode root, TreeNode child) {
        if (root == null || child == null) {
            return;
        }

        maxDiff = Math.max(maxDiff, Math.abs(root.val - child.val));

        findMaxUtil(root, child.left);
        findMaxUtil(root, child.right);
    }

    void findMaxDiff(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        // Find max differences of this root with all its children
        findMaxUtil(root, root.left);
        findMaxUtil(root, root.right);

        // Further move left and right
        findMaxDiff(root.left);
        findMaxDiff(root.right);
    }

    public int maxAncestorDiff(TreeNode root) {
        maxDiff = Integer.MIN_VALUE;

        findMaxDiff(root);

        return maxDiff;
    }
}
