class Solution {

    private int n;

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        n = piles.size();
        Integer[][] dp = new Integer[n+1][k+1];
        return solve(0, piles, k, dp);
    }

    private int solve(int i, List<List<Integer>> piles, int k, Integer[][] dp) {
        // Base Case
        if(i >= n) return 0;

        if(dp[i][k] != null) return dp[i][k];

        int take = solve(i+1, piles, k, dp);

        int notTake = 0;
        
        int sum = 0;

        for(int j = 0; j < Math.min(piles.get(i).size(), k); j++) {
            sum += piles.get(i).get(j);
            take = Math.max(take, sum + solve(i+1, piles, k-(j+1), dp));
        }

        return dp[i][k] = Math.max(take, notTake);
    }
}