class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();

        int minDel = 0;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            // that means ba
            if(!stack.isEmpty() && s.charAt(i) == 'a' && stack.peek() == 'b') {
                stack.pop();
                minDel++;
            } else {
                stack.push(s.charAt(i));
            }
        }

        return minDel;
    }
}