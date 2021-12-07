package leecode;

public class Demo85 {
//

    public static void main(String[] args) {
        new Demo85().maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        });
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null) return 0;
        int deep = matrix.length;
        if (deep == 0) return 0;
        int len = matrix[0].length;
        if (len == 0) return 0;

        int maxArea = 0;
        int[][] ints = new int[deep][len];


        for (int i = 0; i < deep; i++) {
            // 不是第一层
            for (int j = 0; j < len; j++) {
                if (matrix[i][j] == '1') {
                    ints[i][j] = (i != 0 ? ints[i - 1][j] : 0) + 1;
                }
            }
            // 查找这层的最大值
            for (int j = 0; j < len; j++) {
                maxArea = Math.max(maxArea, largestRectangleArea(ints[i]));
            }

        }

        return maxArea;

    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        int maxArea = 0;

        int[] stack = new int[len];
        int top = -1;


//        stack.push(-1);
        for (int i = 0; i < len; i++) {
            // 需要计算面积最大
            while (top != -1 && heights[stack[top]] >= heights[i]) {
                maxArea = Math.max(heights[stack[top--]] * (i - (top == -1 ? top : stack[top]) - 1), maxArea);
            }
            stack[++top] = i;
        }

        // 需要计算剩下的数据
        while (top != -1) {
            maxArea = Math.max(maxArea, heights[stack[top--]] * (len - (top == -1 ? 0 : stack[top] + 1)));
        }


        return maxArea;
    }
}