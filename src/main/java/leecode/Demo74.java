package leecode;

public class Demo74 {
//

    public static void main(String[] args) {
//        System.out.println(new Demo74().searchMatrix(
//                new int[][]{
//                        {1, 3, 5, 7},
//                        {10, 11, 16, 20},
//                        {23, 30, 34, 60},
//                }, 11));
        new Demo74().searchMatrix(
                new int[][]{
                        {1},
                }, 1);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int yLen = matrix.length;
        int xLen = matrix[0].length;
        // 跳表查询法
        int y = 0;
        for (int i = 0; i < yLen - 1; i++) {
            if (matrix[i][0] == target || matrix[i + 1][0] == target) return true;
            // 不合规
            if (matrix[i][0] > target) return false;
            if (target < matrix[i + 1][0]) { // 范围内取左边
                y = i;
                break;
            } else { // 如果最后一个了
                if (i + 1 == yLen - 1) y = yLen - 1;
            }
        }
        // 二分法查询
        int left = 0;
        int right = xLen - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[y][mid] == target) return true;
            if (matrix[y][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return matrix[y][left] == target;
    }

}