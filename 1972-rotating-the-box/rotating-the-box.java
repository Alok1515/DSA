class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        // Create a new result array with dimensions swapped
        char[][] result = new char[n][m];

        // Transpose the box
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = box[j][i];
            }
        }

        // Reverse each row to achieve a 90-degree rotation
        for (int i = 0; i < n; i++) {
            reverseRow(result[i]);
        }

        // Apply gravity
        // O(columns * rows)
        for (int j = 0; j < m; j++) {
            int spaceBottomRow = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (result[i][j] == '*') {
                    spaceBottomRow = i - 1;
                    continue;
                }

                if (result[i][j] == '#') {
                    result[i][j] = '.';
                    result[spaceBottomRow][j] = '#';
                    spaceBottomRow--;
                }
            }
        }

        return result;
    }

    // Helper method to reverse a row
    private void reverseRow(char[] row) {
        int left = 0, right = row.length - 1;
        while (left < right) {
            char temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}