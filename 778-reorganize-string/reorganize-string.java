class Solution {
    public String reorganizeString(String s) {
        
        int[] freq = new int[26];

        // count the freq 
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // maxHeap (char, freq)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) maxHeap.offer(new int[]{i, freq[i]});
        }

        StringBuilder result = new StringBuilder();

        // process heap which is greater than 1
        while(maxHeap.size() > 1) {

            int[] first = maxHeap.poll();
            int[] second = maxHeap.poll();

            // make result
            result.append((char) (first[0] + 'a'));
            result.append((char) (second[0] + 'a'));

            // decrease freq
            first[1]--;
            second[1]--;

            if(first[1] > 0) maxHeap.offer(first);
            if(second[1] > 0) maxHeap.offer(second);
        }

        while(!maxHeap.isEmpty()) {
            int[] last = maxHeap.poll();

            if(last[1] > 1) return "";

            result.append((char) (last[0] + 'a'));
        }

        return result.toString();
    }
}