package leecode;

import java.util.ArrayList;
import java.util.List;

public class Demo54 {
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

    public static void main(String[] args) {
//        new Demo54().spiralOrder(new int[][]{
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}
//        });

        new Demo54().spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        });
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length;
        int up = 1;
        int down = matrix.length;
        int total = matrix.length * matrix[0].length;
        int num = 0;
        int x = 0, y = 0;
        while (true) {
            // 向右
            do {
                result.add(matrix[y][x]);
                num++;
                x++;
            } while (x < right);
            if (num == total) break;
            x--;
            y++;
            right--;
            // 向下
            do {
                result.add(matrix[y][x]);
                num++;
                y++;
            } while (y < down);
            if (num == total) break;
            y--;
            x--;
            down--;
            // 向左
            do {
                result.add(matrix[y][x]);
                num++;
                x--;
            } while (x >= left);
            if (num == total) break;
            x++;
            y--;
            left++;
            // 向上
            do {
                result.add(matrix[y][x]);
                num++;
                y--;
            } while (y >= up);
            if (num == total) break;
            y++;
            x++;
            up++;

        }

        return result;
    }

}