class Solution {
    public int numberOfSpecialChars(String word) {

        int n = word.length();
        int count = 0;
        
        int[] freq = new int[123];

        for(char ch : word.toCharArray()) {
            freq[ch]++;
        }

        for(int i = 97; i <= 122; i++) {

            int capitalIndex = i - 32;

            if(freq[i] > 0 && freq[capitalIndex] > 0) count++;
        }

        return count;
    }
}