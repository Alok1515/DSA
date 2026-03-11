class Solution {

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;

        Integer[][] dp = new Integer[n][n+1];

        return solve(satisfaction, 0, 1, dp);
    }

    private int solve(int[] satisfaction, int i, int time, Integer[][] dp) {
        // Base Case 
        if(i == satisfaction.length) {
            return 0;
        }

        // check before calling
        if(dp[i][time] != null) {
            return dp[i][time];
        }

        int take = satisfaction[i] * time + solve(satisfaction, i + 1, time + 1, dp);
        int notTake = solve(satisfaction, i + 1, time, dp);

        return dp[i][time] =  Math.max(take, notTake);
    }
}