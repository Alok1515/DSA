class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {

        int left = 1, right = 10000000;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            double totalTime = 0;

            for (int i = 0; i < dist.length; i++) {
                if (i == dist.length - 1) {
                    totalTime += (double) dist[i] / mid;
                } else {
                    totalTime += Math.ceil((double) dist[i] / mid);
                }
            }

            if (totalTime <= hour) {
                ans = mid;
                right = mid - 1; // try smaller speed
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}