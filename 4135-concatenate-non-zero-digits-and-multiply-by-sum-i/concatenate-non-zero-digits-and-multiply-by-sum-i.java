class Solution {
    public long sumAndMultiply(int n) {

        long answer = 0;
        int sum = 0;
        String x = "";
        
        while(n > 0) {
            int digit = n % 10;
            if(digit != 0) {
               sum += digit;
               x += digit;
            }
            n /= 10;
        }

        if(x.isEmpty()) return 0;

        StringBuilder sb = new StringBuilder(x);
        sb.reverse();

        int y = Integer.parseInt(sb.toString());

        answer = (long) y * sum;

        return answer;
    }
}