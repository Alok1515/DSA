class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();

        int countA = 0;
        int countB = 0;

        // Count total 'a'
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                countA++;
            }
        }

        // Case: delete all 'a'
        int count = countA;

        // Sweep through string
        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == 'a') {
                countA--; // move this 'a' from right to left
            } else {
                countB++; // this 'b' is now on left
            }

            count = Math.min(count, countA + countB);
        }

        return count;
    }
}
