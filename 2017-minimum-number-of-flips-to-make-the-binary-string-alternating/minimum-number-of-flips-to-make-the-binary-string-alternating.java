class Solution {
    public int minFlips(String s) {

        int n = s.length();

        int result = Integer.MAX_VALUE;
        int flip1 = 0;
        int flip2 = 0;

        int i = 0, j = 0;

        while(j < 2*n) {

            char expectedCharS1 = (j % 2 == 1) ? '1' : '0';
            char expectedCharS2 = (j % 2 == 1) ? '0' : '1';

            if(s.charAt(j % n) != expectedCharS1) flip1++;
            if(s.charAt(j % n) != expectedCharS2) flip2++;

            if(j - i + 1 > n) {

                expectedCharS1 = (i % 2 == 1) ? '1' : '0';
                expectedCharS2 = (i % 2 == 1) ? '0' : '1';

                if(s.charAt(i % n) != expectedCharS1) flip1--;
                if(s.charAt(i % n) != expectedCharS2) flip2--;

                i++;
            }

            if(j - i + 1 == n)
                result = Math.min(result, Math.min(flip1, flip2));

            j++;
        }

        return result;
    }
}