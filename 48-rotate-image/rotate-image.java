class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        
        //find transpose
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //flip horizontally - For clock wise rotation
        for(int i = 0; i < N; i++) {
            int left = 0, right = N - 1;
            while(left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}