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

    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        
        dfs(root);
        
        return count;
    }

    private void dfs(TreeNode root) {

        if(root == null) return;

        int sum = getSum(root);
        int nodes = getCount(root);

        if(sum / nodes == root.val) {
            count++;
        }

        dfs(root.left);
        dfs(root.right);
    }

    private int getSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return root.val + getSum(root.left) + getSum(root.right);
    }

    private int getCount(TreeNode root) {

        if(root == null) return 0;

        return 1 + getCount(root.left) + getCount(root.right);
    }
}