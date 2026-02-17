class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Row-wise prefix sum
        for (int r = 0; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                matrix[r][c] += matrix[r][c - 1];
            }
        }

        int result = 0;

        // Step 2: Fix startCol
        for (int startCol = 0; startCol < cols; startCol++) {

            // Step 3: Fix endCol
            for (int endCol = startCol; endCol < cols; endCol++) {

                // HashMap for prefix sums
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);

                int sum = 0;

                // Step 4: Traverse rows and treat as 1D subarray sum
                for (int row = 0; row < rows; row++) {

                    // Sum of elements in row between startCol and endCol
                    int rowSum = matrix[row][endCol]
                            - (startCol > 0 ? matrix[row][startCol - 1] : 0);

                    sum += rowSum;

                    // Count subarrays with sum = target
                    if (map.containsKey(sum - target)) {
                        result += map.get(sum - target);
                    }

                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return result;
    }
}
