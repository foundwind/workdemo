package leecode;

public class Demo378 {
    public static void main(String[] args) {
        System.out.println(new Demo378().kthSmallest(new int[][]
                {
                        {1, 5, 9}, {10, 11, 13}, {12, 13, 15}
                }, 13));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < k; i++) {
            // 往右下右上找
            int r = Integer.MAX_VALUE;
            int d = Integer.MAX_VALUE;
            int ur = Integer.MAX_VALUE;
            int ld = Integer.MAX_VALUE;
            if (x + 1 < matrix.length) {
                r = matrix[y][x + 1];
            }
            if (y + 1 < matrix.length) {
                d = matrix[y + 1][x];
            }
            if (y > 0 && x + 1 < matrix.length) {
                ur = matrix[y - 1][x + 1];
            }
            if (x > 0 && y + 1 < matrix.length) {
                ld = matrix[y + 1][x - 1];
            }
            if (r != Integer.MAX_VALUE && r <= d && r <= ur && r <= ld) {
                x = x + 1;
                continue;
            }
            if (d != Integer.MAX_VALUE && d <= r && d <= ur && d <= ld) {
                y = y + 1;
                continue;
            }
            if (ur != Integer.MAX_VALUE && ur <= r && ur <= d && ur <= ld) {
                x = x + 1;
                y = y - 1;
                continue;
            }
            if (ld != Integer.MAX_VALUE && ld <= r && ld <= d && ld <= ur) {
                x = x - 1;
                y = y + 1;
                continue;
            }
        }

        return matrix[y][x];
    }


}
