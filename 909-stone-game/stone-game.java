class Solution {

    int n ;
    Integer[][] dp;

    private int solve(int i, int j, int[] piles) {

        // pick the last value
        if(i == j) return piles[i];

        if(dp[i][j] != null) return dp[i][j];

        int takeLeft = piles[i] - solve(i + 1, j, piles);

        int takeRight = piles[j] - solve(i, j - 1, piles);

        return dp[i][j] = Math.max(takeLeft, takeRight);
    }

    public boolean stoneGame(int[] piles) {
         
        n = piles.length;

        dp = new Integer[n][n];

        int result = solve(0, n-1, piles);

        return result > 0;
    }
}