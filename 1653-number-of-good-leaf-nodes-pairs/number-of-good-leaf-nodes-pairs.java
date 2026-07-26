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
public class Solution {

    public List<Integer> solve(TreeNode root, int distance, int[] goodLeafNodes) {
        if (root == null) {
            List<Integer> emptyList = new ArrayList<>();
            emptyList.add(0);
            return emptyList;
        }

        if (root.left == null && root.right == null) {
            List<Integer> leafList = new ArrayList<>();
            leafList.add(1);
            return leafList;
        }

        List<Integer> leftDistances = solve(root.left, distance, goodLeafNodes);
        List<Integer> rightDistances = solve(root.right, distance, goodLeafNodes);

        for (int l : leftDistances) {
            for (int r : rightDistances) {
                if (l != 0 && r != 0 && l + r <= distance) {
                    goodLeafNodes[0]++;
                }
            }
        }

        List<Integer> currentDistances = new ArrayList<>();
        for (int ld : leftDistances) {
            if (ld != 0 && ld + 1 <= distance) {
                currentDistances.add(ld + 1);
            }
        }

        for (int rd : rightDistances) {
            if (rd != 0 && rd + 1 <= distance) {
                currentDistances.add(rd + 1);
            }
        }

        return currentDistances;
    }

    public int countPairs(TreeNode root, int distance) {
        int[] goodLeafNodes = new int[1];
        solve(root, distance, goodLeafNodes);
        return goodLeafNodes[0];
    }
}