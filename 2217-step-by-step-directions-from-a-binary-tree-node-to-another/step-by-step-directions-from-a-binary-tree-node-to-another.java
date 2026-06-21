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

    private TreeNode lowestCommonAnsestor(TreeNode root, int src, int dest) {

        if(root == null) return root;

        if(root.val == src || root.val == dest) return root;

        TreeNode left = lowestCommonAnsestor(root.left, src, dest);
        TreeNode right = lowestCommonAnsestor(root.right, src, dest);

        if(left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    private boolean findPath(TreeNode LCA, int target, StringBuilder path) {

        if(LCA == null) return false;

        if(LCA.val == target) return true;

        // explore left
        path.append('L');
        if(findPath(LCA.left, target, path) == true) return true;

        // backtrack
        path.deleteCharAt(path.length() - 1);

        // explore right
        path.append('R');
        if(findPath(LCA.right, target, path) == true) return true;

        // backtrack
        path.deleteCharAt(path.length() - 1);

        return false;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {

        TreeNode LCA = lowestCommonAnsestor(root, startValue, destValue);
        
        StringBuilder lcaToSrc = new StringBuilder();
        StringBuilder lcaToDest = new StringBuilder();

        findPath(LCA, startValue, lcaToSrc);
        findPath(LCA, destValue, lcaToDest);

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < lcaToSrc.length(); i++) {
            result.append('U');
        }

        result.append(lcaToDest);

        return result.toString();
    }
}