class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] t = new boolean[n+1]; //defaults to all false
        //Base case . n == 0, return false
        t[0] = false; //base case
        for(int i = 1; i < n+1; i++) {
            for(int k = 1; k*k <= i; k++) {
                if(t[i - (k*k)] == false) {
                    t[i] = true;
                    break;
                }
            }
        }
        return t[n]; //return solve(n)
    }
}