package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo46 {
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
//示例 1：
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//示例 2：
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//示例 3：
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//提示：
//
//    1 <= nums.length <= 6
//    -10 <= nums[i] <= 10
//    nums 中的所有整数 互不相同

    public static void main(String[] args) {
        System.out.println(new Demo46().permute(new int[]{1, 2, 3}));
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0);

        return result;
    }

    private void dfs(int[] nums, int i) {
        if (i == nums.length - 1) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, j, i);
            dfs(nums, i + 1);
            swap(nums, j, i);
        }
    }

    private void swap(int[] nums, int j, int i) {
        int cache = nums[j];
        nums[j] = nums[i];
        nums[i] = cache;
    }


}