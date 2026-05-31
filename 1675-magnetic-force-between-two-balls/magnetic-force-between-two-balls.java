class Solution {

    private boolean canPlace(int dist, int[] position, int m) {

        int count = 1;
        int lastPos = position[0];

        for(int i = 1; i < position.length; i++) {

            if(position[i] - lastPos >= dist) {

                count++;
                lastPos = position[i];

                if(count == m) {
                    return true;
                }
            }
        }

        return false;
    }

    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);

        int n = position.length;

        int l = 1;

        // maximum possible minimum distance
        int r = position[n - 1] - position[0];

        int ans = 0;

        while(l <= r) {

            int mid = l + (r-l) / 2;

            if(canPlace(mid, position, m)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return ans;
    }
}