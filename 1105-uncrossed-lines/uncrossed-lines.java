class Solution {

    int m, n;
    Integer[][] dp;

    private int solve(int i, int j, int[] nums1, int[] nums2) {

        // Base case
        if(i >= m || j >= n) {
            return 0;
        }

        if(dp[i][j] != null) return dp[i][j];

        if(nums1[i] == nums2[j]) {
            return dp[i][j] = 1 + solve(i+1, j+1, nums1, nums2);
        }

        // otherwise skip one element
        int moveI = solve(i+1, j, nums1, nums2);
        int moveJ = solve(i, j+1, nums1, nums2);

        return dp[i][j] = Math.max(moveI, moveJ);
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;

        dp = new Integer[m][n];

        return solve(0, 0, nums1, nums2);
    }
}