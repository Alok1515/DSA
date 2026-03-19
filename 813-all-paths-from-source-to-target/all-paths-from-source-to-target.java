class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        int source = 0;
        int target = graph.length - 1;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Queue<List<Integer>> q = new LinkedList<>();
        temp.add(0);
        q.offer(new ArrayList<>(temp));

        while(!q.isEmpty()) {

            List<Integer> currPath = q.poll();

            int lastNode = currPath.get(currPath.size() - 1); // get the last node

            if(lastNode == target) {
                result.add(currPath);
            } else {
                for(int v : graph[lastNode]) {
                    List<Integer> path = new ArrayList<>(currPath); // copy the currPath
                    path.add(v);
                    q.offer(new ArrayList<>(path));
                }
            }
        }

        return result;
    }
}