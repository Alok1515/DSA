class Solution {
    public List<Integer> diffWaysToCompute(String s) {
        return solve(s);
    }

    private List<Integer> solve(String s) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '+' || c == '-' || c == '*') {
                List<Integer> leftResult = solve(s.substring(0, i));
                List<Integer> rightResult = solve(s.substring(i+1));

                for(int x : leftResult) {
                    for(int y : rightResult) {

                        if(c == '+') {
                            result.add(x + y);
                        } else if(c == '-') {
                            result.add(x - y);
                        } else {
                            result.add(x * y);
                        }
                    }
                }
            }
        }

        // If no operator is found, it means the string is a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(s));
        }

        return result;
    } 
}