class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        int result  = 0;
        int culprit = 0;

        while(j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if(map.get(nums[j]) == k+1) {
                culprit++;
            }

            if(culprit > 0) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i]) == k) { // this is the culprit
                    culprit--;
                }
                i++;
            }
            if(culprit == 0) {
                result = Math.max(result, j-i+1);
            }
            j++;
        }

        return result;
    }
}