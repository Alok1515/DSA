class Solution {
    public int smallestNumber(int n, int t) {
        
        int num = n;

        while(true) {
            if(digitProd(num) % t == 0) {
                return num;
            }
            num++;
        }
    }

    private int digitProd(int num) {

        if(num == 0) return 0;

        int prod = 1;

        while(num > 0) {
            prod *= (num % 10);
            num /= 10;
        }

        return prod;
    }
}