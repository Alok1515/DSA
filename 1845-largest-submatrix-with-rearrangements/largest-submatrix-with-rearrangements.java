class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Pair<Integer, Integer>> prevHeights = new ArrayList<>();
        int result = 0;

        for (int row = 0; row < m; row++) {
            List<Pair<Integer, Integer>> heights = new ArrayList<>();
            boolean[] seen = new boolean[n];

            for (Pair<Integer, Integer> entry : prevHeights) {
                int height = entry.getKey();
                int col = entry.getValue();
                if (matrix[row][col] == 1) {
                    heights.add(new Pair<>(height + 1, col));
                    seen[col] = true;
                }
            }

            for (int col = 0; col < n; col++) {
                if (!seen[col] && matrix[row][col] == 1) {
                    heights.add(new Pair<>(1, col));
                }
            }

            for (int i = 0; i < heights.size(); i++) {
                int base = i + 1;
                int height = heights.get(i).getKey();
                result = Math.max(result, base * height);
            }

            prevHeights = heights;
        }

        return result;
    }
    
}