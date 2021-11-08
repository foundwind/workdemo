package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo15 {
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
//
//
//示例 1：
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//示例 2：
//
//输入：nums = []
//输出：[]
//
//示例 3：
//
//输入：nums = [0]
//输出：[]
//


    public static void main(String[] args) {
        List<List<Integer>> lists = new Demo15().threeSum(new int[]{-2,-3,0, 0, -2});
        System.out.println(lists);
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;

        // 0 1 2 3 4 5
        for (int i = 0; i < length - 2; i++) {
            int a = nums[i];
            if (a > 0) {
                return result;
            }

            int l = i + 1;
            int r = length - 1;


            while (l < r) {
                int sum = nums[l] + nums[i] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    result.add(Arrays.asList(a, nums[l], nums[r]));

                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                }
            }


            //往右跑
            while (nums[i + 1] == nums[i] && i < length - 2) i++;
        }
        return result;
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a > 0) {
                return result;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (a + nums[l] + nums[r] > 0) {
                    r--;
                } else if (a + nums[l] + nums[r] < 0) {
                    l++;
                } else {
                    result.add(Arrays.asList(a, nums[l], nums[r]));

                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }

        return result;
    }
}