class Solution {

    public int maximalNetworkRank(int n, int[][] roads) {

        int[] degree = new int[n];

        boolean[][] connected = new boolean[n][n];

        // build graph info
        for (int[] road : roads) {

            int u = road[0];
            int v = road[1];

            degree[u]++;
            degree[v]++;

            connected[u][v] = true;
            connected[v][u] = true;
        }

        int maximal = 0;

        // check every pair
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int rank = degree[i] + degree[j];

                // if directly connected, subtract 1
                if (connected[i][j]) {
                    rank--;
                }

                maximal = Math.max(maximal, rank);
            }
        }

        return maximal;
    }
}