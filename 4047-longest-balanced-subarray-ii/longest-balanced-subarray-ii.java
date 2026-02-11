class Solution {

    int[] segMin, segMax, lazy;
    int n;

    void propagate(int i, int l, int r) {
        if (lazy[i] != 0) {
            segMin[i] += lazy[i];
            segMax[i] += lazy[i];

            if (l != r) {
                lazy[2 * i + 1] += lazy[i];
                lazy[2 * i + 2] += lazy[i];
            }
            lazy[i] = 0;
        }
    }

    void updateRange(int start, int end, int i, int l, int r, int val) {
        propagate(i, l, r);

        if (l > end || r < start) return;

        if (l >= start && r <= end) {
            lazy[i] += val;
            propagate(i, l, r);
            return;
        }

        int mid = (l + r) / 2;
        updateRange(start, end, 2 * i + 1, l, mid, val);
        updateRange(start, end, 2 * i + 2, mid + 1, r, val);

        segMin[i] = Math.min(segMin[2 * i + 1], segMin[2 * i + 2]);
        segMax[i] = Math.max(segMax[2 * i + 1], segMax[2 * i + 2]);
    }

    int findLeftMostZero(int i, int l, int r) {
        propagate(i, l, r);

        if (segMin[i] > 0 || segMax[i] < 0) return -1;

        if (l == r) return l;

        int mid = l + (r - l) / 2;
        int left = findLeftMostZero(2 * i + 1, l, mid);
        if (left != -1) return left;

        return findLeftMostZero(2 * i + 2, mid + 1, r);
    }

    public int longestBalanced(int[] nums) {
        n = nums.length;

        segMin = new int[4 * n];
        segMax = new int[4 * n];
        lazy   = new int[4 * n];

        int maxL = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int r = 0; r < n; r++) {
            int val = (nums[r] % 2 == 0) ? 1 : -1;
            int prev = map.getOrDefault(nums[r], -1);

            if (prev != -1) {
                updateRange(0, prev, 0, 0, n - 1, -val);
            }

            updateRange(0, r, 0, 0, n - 1, val);

            int l = findLeftMostZero(0, 0, n - 1);
            if (l != -1) {
                maxL = Math.max(maxL, r - l + 1);
            }

            map.put(nums[r], r);
        }

        return maxL;
    }
}