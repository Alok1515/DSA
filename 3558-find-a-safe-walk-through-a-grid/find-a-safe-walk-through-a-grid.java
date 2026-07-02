class Solution {
    int m, n;

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        m = grid.size();
        n = grid.get(0).size();

        int startHealth = health - grid.get(0).get(0);

        if(startHealth <= 0) return false;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, startHealth});

        // maximum remaining health seen at (i, j);
        int[][] best = new int[m][n];

        for(int[] row : best) {
            Arrays.fill(row, -1);
        }

        best[0][0] = startHealth;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!q.isEmpty()) {

            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];
            int currHealth = curr[2];

            if(x == m-1 && y == n-1) return true;

            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // outofbound case
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                int newHealth = currHealth - grid.get(nx).get(ny);

                if(newHealth <= 0) continue;

                if(newHealth > best[nx][ny]) {
                    best[nx][ny] = newHealth;
                    q.offer(new int[]{nx, ny, newHealth});
                }
            }
        }
        return false;
    }
}