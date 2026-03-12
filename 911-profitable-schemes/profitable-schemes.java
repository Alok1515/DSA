class Solution {
    
    private int N;
    private final int M = (int)1e9 + 7;

    private int solve(int i, int p, int people, int minProfit, int[] group, int[] profit, Integer[][][] dp) {
        // Base Case 
        if(people > N) {
            return 0;
        }

        // Base Case
        if(i == group.length) {
            if(p >= minProfit) return 1;

            return 0;
        }

         if(dp[i][p][people] != null) return dp[i][p][people];

        int notTake = solve(i+1, p, people, minProfit, group, profit, dp) % M;
        int take    = solve(i+1, Math.min(p + profit[i], minProfit), people + group[i], minProfit, group,  profit, dp) % M;

        return dp[i][p][people] = (take + notTake) % M;
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        N = n;

        Integer[][][] dp = new Integer[group.length][minProfit + 1][n + 1];

        return solve(0, 0, 0, minProfit, group, profit, dp);
    }
}