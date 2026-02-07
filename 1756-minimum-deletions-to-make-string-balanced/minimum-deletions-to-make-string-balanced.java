class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();

        int[] rightAcount = new int[n + 1];  // a's after index i


        // Suffix count of 'a'
        for (int i = n - 1; i >= 0; i--) {
            rightAcount[i] = rightAcount[i + 1];
            if (s.charAt(i) == 'a') {
                rightAcount[i]++;
            }
        }

        // Find minimum deletions
        int ans = Integer.MAX_VALUE;

        int countB = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, countB + rightAcount[i]);
            if(s.charAt(i) == 'b') {
                countB++;
            }
        }
         // Split after last character
        ans = Math.min(ans, countB);

        return ans;
    }
}
