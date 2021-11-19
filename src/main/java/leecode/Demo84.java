package leecode;

public class Demo84 {
//

    public static void main(String[] args) {
        new Demo84().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }

    int maxArea = 0;
    int maxHeight = 0;

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        // 最高面积
        if (len == 1) return heights[0];


        boolean ok = true;
        while (ok) {
            ok = dfs(heights, len);
            if (maxHeight * len <= maxArea) ok = false;

        }
        return maxArea;

        // 平高峰
//        if (heights[0] > heights[1]) {
//            maxSize = Math.max(heights[0], maxSize);
//            heights[0] = heights[1];
//        }
//        if (heights[len - 1] > heights[len - 2]) {
//            maxSize = Math.max(heights[len - 1], maxSize);
//            heights[len - 1] = heights[len - 2];
//        }
//        for (int i = 1; i < len - 1; i++) {
//            if (heights[i] > heights[i - 1] && heights[i] > heights[i + 1]) {
//                maxSize = Math.max(heights[i], maxSize);
//                heights[i] = Math.max(heights[i - 1], heights[i + 1]);
//            }
//        }

    }

    private boolean dfs(int[] heights, int len) {
        boolean isExChange = false;

        for (int i = 0; i < len; i++) {
            // 往右找和自己不一样的
            int right = i;
            for (int j = i + 1; j < len; j++) {

            }


        }


        return isExChange;
    }

}