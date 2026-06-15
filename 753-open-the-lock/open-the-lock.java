class Solution {

    private void fillNeighbors(Queue<String> q, StringBuilder curr, Set<String> dead) {

        // try for the 4 characters
        for(int i = 0; i < 4; i++) {

            char ch = curr.charAt(i);

            char dec = (ch == '0') ? '9' : (char) (ch - 1);
            char inc = (ch == '9') ? '0' : (char) (ch + 1);

            curr.setCharAt(i, dec);
            String decStr = curr.toString();
            if(!dead.contains(decStr)) {
                dead.add(decStr);
                q.offer(decStr);
            }

            curr.setCharAt(i, inc);
            String incStr = curr.toString();
            if(!dead.contains(incStr)) {
                dead.add(incStr);
                q.offer(incStr);
            }

            curr.setCharAt(i, ch); // set back the prev char
        } 
    }
    public int openLock(String[] deadends, String target) {
        
        Set<String> dead = new HashSet<>();

        for(String deadend : deadends) {
            dead.add(deadend);
        }

        String start = "0000";
        if(dead.contains(start)) {
            return -1;
        }

        int level = 0;

        Queue<String> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()) {

            int size = q.size();

            while(size-- > 0) {

                String curr = q.poll();
                if(curr.equals(target)) {
                    return level;
                }

                StringBuilder currBuilder = new StringBuilder(curr);
                fillNeighbors(q, currBuilder, dead);
            }
            level++;
        }

        return -1;
    }
}