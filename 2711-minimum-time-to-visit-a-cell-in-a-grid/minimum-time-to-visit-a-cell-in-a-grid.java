class Solution {
    public int minimumTime(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // base case
        if(grid[1][0] > 1 && grid[0][1] > 1) return -1;

        boolean[][] visited = new boolean[m][n];
        int[][] dist = new int[m][n];

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, 0}); // row, col, time;
        dist[0][0] = 0;

        while(!pq.isEmpty()) {

            int[] curr = pq.poll();

            int r = curr[0];
            int c = curr[1];
            int time = curr[2];

            if(r == m-1 && c == n-1) return time;

            if(time > dist[r][c]) continue;

            if(visited[r][c] == true) continue;

            visited[r][c] = true;

            for(int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                if(grid[nr][nc] <= time) {
                    pq.offer(new int[]{nr, nc, time + 1});
                    dist[nr][nc] = time + 1;
                } else if((grid[nr][nc] - time) % 2 == 0) {
                    pq.offer(new int[]{nr, nc, grid[nr][nc] + 1});
                    dist[nr][nc] = grid[nr][nc] + 1;
                } else {
                    pq.offer(new int[]{nr, nc, grid[nr][nc]});
                    dist[nr][nc] = grid[nr][nc];
                }
            }
        }
        return dist[m-1][n-1];
    }
}