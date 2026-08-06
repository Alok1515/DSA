class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        
        int r1 = startPos[0], c1 = startPos[1];
        int r2 = homePos[0], c2 = homePos[1];
        
        int res = 0;

        //Move in rows
        if (r2 >= r1) {
            // moving DOWN
            for (int r = r1 + 1; r <= r2; r++) {
                res += rowCosts[r];
            }
        } else {
            // moving UP
            for (int r = r1 - 1; r >= r2; r--) {
                res += rowCosts[r];
            }
        }

        //Move in columns
        if (c2 >= c1) {
            // moving RIGHT
            for (int c = c1 + 1; c <= c2; c++) {
                res += colCosts[c];
            }
        } else {
            // moving LEFT
            for (int c = c1 - 1; c >= c2; c--) {
                res += colCosts[c];
            }
        }

        return res;
    }
}