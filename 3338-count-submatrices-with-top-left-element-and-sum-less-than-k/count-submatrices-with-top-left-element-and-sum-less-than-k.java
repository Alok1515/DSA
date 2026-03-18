class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(i-1 >= 0)
                    grid[i][j] += grid[i-1][j];
                if(j-1 >= 0)
                    grid[i][j] += grid[i][j-1];
                if(i-1 >=0 && j-1 >= 0)
                    grid[i][j] -= grid[i-1][j-1]; // remove the commen value added two times

                if(grid[i][j] <= k) count++;
                else break;
            }
        }

        return count;
    }
}