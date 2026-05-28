class Solution {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m+1][n+1];


        for(int i = m-1; i >= 0; i--) {

            for(int j = n-1; j >= 0; j--) {

                if(nums1[i] == nums2[j]) {
                   dp[i][j] = 1 + dp[i+1][j+1];

                } else {

                    int moveI = dp[i+1][j];
                    int moveJ = dp[i][j+1];

                    dp[i][j] = Math.max(moveI, moveJ);
                }
            }
        }

        return dp[0][0];
    }
}