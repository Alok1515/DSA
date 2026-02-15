class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {

        int result = k;

        int countT = 0;
        int countF = 0;

        int i = 0;

        for (int j = 0; j < answerKey.length(); j++) {

            char ch = answerKey.charAt(j);

            // Expand window using ternary
            countT += (ch == 'T') ? 1 : 0;
            countF += (ch == 'F') ? 1 : 0;

            // Shrink window
            while (Math.min(countT, countF) > k) {

                char leftChar = answerKey.charAt(i);

                countT -= (leftChar == 'T') ? 1 : 0;
                countF -= (leftChar == 'F') ? 1 : 0;

                i++;
            }

            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}
