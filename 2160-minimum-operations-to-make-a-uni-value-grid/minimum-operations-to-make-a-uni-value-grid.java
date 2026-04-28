class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();

        // Flatten the grid
        for(int[] row : grid) {
            for(int val : row) {
                list.add(val);
            }
        }

        // sort
        Collections.sort(list);

        int median = list.get(list.size() / 2);

        // calculate operation
        int operations = 0;
        for(int val : list) {
            if(Math.abs(val - median) % x != 0) return -1;
            operations += Math.abs(val - median) / x;
        }

        return operations;
    }
}