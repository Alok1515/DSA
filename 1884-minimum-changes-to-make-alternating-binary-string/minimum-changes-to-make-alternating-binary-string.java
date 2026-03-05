class Solution {
    public int minOperations(String s) {
        
        int n = s.length();

        int startWith_0 = 0;
        int startWith_1 = 0;

        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) { // Even 
               if(s.charAt(i) == '0') {
                  startWith_1++;
               } else {
                  startWith_0++;
               }
            } else {
                if(s.charAt(i) == '1') {
                    startWith_1++;
                } else {
                    startWith_0++;
                }
            }
        }

        return Math.min(startWith_0, startWith_1); 
    }
}