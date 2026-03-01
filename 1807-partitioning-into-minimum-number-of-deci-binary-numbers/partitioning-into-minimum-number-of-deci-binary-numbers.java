class Solution {
    public int minPartitions(String n) {
        
        char[] arr = n.toCharArray();

        int count = 0;

        while(true) {
            boolean changed = false;

            for(int i = 0; i < arr.length; i++) {
                if(arr[i] != '0') {
                    arr[i]--; // substarct -1
                    changed = true;
                }
            }

            if(!changed) {
                break;
            }

            count++;
        }

        return count;
    }
}