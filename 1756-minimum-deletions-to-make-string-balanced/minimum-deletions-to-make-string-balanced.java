class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();

        int[] leftBcount = new int[n + 1];   // b's before index i
        int[] rightAcount = new int[n + 1];  // a's after index i

        // Prefix count of 'b'
        for (int i = 1; i <= n; i++) {
            leftBcount[i] = leftBcount[i - 1];
            if (s.charAt(i - 1) == 'b') {
                leftBcount[i]++;
            }
        }

        // Suffix count of 'a'
        for (int i = n - 1; i >= 0; i--) {
            rightAcount[i] = rightAcount[i + 1];
            if (s.charAt(i) == 'a') {
                rightAcount[i]++;
            }
        }

        // Find minimum deletions
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, leftBcount[i] + rightAcount[i]);
        }

        return ans;
    }
}
