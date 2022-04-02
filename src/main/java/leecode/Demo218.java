//package leecode;//package leecode;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Demo218 {
//
//    public List<List<Integer>> getSkyline(int[][] buildings) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Point> list = new ArrayList<>(buildings.length + 1);
//        // 预先埋点
//        list.add(new Point(buildings[0][0], buildings[0][1], buildings[0][2]));
//
//        for (int[] building : buildings) {
//            int left = building[0];
//            int right = building[1];
//            int height = building[2];
//
//            result.add(Arrays.asList(left, height));
//            for (int i = list.size() - 1; i > -1; i--) {
//                Point lastPoint = list.get(i);
//                if (lastPoint.left == -1) {
//                    // 设置第一个点
//                    list.remove(i);
//                    result.add(Arrays.asList(left, height));
//                    list.add(new Point(left, right, height));
//                    break;
//                }
//                // 进行判断，如果2个建筑重叠
//                if (right <= lastPoint.right){
//
//                }
//
//            }
//
//
//        }
//
//
//    }
//
//    class Point {
//        Integer left;
//        Integer right;
//        Integer height;
//
//        public Point(Integer left, Integer right, Integer height) {
//            this.left = left;
//            this.right = right;
//            this.height = height;
//        }
//    }
//}