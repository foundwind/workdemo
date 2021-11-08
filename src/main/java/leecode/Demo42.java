package leecode;

import java.util.Deque;
import java.util.LinkedList;

public class Demo42 {
//

    public static void main(String[] args) {
        System.out.println(new Demo42().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }


    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    private int cale(int[] height, int left, int right, int max) {
        int total = max * (right - left - 1);
        for (int i = left + 1; i < right; i++) {
            total -= height[i] > max ? max : height[i];
        }
        return total;
    }

}