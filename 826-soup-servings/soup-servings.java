class Solution {

    private final int[][] serves = {
        {4, 0},
        {3, 1},
        {2, 2},
        {1, 3}
    };

    private Double[][] dp;

    private double solve(int a, int b) {

        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        if (dp[a][b] != null) return dp[a][b];

        double ans = 0.0;

        for (int[] s : serves) {
            ans += solve(a - s[0], b - s[1]);
        }

        return dp[a][b] = ans * 0.25;
    }

    public double soupServings(int n) {

        if (n >= 4800) return 1.0;

        n = (n + 24) / 25;

        dp = new Double[n + 1][n + 1];

        return solve(n, n);
    }
}