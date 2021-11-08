package leecode;

import java.util.ArrayList;
import java.util.List;

public class Demo78 {
//

    public static void main(String[] args) {
        new Demo78().subsets(new int[]{1, 2, 3});

    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> cacheList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 必须有第一步
        result.add(new ArrayList<>(0));
        int len = nums.length;
        if (len == 0) return result;
        // 插入全部
        for (int num : nums) {
            cacheList.add(num);
        }
        result.add(new ArrayList<>(cacheList));
        if (len == 1) return result;
        cacheList.clear();
        // 插入单个
        for (int i = 0; i < len; i++) {
            cacheList.add(nums[i]);
            result.add(new ArrayList<>(cacheList));
            cacheList.clear();
        }
        if (len == 2) return result;

        for (int i = 2; i < len; i++) {
            dfs(nums, 0, i);
        }

        return result;
    }

    private void dfs(int[] nums, int start, int deep) {
        if (deep == 0) {
            result.add(new ArrayList<>(cacheList));
            return;
        }
        for (int i = start; i < nums.length - deep + 1; i++) {
            cacheList.add(nums[i]);
            dfs(nums, i + 1, deep - 1);
            cacheList.remove(cacheList.size() - 1);
        }
    }

}