import java.util.*;

class Solution {
    int[] prefix;
    int total;

    public Solution(int[] w) {
        prefix = new int[w.length];
        total = 0;
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            prefix[i] = total;
        }
    }

    public int pickIndex() {
        int r = (int)(Math.random() * total) + 1; // r in [1, total]
        int low = 0, high = prefix.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (prefix[mid] < r) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}