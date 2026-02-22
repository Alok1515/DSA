class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        int i = 0, j = 0;
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while (j < n) {

            // Expand window
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // Shrink window if frequency of current element exceeds k
            while (map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            result = Math.max(result, j - i + 1);
            j++;
        }

        return result;
    }
}