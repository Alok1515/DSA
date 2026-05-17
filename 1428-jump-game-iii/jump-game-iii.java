class Solution {
    
    private boolean solve(int[] arr, int i, int n, boolean[] visited) {

        // out of bound case 
        if(i < 0 || i >= n) return false;

        if(visited[i]) return false;

        // base case 
        if(arr[i] == 0) {
            return true;
        }

        visited[i] = true;

        if(solve(arr, arr[i] + i, n, visited)) {
            return true;
        } 

        if(solve(arr, i - arr[i], n, visited)) {
            return true;
        } 

        return false;
    }
    public boolean canReach(int[] arr, int start) {

        int n = arr.length;
        boolean[] visited = new boolean[n];

        return solve(arr, start, n, visited);
    }
}