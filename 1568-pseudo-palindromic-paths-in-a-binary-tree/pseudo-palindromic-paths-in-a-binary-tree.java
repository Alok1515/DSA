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

    int ans = 0;

    private void dfs(TreeNode root, int[] freq) {

        if(root == null) return;

        freq[root.val]++;

        if(root.left == null && root.right == null) {

            int oddCount = 0;

            for(int i = 1; i <= 9; i++) {
                if(freq[i] % 2 != 0) {
                    oddCount++;
                }
            }

            if(oddCount <= 1) {
                ans++;
            }
        }

        dfs(root.left, freq);
        dfs(root.right, freq);

        freq[root.val]--; // backtrack
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        
        dfs(root, new int[10]);
        return ans;
    }
}