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

    class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public int findBottomLeftValue(TreeNode root) {

        if(root == null) return 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0)); // node, level

        int lastLevel = 0;
        int ans = root.val;

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {

                Pair curr = q.poll();
                TreeNode node = curr.node;
                int level = curr.level;

                if(node.left != null) {
                q.offer(new Pair(node.left, level + 1));
                }

                if(node.right != null) {
                q.offer(new Pair(node.right, level + 1));
                }

                if(level > lastLevel) {
                lastLevel = level;
                ans = node.val;
                }
            }
        }

        return ans;
    }
}