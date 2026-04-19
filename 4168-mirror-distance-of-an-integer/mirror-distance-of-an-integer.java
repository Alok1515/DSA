class Solution {
    private int reverseNumber(int n) {
        int digit = 0;
        int reverse = 0;
        int num = n;

        while(num != 0) {
            digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num / 10;
        }

        return reverse;
    }
    public int mirrorDistance(int n) {
        return Math.abs(n - reverseNumber(n));
    }
}