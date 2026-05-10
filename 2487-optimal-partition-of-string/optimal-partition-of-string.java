class Solution {
    public int partitionString(String s) {
        Set<Character> st = new HashSet<>();
        int count = 1;

        for(char ch : s.toCharArray()) {
            if(!st.contains(ch)) {
                st.add(ch);
            } else {
                count++;
                st.clear();
                st.add(ch);
            }
        }

        return count;
    }
}