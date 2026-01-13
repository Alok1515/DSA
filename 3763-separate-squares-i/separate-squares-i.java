class Solution {

    private boolean check(int[][] squares, double midY, double total) {
        double bottomArea = 0.0;

        for (int[] square : squares) {
            double y = square[1];
            double l = square[2];

            double bottomY = y;
            double topY = y + l;

            if (midY >= topY) {
                // full square below
                bottomArea += l * l;
            } else if (midY > bottomY) {
                // partial square below
                bottomArea += (midY - bottomY) * l;
            }
        }

        return bottomArea >= total / 2.0; //Is bottom area more than above ?
    }

    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = -Double.MAX_VALUE;
        double total = 0.0;

        for (int[] square : squares) {
            double y = square[1];
            double l = square[2];

            total += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double resultY = 0.0;

        while (high - low > 1e-5) {
            double midY = low + (high - low) / 2.0;
            resultY = midY;

            if (check(squares, midY, total)) {
                // bottom area is more than half, move down
                high = midY;
            } else {
                low = midY;
            }
        }

        return resultY;
    }
}