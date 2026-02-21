class Solution {
    public int countPrimeSetBits(int left, int right) {
        int result = 0;

        HashSet<Integer> primes = new HashSet<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));

        for(int num = left; num <= right; num++) {
            int setBits = Integer.bitCount(num);

            if(primes.contains(setBits)) {
                result++;
            }
        }

        return result;
    }
}