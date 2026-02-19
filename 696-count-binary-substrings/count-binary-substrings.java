class Solution {
    public int countBinarySubstrings(String s) {
        int result = 0;

        int prevCount = 0;
        int currCount = 1;

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                currCount++;
            } else {
                result    += Math.min(prevCount, currCount);
                prevCount = currCount;
                currCount = 1;
            }
        }

        return result + Math.min(prevCount, currCount);
    }
}