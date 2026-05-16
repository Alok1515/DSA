class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        List<Integer> result = new ArrayList<>();

        int[] indegree = new int[n];

        // cacculate indegree
        for(List<Integer> edge : edges) {

            int to = edge.get(1);

            indegree[to]++;
        }

        for(int i = 0; i < indegree.length; i++) {
            
            // nodes with indegree 0
            if(indegree[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }
}