class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        // Hours go from 0 to 11
        for (int h = 0; h < 12; h++) {
            // Minutes go from 0 to 59
            for (int m = 0; m < 60; m++) {
                // Count total 1s in binary representation
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    // Format: hour:minute (with leading zero for minute if needed)
                    result.add(h + ":" + (m < 10 ? "0" + m : m));
                }
            }
        }

        return result;
    }
}