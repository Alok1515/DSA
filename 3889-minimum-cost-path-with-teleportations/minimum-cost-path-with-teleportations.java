import java.util.*;

class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                points.add(new int[]{i, j});
            }
        }

        // Sort by grid value
        points.sort((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);

        int[][] costs = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }

        for (int t = 0; t <= k; t++) {
            int minCost = Integer.MAX_VALUE;

            for (int i = 0, j = 0; i < points.size(); i++) {
                int r = points.get(i)[0];
                int c = points.get(i)[1];

                minCost = Math.min(minCost, costs[r][c]);

                if (i + 1 < points.size() &&
                        grid[r][c] == grid[points.get(i + 1)[0]][points.get(i + 1)[1]]) {
                    continue;
                }

                for (int x = j; x <= i; x++) {
                    int rr = points.get(x)[0];
                    int cc = points.get(x)[1];
                    costs[rr][cc] = minCost;
                }
                j = i + 1;
            }

            // DP relaxation from bottom-right
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i == m - 1 && j == n - 1) {
                        costs[i][j] = 0;
                        continue;
                    }
                    if (i + 1 < m) {
                        costs[i][j] = Math.min(
                            costs[i][j],
                            costs[i + 1][j] + grid[i + 1][j]
                        );
                    }
                    if (j + 1 < n) {
                        costs[i][j] = Math.min(
                            costs[i][j],
                            costs[i][j + 1] + grid[i][j + 1]
                        );
                    }
                }
            }
        }

        return costs[0][0];
    }
}
