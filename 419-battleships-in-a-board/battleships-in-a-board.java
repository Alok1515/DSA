class Solution {

    public int countBattleships(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        int count = 0;

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                if(board[i][j] == 'X' && !visited[i][j]) {

                    bfs(i, j, board, visited);

                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int row, int col, char[][] board, boolean[][] visited) {

        int m = board.length;
        int n = board[0].length;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{row, col});

        visited[row][col] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!queue.isEmpty()) {

            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];

            for(int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nr < m &&
                   nc >= 0 && nc < n &&
                   board[nr][nc] == 'X' &&
                   !visited[nr][nc]) {

                    visited[nr][nc] = true;

                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}