class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindow(nums, k) - slidingWindow(nums, k-1);
    }

    private int slidingWindow(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        int count = 0;

        while(j < n) {

            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // shrink the window 
            while(map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1); // reduce the freq
                if(map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            count += (j-i+1); // get all the subarray till j
            j++;
        }

        return count;
    }
}