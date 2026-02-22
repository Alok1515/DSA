class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // sum 0 will be always present

        int currSum = 0;
        int remainingSum = 0;
        int result = 0;

        for(int num : nums) {
            currSum += num;
            remainingSum = currSum - goal;

            if(map.containsKey(remainingSum)) {
                result += map.get(remainingSum);
            }

            // add the the currsum we have seen so far
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return result;
    }
}