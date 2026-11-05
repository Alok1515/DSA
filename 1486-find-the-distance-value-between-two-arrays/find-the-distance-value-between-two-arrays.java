class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        
        int m = arr1.length;
        int n = arr2.length;

        int count = 0;

        for(int i = 0; i < m; i++) {
            int val = arr1[i];
            boolean allValid = true;

            for(int j = 0; j < n; j++) {
                if(Math.abs(val - arr2[j]) <= d) {
                    allValid = false;
                    break;
                }
            }
            if(allValid) count++;
        }

        return count;
    }
}