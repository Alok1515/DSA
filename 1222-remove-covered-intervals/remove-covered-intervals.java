class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for(int i = 1; i < n; i++) {
            int[] last = result.get(result.size()-1);
            if(last[1] >= intervals[i][1]) continue;
            else result.add(intervals[i]);
        }

        return result.size();
    }
}