class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;

        // Step 1: Find minimum difference
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        // Step 2: Collect all pairs with minDiff
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}
