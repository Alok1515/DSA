class Solution {
    public int minPartitions(String n) {
        
        char maxCh = '0';

        for(char ch : n.toCharArray()) {
            maxCh = (char)Math.max(ch, maxCh);
        }

        return maxCh - '0';
    }
}