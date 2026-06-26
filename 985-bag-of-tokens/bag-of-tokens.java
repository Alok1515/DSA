class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        Arrays.sort(tokens);

        int i = 0, j = tokens.length - 1;

        int score = 0;
        int maxScore = 0;

        while(i <= j) {

            if(tokens[i] <= power) {
                power -= tokens[i];
                score += 1;
                maxScore = Math.max(maxScore, score);
                i++;
            } else if(score > 0) {
                power += tokens[j];
                score -= 1;
                j--;
            } else {
                break;
            }
        }

        return maxScore;
    }
}