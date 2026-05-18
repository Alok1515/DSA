class Solution {
	public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        
		if(n == 1 || n == 0)
			return 0;
        
        int allVisitedState = (1 << n) - 1;
        Queue<int []> que = new LinkedList<>();
        
		int [][] visited = new int [n][allVisitedState+1];

		for(int i=0; i<graph.length; i++) {
			que.add(new int [] {i, 1 << i});
            visited[i][(1 << i)] = 1;  
		}



		int shortestPath = 0;
		while(!que.isEmpty()){
			int size = que.size();
			shortestPath++;
			for(int i=0; i<size; i++){
                
				int [] curr  = que.poll();
				int currNode = curr[0];
				int currMask = curr[1];
                
				for(int adj : graph[currNode]){
					int nextMask = currMask | (1 << adj);

					if(visited[adj][nextMask] == 1)
                        continue;
                    
                    if(nextMask == allVisitedState)
						return shortestPath;
                    
                    visited[adj][nextMask] = 1;
					que.add(new int [] {adj, nextMask});
				}
			}
		}
		return -1;
	}
}