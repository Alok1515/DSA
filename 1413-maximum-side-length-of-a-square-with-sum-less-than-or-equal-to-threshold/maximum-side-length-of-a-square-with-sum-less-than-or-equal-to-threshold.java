class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] prefix = new int[rows][cols];

        // Build prefix sum
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefix[i][j] = mat[i][j]
                        + (i > 0 ? prefix[i - 1][j] : 0)
                        + (j > 0 ? prefix[i][j - 1] : 0)
                        - (i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0);
            }
        }

        int best = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = best; k < Math.min(rows - i, cols - j); k++) {
                    //bottom right cell (r2, c2)
                    int r2 = i + k;
                    int c2 = j + k;

                    int sum = prefix[r2][c2];
                    if (i > 0) sum -= prefix[i - 1][c2];
                    if (j > 0) sum -= prefix[r2][j - 1];
                    if (i > 0 && j > 0) sum += prefix[i - 1][j - 1];

                    if (sum <= threshold) {
                        best = k + 1;
                    } else {
                        break;
                    }
                }
            }
        }

        return best;
    }
}