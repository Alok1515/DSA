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
    private void convert(TreeNode curr, int parent, Map<Integer, List<Integer>> adj) {
        if(curr == null) {
            return;
        }

        if(parent != -1) {
            adj.computeIfAbsent(curr.val, k -> new ArrayList<>()).add(parent);
        }
        if(curr.left != null) {
            adj.computeIfAbsent(curr.val, k -> new ArrayList<>()).add(curr.left.val);
        }
        if(curr.right != null) {
            adj.computeIfAbsent(curr.val, k -> new ArrayList<>()).add(curr.right.val);
        }

        convert(curr.left, curr.val, adj);
        convert(curr.right, curr.val, adj);
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        convert(root, -1, adj);

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        visited.add(start);
        q.offer(start);

        int time = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                int curr = q.poll();

                for(int ngbr : adj.getOrDefault(curr, Collections.emptyList())) {
                    if(!visited.contains(ngbr)) {
                        q.offer(ngbr);
                        visited.add(ngbr);
                    }
                }
            }
            time++;
        }
        return time - 1;
    }
}