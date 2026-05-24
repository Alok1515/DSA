class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        Arrays.sort(potions);

        for(int i = 0; i < n; i++) {
            
            // ceil value 
            long minPotion = (long)Math.ceil(1.0 * (success) / spells[i]);

            int l = 0, r = m-1;
            int idx = m;

            while(l <= r) {

                int mid = l + (r - l) / 2;

                if(potions[mid] >= minPotion) {
                    idx = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            result[i] = m - idx;;
        }

        return result;
    }
}