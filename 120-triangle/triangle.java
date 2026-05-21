class Solution {

    int n;
    Integer[][] dp;

    private int solve(int i, int j, List<List<Integer>> triangle) {

        // base case
        if(i == n-1) {
            return triangle.get(i).get(j);
        }

        if(i >= n || j >= n) return Integer.MAX_VALUE;

        if(dp[i][j] != null) return dp[i][j];

        int down = solve(i + 1, j, triangle);
        int diagonal = solve(i + 1, j + 1, triangle);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {

        n = triangle.size();
        dp = new Integer[n][n];
        return solve(0, 0, triangle);
    }
}