package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo16 {
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//
//
//
//示例：
//
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//
//
//
//提示：
//
//    3 <= nums.length <= 10^3
//    -10^3 <= nums[i] <= 10^3
//    -10^4 <= target <= 10^4

    public static void main(String[] args) {
//        System.out.println(new Demo16().threeSumClosest(new int[]{0,2,1,-3}, 1));
        System.out.println(new Demo16().threeSumClosest(new int[]{-1,2,1,-4}, 1));
//        System.out.println(new Demo16().threeSumClosest(new int[]{-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33}, 0));
    }

    int cache = 0;
    int dif = Integer.MAX_VALUE;
    int cTarget = 0;

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        cTarget = target;

        //总目标
        int min = nums[0] + nums[1] + nums[2];
        int max = nums[length - 1] + nums[length - 2] + nums[length - 3];

        //两个极端场景

        if (target <= min) {
            return min;
        } else if (target >= max) {
            return max;
        }

        int right = length - 1;
        int left = 0;
        int mid = 1;
        //找到右边界
        while (left != right) {
            int sum = nums[left] + nums[mid] + nums[right];
            if (sum == target) return sum;
            check(sum);


            if (mid == left + 1 && sum > target) { // 如果最小都更大，就直接下一个循环
                right--;
                mid = 1;
                left = 0;
            } else {
                if (mid != right - 1) {
                    mid++;
                } else {
                    left++;
                    if (left == right - 1){
                        right--;
                        mid = 1;
                        left = 0;
                    }
                    mid = left + 1;
                }
            }
        }


        return cache;

    }

    /**
     * 当前n    当前最小
     * xx 最小值
     **/

    private void check(int sum) {
        int midDif = Math.abs(cTarget - sum);
        if (midDif < dif) {
            cache = sum;
            dif = midDif;
        }
    }
}