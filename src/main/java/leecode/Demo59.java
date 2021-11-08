package leecode;

public class Demo59 {
//

    public static void main(String[] args) {
        new Demo59().generateMatrix(3);
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0;
        int right = n;
        int up = 1;
        int down = n;
        int total = n * n;
        int num = 1;
        int x = 0, y = 0;
        while (true) {
            // 向右
            do {
                result[y][x] = num++;
                x++;
            } while (x < right);
            if (num > total) break;
            x--;
            y++;
            right--;
            // 向下
            do {
                result[y][x] = num++;
                num++;
                y++;
            } while (y < down);
            if (num > total) break;
            y--;
            x--;
            down--;
            // 向左
            do {
                result[y][x] = num++;
                num++;
                x--;
            } while (x >= left);
            if (num > total) break;
            x++;
            y--;
            left++;
            // 向上
            do {
                result[y][x] = num++;
                num++;
                y--;
            } while (y >= up);
            if (num > total) break;
            y++;
            x++;
            up++;

        }

        return result;
    }
}