class Solution {
    public int swimInWater(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, grid[0][0]}); // row, col, time
        dist[0][0] = grid[0][0];

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while(!pq.isEmpty()) {

            int[] curr = pq.poll();

            int r = curr[0];
            int c = curr[1];
            int time = curr[2];

            if(r == m-1 && c == n-1) return time;

            if(time > dist[r][c]) continue;

            for(int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                    if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                    int newTime = Math.max(time, grid[nr][nc]);

                    if(newTime < dist[nr][nc]) {

                    dist[nr][nc] = newTime;

                    pq.offer(new int[]{nr, nc, newTime});
                }
            }

        }

        return dist[m-1][n-1];
    }
}