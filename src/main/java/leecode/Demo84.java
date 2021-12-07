package leecode;

import java.util.Stack;

public class Demo84 {
//

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        System.out.println(1);
//        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\QDM\\Desktop\\草稿本.txt")));
//        String s = reader.readLine();
//        int[] ints = Stream.of(s.split(",")).mapToInt(new ToIntFunction<String>() {
//            @Override
//            public int applyAsInt(String value) {
//                return Integer.valueOf(value);
//            }
//        }).toArray();
//        System.out.println(new Demo84().largestRectangleArea(ints));
//        System.out.println(new Demo84().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//        reader.close();
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
                maxArea = Math.max(heights[stack[top--]]*(i - (top == -1 ? top : stack[top]) - 1)  , maxArea);
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