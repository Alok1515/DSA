class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];
        int compId = 0;
        component[0] = compId;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                compId++;
            }
            component[i] = compId;
        }

        boolean[] result = new boolean[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = (component[queries[j][0]] == component[queries[j][1]]);
        }
        return result;
    }
}