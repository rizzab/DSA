class Solution {
    private int[] arr;
    private List<List<String>> ans;

    private void helper(int row, int n) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] boardRow = new char[n];
                Arrays.fill(boardRow, '.');
                boardRow[arr[i]] = 'Q';
                temp.add(new String(boardRow));
            }
            ans.add(temp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (issafe(row, col)) {
                arr[row] = col;
                helper(row + 1, n);
            }
        }
    }

    private boolean issafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (arr[i] == col || Math.abs(row - i) == Math.abs(col - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        arr = new int[n];
        Arrays.fill(arr, -1);
        ans = new ArrayList<>();
        helper(0, n);
        return ans;
    }
}