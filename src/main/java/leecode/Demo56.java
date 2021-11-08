package leecode;

import java.util.Arrays;

public class Demo56 {
//

    public static void main(String[] args) {
//        new Demo56().merge(new int[][]{
//                {1, 3},
//                {2, 6},
//                {8, 10},
//                {15, 18}
//        });
        new Demo56().merge(new int[][]{
                {1, 4},
                {0, 0}
        });
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);


        if (intervals.length == 1) return intervals;
        // 初始化
        int[] cache = new int[2];
        cache[0] = intervals[0][0];
        cache[1] = intervals[0][1];

        int num = 0;
        for (int i = 1; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (cache[1] >= right) {
                // 不用进行任何操作
            } else if (cache[1] >= left) {
                // 继续往右入侵
                cache[1] = right;
            } else {
                // 入库cache
                intervals[num][0] = cache[0];
                intervals[num][1] = cache[1];
                cache[0] = left;
                cache[1] = right;
                num++;
            }
        }
        // 入侵完入库最后一个
        intervals[num][0] = cache[0];
        intervals[num][1] = cache[1];
        num++;
        return Arrays.copyOf(intervals, num);
    }

}