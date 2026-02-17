class Solution {
    public int subarraySum(int[] nums, int k) {
        
        // HashMap to store the prefixSum and freq 
        Map<Integer, Integer> map =  new HashMap<>();

        int prefixSum = 0;
        int result = 0;

        // sum 0 occures once in any array
        map.put(0, 1);

        for(int num : nums) {

            prefixSum += num;

            //chaeck if (prefixSum - k) present in map
            if(map.containsKey(prefixSum - k)) {
                result += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return result;
    }
}