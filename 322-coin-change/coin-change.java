class Solution {

   
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int a = 0; a <= amount; a++) {
            if(a % coins[0] == 0) {
                dp[0][a] = a / coins[0];
            } else {
                dp[0][a] = Integer.MAX_VALUE;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int a = 0; a <= amount; a++) {

                int notTake = dp[i-1][a];
                int take = (int)1e9;

                if(coins[i] <= a) {
                    take = 1 + dp[i][a - coins[i]];
                }

                dp[i][a] = Math.min(take, notTake);
            }
        }

        int ans = dp[n-1][amount];

        return (ans >= (int)1e9) ? -1 : ans;
    }
}