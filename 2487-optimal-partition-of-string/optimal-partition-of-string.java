class Solution {
    public int partitionString(String s) {
        int count = 0;
        int startIdx = 0;

        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        for(int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);

            if(lastSeen[ch - 'a'] >= startIdx) {
                count++;
                startIdx = i;
            }
            lastSeen[ch - 'a'] = i;
        }

        return count + 1;
    }
}