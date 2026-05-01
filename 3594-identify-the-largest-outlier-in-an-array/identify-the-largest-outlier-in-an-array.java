class Solution {
    public int getLargestOutlier(int[] nums) {
        int n = nums.length;
        int total = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums) {
            total += num;
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxOutlier = Integer.MIN_VALUE;

        // check every element as a outlier
        for(int x : nums) {
            int remaining = total - x;

            if(remaining % 2 != 0) continue;

            int y = remaining / 2;

            // temporarly reduce freq of x
            freq.put(x, freq.get(x) - 1);

            if(freq.getOrDefault(y, 0) > 0) {
                maxOutlier = Math.max(maxOutlier, x);
            }
            freq.put(x, freq.get(x) + 1);
        }

        return maxOutlier;
    }
}