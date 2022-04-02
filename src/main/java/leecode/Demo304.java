package leecode;

public class Demo304 {
//

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }


    static class NumMatrix {
        private int[][] rowArr;
        private int[][] vetArr;

        public NumMatrix(int[][] matrix) {
            rowArr = new int[matrix.length][matrix[0].length + 1];
            vetArr = new int[matrix.length + 1][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    rowArr[i][j + 1] = rowArr[i][j] + matrix[i][j];
                    vetArr[i + 1][j] = vetArr[i][j] + matrix[i][j];
                }
            }
        }

        //1, 2, 2, 4
        public int sumRegion(int row1, int col1, int row2, int col2) {
            // 证明竖多
            int sum = 0;
            if (row2 - row1 < col2 - col1) {
                for (int i = row1; i < row2 + 1; i++) {
                    sum += rowArr[i][col2 + 1] - rowArr[i][col1];
                }
            } else {
                for (int i = col1; i < col2 + 1; i++) {
                    sum += vetArr[row2 + 1][i] - vetArr[row1][i];
                }
            }
            return sum;
        }
    }
}
