class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        int[] inDegree = new int[n];

        List<Integer>[] graph = new ArrayList[n];

        // Build adj list
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] rel : relations) {
            int u = rel[0] - 1;
            int v = rel[1] - 1;

            graph[u].add(v);
            inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] finishTime = new int[n];

        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
                finishTime[i] = time[i];
            }
        }

        while(!q.isEmpty()) {

            int curr = q.poll();

            for(int next : graph[curr]) {

                finishTime[next] = Math.max(finishTime[next], time[next] + finishTime[curr]);

                inDegree[next]--;

                if(inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return Arrays.stream(finishTime).max().getAsInt();
    }
}