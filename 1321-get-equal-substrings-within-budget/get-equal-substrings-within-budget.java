class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length(); // t.length;

        int i = 0, j = 0;
        int result   = 0;
        int currCost = 0;

        while(j < n) {

            // find the currCost
            currCost += Math.abs(s.charAt(j) - t.charAt(j));

            // shrink the findow if needed
            while(currCost > maxCost) {
                currCost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }

            result = Math.max(result, j-i+1);
            j++;
        }

        return result;
    }
}