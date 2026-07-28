class Solution {

    private int func(int[] prefSum, int L, int M) {
        int n = prefSum.length;
        int maxLeftSubSum = 0;
        int result = 0;

        for(int mEnd = L + M - 1; mEnd < n; mEnd++) {
            int lEnd = mEnd - M;
            int lastStartPrev = lEnd - L;

            int mBlockSum = prefSum[mEnd] - prefSum[lEnd];
            int lBlockSum = prefSum[lEnd] - (lastStartPrev < 0 ? 0 : prefSum[lastStartPrev]);

            maxLeftSubSum = Math.max(maxLeftSubSum, lBlockSum);

            result = Math.max(result, maxLeftSubSum + mBlockSum);
        }
        return result;
    }
    public int maxSumTwoNoOverlap(int[] nums, int L, int M) {
        
        int n = nums.length;

        int[] prefSum = new int[n];
        prefSum[0] = nums[0];

        for(int i = 1; i < n; i++) {
            prefSum[i] = prefSum[i-1] + nums[i];
        }

        return Math.max(func(prefSum, L, M), func(prefSum, M, L));
    }
}