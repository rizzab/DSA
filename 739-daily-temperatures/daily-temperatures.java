import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices

        for (int i = n - 1; i >= 0; i--) {
            // Pop all indices with temperatures less than or equal to current
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            // If stack is not empty, the difference is the answer
            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }
            // Push current index onto stack
            stack.push(i);
        }

        return result;
    }
}
