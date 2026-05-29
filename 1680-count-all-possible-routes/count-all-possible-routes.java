class Solution {
    
    int n;
    private final int MOD = (int)1e9 + 7;
    Integer[][] dp;

    private int solve(int currIndex, int dest, int fuel, int[] locations) {

        // Base case
        if(fuel < 0) return 0;

        if(dp[currIndex][fuel] != null) return dp[currIndex][fuel];

        int ans = 0;

        if(currIndex == dest) {
            ans = 1;
        }

        // try every other index 
        for(int i = 0; i < locations.length; i++) {

            if(currIndex == i) continue;

            ans = (ans + solve(i, dest, fuel - Math.abs(locations[currIndex] - locations[i]), locations)) % MOD;
        }

        return dp[currIndex][fuel] = ans % MOD;

    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {

        n = locations.length;

        dp = new Integer[n+1][fuel+1];
        
        return solve(start, finish, fuel, locations);
    }
}