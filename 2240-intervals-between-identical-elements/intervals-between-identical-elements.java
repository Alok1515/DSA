class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] result = new long[n];

        Map<Integer, Long> indexSum = new HashMap<>(); // summation of index
        Map<Integer, Long> indexCount = new HashMap<>(); // frequency of index

        // left to right
        for(int i = 0; i < n; i++) {
            long freq = indexCount.getOrDefault(arr[i], 0L);
            long sum  = indexSum.getOrDefault(arr[i], 0L);

            result[i] += freq * i - sum;

            indexCount.put(arr[i], freq + 1);
            indexSum.put(arr[i], sum + i);
        }

        // clear the maps
        indexSum.clear();
        indexCount.clear();

        // right to left
        for(int i = n - 1; i >= 0; i--) {
            long freq = indexCount.getOrDefault(arr[i], 0L);
            long sum = indexSum.getOrDefault(arr[i], 0L);

            result[i] += sum - freq * i;

            indexCount.put(arr[i], freq + 1);
            indexSum.put(arr[i], sum + i);
        }

        return result;
    }
}