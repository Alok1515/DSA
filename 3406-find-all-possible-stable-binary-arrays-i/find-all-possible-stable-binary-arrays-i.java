class Solution {

    private final int M = (int)1e9 + 7;
    int[][][] dp = new int[201][201][2];

    private int solve(int onesLeft, int zerosLeft, boolean lastWasOne, int limit) {
        // Base case 
        if(onesLeft == 0 && zerosLeft == 0) {
            return 1; // got one array
        }

        int last = lastWasOne ? 1 : 0;

        if(dp[onesLeft][zerosLeft][last] != -1) {
            return dp[onesLeft][zerosLeft][last];
        }

        long result = 0;

        if(lastWasOne == true) { // explore 1's
            for(int len = 1; len <= Math.min(zerosLeft, limit); len++) {
                result = (result + solve(onesLeft, zerosLeft - len, false, limit)) % M;
            }
        } else { // explore 0's
            for(int len = 1; len <= Math.min(onesLeft, limit); len++) {
                result = (result + solve(onesLeft - len, zerosLeft, true, limit)) % M;
            }
        }

        return dp[onesLeft][zerosLeft][last] = (int)result;
    }
    public int numberOfStableArrays(int zero, int one, int limit) {

        for(int i = 0; i <= 200; i++) {
            for(int j = 0; j <= 200; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        int startWithZero = solve(one, zero, true, limit);
        int startWithOne  = solve(one, zero, false, limit);

        return (startWithZero + startWithOne) % M;
    }
}