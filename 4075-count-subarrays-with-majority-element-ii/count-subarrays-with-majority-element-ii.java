class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        //Instead of map you can use an array of size 2*n+1 as well because we can have cumulative sum from -n to +n
        Map<Integer, Integer> mp = new HashMap<>();   // mp[cumSum] = frequency of how many times cumSum has occurred

        int currSum = 0;

        mp.put(0, 1); //we have seen cumSum = 0 in the beginning once
        long validLeftPoints = 0;
        long result = 0;
        for (int x : nums) {
            if (x == target) {
                validLeftPoints += mp.getOrDefault(currSum, 0);
                currSum++;
            } else {
                currSum--;
                validLeftPoints -= mp.getOrDefault(currSum, 0);
            }
            mp.merge(currSum, 1, Integer::sum);
            result += validLeftPoints;
        }
        return result;
    }
}