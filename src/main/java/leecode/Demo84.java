package leecode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class Demo84 {
//

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\QDM\\Desktop\\草稿本.txt")));
        String s = reader.readLine();
        int[] ints = Stream.of(s.split(",")).mapToInt(new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String value) {
                return Integer.valueOf(value);
            }
        }).toArray();
        System.out.println(new Demo84().largestRectangleArea(ints));
        reader.close();
    }

    // 当前最大面积
    int maxArea = 0;


    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];
        boolean ok = true;
        while (ok) {
            ok = dfs(heights, len);
        }
        return maxArea;
    }

    private boolean dfs(int[] heights, int len) {
        boolean isExChange = false;
        int lastHigh = 0;
        int maxHeight = 0;
        for (int i = 0; i < len; i++) {
            // 往右找和自己不一样的
            int left = i;
            int right = i;
            for (int j = i + 1; j < len; j++) {
                if (heights[j] != heights[i]) {
                    isExChange = true;
                    break;
                }
                // 当有起伏的时候
                right++;
            }
            int area = (right - left + 1) * heights[left];
            maxArea = Math.max(area, maxArea);
            // 如果全部持平，没必要进行下面任何操作
            if (!isExChange) return isExChange;

            // 如果当前值比左右都高，需要平波，变成左右的最高
            int limitHigh = Math.max(lastHigh, right == len - 1 ? 0 : heights[right + 1]);
            if (heights[left] > limitHigh) {
                for (int j = left; j <= right; j++) {
                    heights[left] = limitHigh;
                }
            }
            // 取最高
            maxHeight = Math.max(heights[left], maxHeight);
            lastHigh = heights[left];
        }
        if (maxHeight * len <= maxHeight) return false;
        return isExChange;
    }

}