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

    private int count = 0;

    private void buildGraph(TreeNode root, TreeNode parent, Map<TreeNode, List<TreeNode>> graph, Set<TreeNode> st ) {

        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) st.add(root);

        graph.putIfAbsent(root, new ArrayList<>());


        if(parent != null) {
            graph.putIfAbsent(parent, new ArrayList<>());

            graph.get(root).add(parent);
            graph.get(parent).add(root);
        }

        buildGraph(root.left, root, graph, st);
        buildGraph(root.right, root, graph, st);

    }
    public int countPairs(TreeNode root, int distance) {
        
        // make graph
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Set<TreeNode> st = new HashSet<>();
        buildGraph(root, null, graph, st);

        // Bfs from every leaf node
        for(TreeNode node : st) {

            Queue<TreeNode> q = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();
            q.offer(node);
            visited.add(node);
            
            for(int level = 0; level <= distance; level++) {
                int size = q.size();

                while(size-- > 0) {

                    TreeNode curr = q.poll();
                    if(curr != node && st.contains(curr)) {
                        count++;
                    }

                    for(TreeNode ngbr : graph.get(curr)) {
                        if(!visited.contains(ngbr)) {
                            q.offer(ngbr);
                            visited.add(ngbr);
                        }
                    }
                }
            }
        }

        return count / 2;
    }
}