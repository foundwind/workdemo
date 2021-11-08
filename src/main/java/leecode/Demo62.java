package leecode;

public class Demo62 {
//

    public static void main(String[] args) {
        System.out.println(new Demo62().uniquePaths(3, 7));
    }

    int[][] sum;

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        sum = new int[m][n];
        for (int i = 0; i < n; i++) {
            sum[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            sum[i][0] = 1;
        }
        return rount(m, n);
    }

    public int rount(int m, int n) {
        if (sum[m - 2][n - 1] == 0) {
            sum[m - 2][n - 1] = rount(m - 1, n);
        }
        if (sum[m - 1][n - 2] == 0) {
            sum[m - 1][n - 2] = rount(m, n - 1);
        }
        return sum[m - 2][n - 1] + sum[m - 1][n - 2];
    }
}