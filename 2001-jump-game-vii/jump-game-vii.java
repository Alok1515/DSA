class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        int n = s.length();

        int count = 0;
        int[] freq = new int[n+1];

        freq[0] = 1; // one way to reach itself

        for(int i = 1; i <= n-1; i++) {

            // increase count if reachable from minJump
            if(i - minJump >= 0) {
                count += freq[i-minJump];
            }

            // remove count of unreacable index
            if(i - maxJump - 1 >= 0) {
                count -= freq[i-maxJump-1];
            }

            if(count > 0 && s.charAt(i) == '0') freq[i] = 1;
        }

        return freq[n-1] > 0;
    }
}