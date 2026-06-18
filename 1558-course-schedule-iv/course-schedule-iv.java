class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] preq : prerequisites) {
            int u = preq[0];
            int v = preq[1];

            graph[u].add(v);
            inDegree[v]++;
        }

        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }

        Set<Integer>[] set = new HashSet[numCourses];

        for(int i = 0; i < numCourses; i++) {
            set[i] = new HashSet<>();
        }

        while(!q.isEmpty()) {

            int curr = q.poll();

            for(int next : graph[curr]) {

                set[next].add(curr);

                set[next].addAll(set[curr]); // add all preq of the curr as well

                inDegree[next]--;

                if(inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for(int[] query : queries) {
            int u = query[0];
            int v = query[1];

            ans.add(set[v].contains(u));
        }

        return ans;
    }
}