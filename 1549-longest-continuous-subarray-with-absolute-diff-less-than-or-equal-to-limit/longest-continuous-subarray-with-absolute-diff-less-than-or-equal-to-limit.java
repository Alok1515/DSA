class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        int n = nums.length;

        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        int left = 0;
        int maxLen = 0;

        for(int right = 0; right < n; right++) {

            while(!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            while(!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }

            minDeque.offerLast(nums[right]);
            maxDeque.offerLast(nums[right]);

            while(maxDeque.peekFirst() - minDeque.peekFirst() > limit) {

                if(nums[left] == maxDeque.peekFirst()) {
                    maxDeque.pollFirst();
                }
                if(nums[left] == minDeque.peekFirst()) {
                    minDeque.pollFirst();
                }

                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}