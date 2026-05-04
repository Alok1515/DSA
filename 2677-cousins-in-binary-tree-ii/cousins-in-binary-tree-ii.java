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
    public TreeNode replaceValueInTree(TreeNode root) {

        if(root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> levelSum = new ArrayList<>();

        q.offer(root);

        // step 1 (find each level sum and store it into some array)
        while(!q.isEmpty()) {
            int size = q.size();
            int currLevelSum = 0;

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                currLevelSum += curr.val;

                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            levelSum.add(currLevelSum);
        }

        // step 2 -> update each ndoe sum with its cousin value
        q.offer(root); // reuse the q
        root.val = 0; // root does not have cousin
        int i = 1; // index to access sibling

        while(!q.isEmpty()) {
            int size = q.size(); // curr level size

            while(size-- > 0) {
                TreeNode curr = q.poll();

                //sibling sum
                int siblingSum = curr.left != null ? curr.left.val : 0;
                siblingSum += curr.right != null ? curr.right.val : 0;

                if(curr.left != null) {
                    curr.left.val = levelSum.get(i) - siblingSum;
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    curr.right.val = levelSum.get(i) - siblingSum;
                    q.offer(curr.right);
                }
            }
            i++;
        }

        return root;
    }
}