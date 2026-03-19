class Solution {
    int target;
    private void dfs(int[][] graph, int start, List<Integer> temp,  List<List<Integer>> result) {

        if(start == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int x : graph[start]) {
            temp.add(x);
            dfs(graph, x, temp, result);
            temp.remove(temp.size() - 1); // backtrack to check another path
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        target = graph.length - 1;

        temp.add(0); // add the start node in temp
        dfs(graph, 0, temp, result);

        return result;

    }
}