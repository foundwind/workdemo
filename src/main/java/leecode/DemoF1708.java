package leecode;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoF1708 {
//

    public static void main(String[] args) {
        System.out.println(new DemoF1708().bestSeqAtIndex(new int[]{65, 70, 56, 75, 60, 68},
                new int[]{100, 150, 90, 190, 95, 110}));
    }

    public int bestSeqAtIndex(int[] height, int[] weight) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < height.length; i++) {
            Integer w = map.get(height[i]);
            if (w == null) {
                map.put(height[i], weight[i]);
            } else if (w > weight[i]) {
                map.put(height[i], weight[i]);
            }
        }
        // 找出最长的增加序列
        List<Integer> list = map.values().stream().collect(Collectors.toList());
        return lengthOfLIS(list);
    }

    public int lengthOfLIS(List<Integer> nums) {
        if (nums.size() == 0) {
            return 0;
        }
        int[] dp = new int[nums.size()];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.size(); i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums.get(i) > nums.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }



}