class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int i = 0, j = 1;
        int count = 0;

        while(j < n) {

            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            int nextStart = intervals[j][0];
            int nextEnd = intervals[j][1];

            // no overlapping case
            if(nextStart >= currEnd) {
                i = j;
                j++;
            } else if(currEnd <= nextEnd) { // overlapping
                j++;
                count += 1;
            } else if(currEnd > nextEnd) { // overlapping
                i = j;
                j++;
                count++;
            }
        }

        return count;
    }
}