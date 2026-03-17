class Solution {
    private void dfs(int[][] stones, int index, boolean[] visited) {

        visited[index] = true;

        for(int i = 0; i < stones.length; i++) {
            int row = stones[index][0];
            int col = stones[index][1];

            if((visited[i] == false) && (stones[i][0] == row || stones[i][1] == col)) {
                dfs(stones, i, visited);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;

        boolean[] visited = new boolean[n];

        int group = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i] == true) continue; // skip the inddex

            dfs(stones, i, visited); // traverse the unvisited index

            group++;
        }

        return (n - group);
    }
}