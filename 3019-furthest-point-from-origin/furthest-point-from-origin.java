class Solution {
    public int furthestDistanceFromOrigin(String moves) {

        int leftCount = 0;
        int rightCount = 0;
        int emptyPathCount = 0;
        
        for(int i = 0; i < moves.length(); i++) {
            if(moves.charAt(i) == 'L') leftCount++;
            else if(moves.charAt(i) == 'R') rightCount++;
            else if(moves.charAt(i) == '_') emptyPathCount++;
        }

        return Math.abs(leftCount - rightCount) + emptyPathCount;
    }
}