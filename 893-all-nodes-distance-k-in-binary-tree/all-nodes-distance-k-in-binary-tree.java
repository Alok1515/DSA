/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private void buildParent(TreeNode root, TreeNode par, Map<TreeNode, TreeNode> map) {

        if(root == null) return;

        map.put(root, par);

        buildParent(root.left, root, map);
        buildParent(root.right, root, map);

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<TreeNode, TreeNode> map = new HashMap<>();
        buildParent(root, null, map);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int distance = 0;

        while(!q.isEmpty()) {

            int size = q.size();

            if(distance == k) {
                List<Integer> result = new ArrayList<>();

                while(!q.isEmpty()) {
                    result.add(q.poll().val);
                }

                return result;
            }

            for(int i = 0; i < size; i++) {
                
                TreeNode node = q.poll();
                
                if(node.left != null && !visited.contains(node.left)) {
                    q.offer(node.left);
                    visited.add(node.left);
                }
                if(node.right != null && !visited.contains(node.right)) {
                    q.offer(node.right);
                    visited.add(node.right);
                }

                TreeNode parent = map.get(node);

                if(parent != null && !visited.contains(parent)) {
                    q.offer(parent);
                    visited.add(parent);
                }
            }
            distance++;
        }

        return new ArrayList<>();
    }
}