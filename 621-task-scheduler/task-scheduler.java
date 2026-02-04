class Solution {
    public int leastInterval(char[] tasks, int n) {
        // step 1 : count frequency
        int[] map = new int[26];
        for(char c : tasks) {
            map[c - 'A']++;
        }

        int time = 0;

        // Max heap to store the freq
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int f : map) {
            if (f > 0) maxHeap.add(f);
        }

        while(!maxHeap.isEmpty()) {

            List<Integer> list = new ArrayList<>();

            for(int i = 0; i <= n; i++) {
                    if(!maxHeap.isEmpty()) {
                    int freq = maxHeap.poll();
                    freq--;
                    list.add(freq);
                }
            } 

            for(int f : list) {
                if(f > 0) {
                    maxHeap.add(f);
                }
            }

            if (!maxHeap.isEmpty()) {
                time += n + 1;
            } else {
                time += list.size();
            }

        }

        return time;
    }
}