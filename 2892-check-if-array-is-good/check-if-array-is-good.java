class Solution {
    public boolean isGood(int[] nums) {

        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        Arrays.sort(nums);

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int i = 1; i <= n-2; i++) {
            if(map.getOrDefault(i, 0) != 1) {
                return false;
            }
        }

        if(map.getOrDefault(n-1, 0) != 2) {
            return false;
        }

        return true;
    }
}