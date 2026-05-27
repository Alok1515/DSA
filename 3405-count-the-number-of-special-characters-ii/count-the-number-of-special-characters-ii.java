class Solution {
    public int numberOfSpecialChars(String word) {
        
        int[] lastSmall = new int[26];
        int[] firstCapital = new int[26];

        java.util.Arrays.fill(lastSmall, -1);
        java.util.Arrays.fill(firstCapital, -1);

        for(int i = 0; i < word.length(); i++) {
            
            char ch = word.charAt(i);

            if(Character.isLowerCase(ch)) {
                lastSmall[ch - 'a'] = i;
            }
            else {
                if(firstCapital[ch - 'A'] == -1) {
                    firstCapital[ch - 'A'] = i;
                }
            }
        }

        int count = 0;

        for(int i = 0; i < 26; i++) {

            if(lastSmall[i] != -1 && firstCapital[i] != -1 &&
               lastSmall[i] < firstCapital[i]) {
                count++;
            }
        }

        return count;
    }
}