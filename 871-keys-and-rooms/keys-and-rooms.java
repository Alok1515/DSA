class Solution {
    private void dfs(List<List<Integer>> rooms, int source, boolean[] visited) {

        visited[source] = true;

        for(int neighbor : rooms.get(source)) {
            if(!visited[neighbor]) {
                dfs(rooms, neighbor, visited);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean[] visited = new boolean[n];

        dfs(rooms, 0, visited);

        for(boolean vis : visited) {
            if(vis == false) return false;
        }

        return true;
    }
}