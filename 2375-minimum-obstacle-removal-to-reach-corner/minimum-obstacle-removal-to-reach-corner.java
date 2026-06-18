class Solution {
    public int minimumObstacles(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0}); // row , col, cost

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while(!pq.isEmpty()) {

            int[] curr = pq.poll();

            int r = curr[0];
            int c = curr[1];
            int cost = curr[2];

            if (cost > dist[r][c]) continue;

            if(r == m-1 && c == n-1) return cost;

            for(int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                int newCost = cost + grid[nr][nc];

                if(newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    pq.offer(new int[]{nr, nc, newCost});
                }
            }
        }

        return dist[m-1][n-1];
    }
}