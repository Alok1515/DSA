class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int startRow = x;
        int endRow = x + k - 1;

        int startCol = y;
        int endCol = y + k - 1;

        while (startRow < endRow) { //You can use while loop as well which is cleaner that for loop above in C++ code
            for (int j = startCol; j <= endCol; j++) {
                int temp = grid[startRow][j];
                grid[startRow][j] = grid[endRow][j];
                grid[endRow][j] = temp;
            }
            startRow++;
            endRow--;
        }

        return grid;
    }
}