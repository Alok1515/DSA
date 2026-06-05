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
    public boolean isEvenOddTree(TreeNode root) {
        
        if(root == null) return true;

        if(root.val % 2 == 0) return false;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()) {

            int size = q.size();

            List<Integer> list = new ArrayList<>();
            int level = q.peek().level;

            for(int i = 0; i < size; i++) {

                Pair curr = q.poll();
                TreeNode node = curr.node;
                list.add(node.val);

                if(node.left != null) {
                    q.offer(new Pair(node.left, level + 1));
                }
                if(node.right != null) {
                    q.offer(new Pair(node.right, level + 1));
                }
            }

            if(level % 2 != 0) {

                for(int num : list) {
                    if(num % 2 != 0) return false; // must be even
                }

                for(int i = 0; i < list.size() - 1; i++) {
                    if(list.get(i) <= list.get(i + 1))
                        return false; // strictly decreasing
                }
            }
            else {

                for(int num : list) {
                    if(num % 2 == 0) return false; // must be odd
                }

                for(int i = 0; i < list.size() - 1; i++) {
                    if(list.get(i) >= list.get(i + 1))
                        return false; // strictly increasing
                }
            }
        }

        return true;
    }
}