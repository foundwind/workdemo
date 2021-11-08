package leecode;

public class Demo64 {
//

    public static void main(String[] args) {
        new Demo64().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }

    int totol = 0;

    public int minPathSum(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        int[][] dp = new int[m + 1][n + 1];

        int a =  minPathSum(grid, dp, m, n);
        return a;
    }


    // m = y轴，n = x轴
    public int minPathSum(int[][] grid, int[][] dp, int m, int n) {
        totol++;
        if (m == 0 && n == 0) {  // 起点
            dp[m][n] = grid[0][0];
        } else if (m == 0) {  // 第一行
            if (dp[m][n - 1] != 0) { // 处理第一行
                dp[m][n] = dp[m][n - 1] + grid[0][n];
            } else {  // 处理第一行
                dp[m][n] = minPathSum(grid, dp, 0, n - 1) + grid[0][n];
            }
        } else if (n == 0) {
            if (dp[m - 1][n] != 0) {
                dp[m][n] = dp[m - 1][n] + grid[m][0];
            } else {
                dp[m][n] = minPathSum(grid, dp, m - 1, 0) + grid[m][0];
            }
        } else { // 正式处理
            if (dp[m][n - 1] != 0 && dp[m - 1][n] != 0) {
                dp[m][n] = Math.min(dp[m][n - 1], dp[m - 1][n]) + grid[m][n];
            } else if (dp[m][n - 1] != 0) {
                dp[m][n] = Math.min(minPathSum(grid, dp, m - 1, n), dp[m][n - 1]) + grid[m][n];
            } else if (dp[m - 1][n] != 0) {
                dp[m][n] = Math.min(dp[m - 1][n], minPathSum(grid, dp, m, n - 1)) + grid[m][n];
            } else {
                dp[m][n] = Math.min(minPathSum(grid, dp, m - 1, n), minPathSum(grid, dp, m, n - 1)) + grid[m][n];
            }
        }
        return dp[m][n];
    }


}