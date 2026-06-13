class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
         // Safety check
        if (weights == null || weights.length < 26 || words == null)
            return null;

        int n = words.length;
        StringBuilder result = new StringBuilder();

        // Process each word
        for (int i = 0; i < n; i++) {
            String w = words[i];
            int sum = 0;

            // Calculate weight sum of the word
            for (int j = 0; j < w.length(); j++) {
                char ch = w.charAt(j);

                if (ch >= 'a' && ch <= 'z') {
                    sum += weights[ch - 'a'];
                }
            }

            // Modulo mapping
            int m = sum % 26;

            // 0 -> 'z', 1 -> 'y', ..., 25 -> 'a'
            char mappedChar = (char) ('z' - m);

            result.append(mappedChar);
        }

        return result.toString();
    }
}