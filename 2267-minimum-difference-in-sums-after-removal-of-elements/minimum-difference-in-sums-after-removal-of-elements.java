class Solution {
    public long minimumDifference(int[] nums) {
        int N = nums.length;
        int n = N / 3;

        long[] leftMinSum = new long[N];
        long[] rightMaxSum = new long[N];

        // MaxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long leftSum = 0;

        for(int i = 0; i < 2*n; i++) {
            maxHeap.offer(nums[i]);
            leftSum += nums[i];

            if(maxHeap.size() > n) {
                leftSum -= maxHeap.poll();
            }
            leftMinSum[i] = leftSum;
        }

        // minHeap 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rightSum = 0;

        for(int i = N - 1; i >= n; i--) {
            minHeap.offer(nums[i]);
            rightSum += nums[i];

            if(minHeap.size() > n) {
                rightSum -= minHeap.poll();
            }
            rightMaxSum[i] = rightSum;
        }

        long result = Long.MAX_VALUE;
        for(int i = n-1; i <= 2*n - 1; i++) {
            result = Math.min(result, leftMinSum[i] - rightMaxSum[i+1]);
        }

        return result;
    }
}