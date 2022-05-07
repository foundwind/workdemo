package leecode;

import java.util.TreeSet;

public class Demo363 {
//

    public static void main(String[] args) {
        if (Thread.interrupted()){

        }
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int yLen = matrix.length, xLen = matrix[0].length;
        for (int i = 0; i < yLen; ++i) { // 枚举上边界
            int[] sum = new int[xLen];
            for (int j = i; j < yLen; ++j) { // 枚举下边界
                for (int c = 0; c < xLen; ++c) {
                    sum[c] += matrix[j][c]; // 更新每列的元素和
                }
                TreeSet<Integer> sumSet = new TreeSet<Integer>();
                sumSet.add(0);
                int s = 0;
                for (int v : sum) {
                    s += v;
                    // 返回大于或者等于
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }


}
