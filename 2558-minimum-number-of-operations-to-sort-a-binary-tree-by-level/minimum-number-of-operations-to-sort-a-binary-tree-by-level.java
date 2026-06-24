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

    private int minOper(List<Integer> temp) {

        int swaps = 0;

        List<Integer> sorted = new ArrayList<>(temp);
        Collections.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < temp.size(); i++) {
            map.put(temp.get(i), i);
        }

        for(int i = 0; i < temp.size(); i++) {
            if(temp.get(i).equals(sorted.get(i))) continue;

            int currIdx = map.get(sorted.get(i));
            map.put(temp.get(i), currIdx);
            map.put(temp.get(currIdx), i);
            Collections.swap(temp, currIdx, i);
            swaps++;
        }

        return swaps;
    }
    public int minimumOperations(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int result = 0;

        while(!q.isEmpty()) {

            int size = q.size();

            List<Integer> temp = new ArrayList<>();

            while(size-- > 0) {

                TreeNode curr = q.poll();
                temp.add(curr.val);

                if(curr.left != null) {
                    q.offer(curr.left);
                }

                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }

            result += minOper(temp);
        }

        return result;
    }
}