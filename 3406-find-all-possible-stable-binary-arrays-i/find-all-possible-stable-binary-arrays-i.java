class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int M = 1_000_000_007;
        int[][][] t = new int[one + 1][zero + 1][2];

        // Base case: solve(0,0,lastWasOne) = 1
        t[0][0][0] = 1;
        t[0][0][1] = 1;

        for (int onesLeft = 0; onesLeft <= one; onesLeft++) {
            for (int zerosLeft = 0; zerosLeft <= zero; zerosLeft++) {
                if (onesLeft == 0 && zerosLeft == 0) continue;

                // if(lastWasOne == true) { explore 0s }
                int result = 0;
                for (int len = 1; len <= Math.min(zerosLeft, limit); len++) {
                    result = (result + t[onesLeft][zerosLeft - len][0]) % M;
                }
                t[onesLeft][zerosLeft][1] = result;

                // else { explore 1s }
                result = 0;
                for (int len = 1; len <= Math.min(onesLeft, limit); len++) {
                    result = (result + t[onesLeft - len][zerosLeft][1]) % M;
                }
                t[onesLeft][zerosLeft][0] = result;
            }
        }

        int startWithOne  = t[one][zero][0]; // solve(one, zero, false, limit)
        int startWithZero = t[one][zero][1]; // solve(one, zero, true, limit)
        return (startWithOne + startWithZero) % M;
    }
}