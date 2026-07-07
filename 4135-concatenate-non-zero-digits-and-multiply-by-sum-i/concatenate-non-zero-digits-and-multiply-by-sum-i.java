class Solution {
    public long sumAndMultiply(int n) {

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            int digit = n % 10;
            if(digit != 0) {
               sum += digit;
               sb.append(digit);
            }
            n /= 10;
        }

        if(sb.length() == 0) return 0;

        sb.reverse();

        Long number = Long.parseLong(sb.toString());

        return number * sum;
    }
}