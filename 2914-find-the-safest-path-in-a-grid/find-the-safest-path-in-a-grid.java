class Solution {

    int m, n;
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private boolean check(int[][] distNearestTheif, int sf) {

        if (distNearestTheif[0][0] < sf)
        return false;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {

            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];

            if(x == m-1 && y == n-1) return true;

            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) continue;

                if(distNearestTheif[nx][ny] < sf) {
                    continue;
                } else {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return false;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        
        m = grid.size();
        n = grid.get(0).size();

        // precalculation of distance to nearest theif
        int[][] distNearestTheif = new int[m][n];
        for (int[] row : distNearestTheif) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                // push the theif in queue
                if(grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;

        while(!q.isEmpty()) {

            int size = q.size();

            while(size-- > 0) {

                int[] curr = q.poll();

                int x = curr[0];
                int y = curr[1];

                distNearestTheif[x][y] = level;

                for(int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) continue;

                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
            level++;
        }

        int l = 0, r = 400, result = 0;

        while(l <= r) {

            int mid = l + (r-l)/2;

            if(check(distNearestTheif, mid)) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}