//package leecode;
//
//import java.util.Arrays;
//
//public class Demo57 {
////
//
//    public static void main(String[] args) {
//
//    }
//
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        if (intervals.length == 0) return new int[][]{newInterval};
//        int leftIndex = -1;
//        int rightIndex = -1;
//
//        for (int i = 0; i < intervals.length; i++) {
//            // 确认左边界
//            if (leftIndex != -1 && newInterval[0] < intervals[i][1]) {
//                leftIndex = i;
//            }
//            // 确认右边界
//            if (rightIndex != -1 && newInterval[0] < intervals[i][1]) {
//                rightIndex = i;
//            }
//        }
//        int[][] result;
//        if (leftIndex == -1) { // 最右直接拼接上
//            result = new int[intervals.length + 1][2];
//            for (int i = 0; i < intervals.length; i++) {
//                result[i] = intervals[i];
//            }
//            result[intervals.length] = newInterval;
//        }
//        if (rightIndex == -1) { // 右边最后，左边找底线
//
//        }
//
//        return result;
//    }
//}