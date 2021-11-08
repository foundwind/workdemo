//package leecode;
//
//public class Demo63 {
////
//
//    public static void main(String[] args) {
//        System.out.println(new Demo63().uniquePathsWithObstacles(new int[][]{
//                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
//
//        }));
//    }
//
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//
//        int m = obstacleGrid.length;
//        int n = obstacleGrid[0].length;
//        if (m == 1 && n == 1){
//            if ()
//        }
//
//
//        obstacleGrid[0][0] =0;
//        if (m == 1 || n == 1) {
//            for (int[] ints : obstacleGrid) {
//                for (int anInt : ints) {
//                    if (anInt == 1) return 0;
//                }
//            }
//            return 1;
//        }
//        if (obstacleGrid[m - 1][n - 1] == 1) return 0;
//
//
//        for (int i = 0; i < n; i++) {
//            if (obstacleGrid[0][i] != 1)
//                obstacleGrid[0][i] = -1;
//        }
//        for (int i = 0; i < m; i++) {
//            if (obstacleGrid[i][0] != 1)
//                obstacleGrid[i][0] = -1;
//        }
//        return -round(m, n, obstacleGrid);
//    }
//
//    public int round(int m, int n, int[][] obstacleGrid) {
//        int one = obstacleGrid[m - 2][n - 1];
//        int two = obstacleGrid[m - 1][n - 2];
//        if (obstacleGrid[m - 2][n - 1] == 0) {
//            obstacleGrid[m - 2][n - 1] = round(m - 1, n, obstacleGrid);
//            one = obstacleGrid[m - 2][n - 1];
//        } else if (obstacleGrid[m - 2][n - 1] == 1) {
//            one = 0;
//        }
//        if (obstacleGrid[m - 1][n - 2] == 0) {
//            obstacleGrid[m - 1][n - 2] = round(m, n - 1, obstacleGrid);
//            two = obstacleGrid[m - 1][n - 2];
//        } else if (obstacleGrid[m - 1][n - 2] == 1) {
//            two = 0;
//        }
//        return one + two;
//    }
//
//}