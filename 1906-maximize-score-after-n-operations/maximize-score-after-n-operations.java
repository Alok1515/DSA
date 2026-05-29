class Solution {

    int n;
    int[] dp;

    private String getKey(boolean[] visited) {

        StringBuilder sb = new StringBuilder();

        for(boolean b : visited) {

            if(b) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }

        return sb.toString();
    }

    private int gcd(int a, int b) {

        while(b != 0) {
            int temp = b;
            b        = a % b;
            a        = temp;
        }

        return a;
    }

    private int solve(int[] nums, int operations, boolean[] visited, Map<String, Integer> map) {

        String key = getKey(visited);

        if(map.containsKey(key)) return map.get(key);

        int maxScore = 0;

        for(int i = 0; i < n-1; i++) {
            if(visited[i] == true) continue;

            for(int j = i+1; j < n; j++) {

                if(visited[j] == true) continue;

                // mark true 
                visited[i] = true;
                visited[j] = true;

                int currScore      = operations * gcd(nums[i], nums[j]);
                int remainingScore = solve(nums, operations + 1, visited, map);

                // update the maxScore
                maxScore = Math.max(maxScore, currScore + remainingScore);

                // unmark for further calls
                visited[i] = false;
                visited[j] = false;
            }
        }

        map.put(key, maxScore);

        return maxScore;
    }
    public int maxScore(int[] nums) {
        n = nums.length;

        boolean[] visited = new boolean[n];
        
        Map<String, Integer> map = new HashMap<>();

        return solve(nums, 1, visited, map);

    }
}